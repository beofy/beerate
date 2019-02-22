package cn.beerate.service.cninfo;

import cn.beerate.common.util.DynamicCrawler;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.dao.cninfo.StockDisclosureDao;
import cn.beerate.model.entity.t_stock_disclosure;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.util.*;

/**
 * 巨潮公告
 */
@Component
public class DisclosureService {

    private Log logger = LogFactory.getLog(DisclosureService.class);

    @Autowired
    private StockDisclosureDao stockDisclosureDao;

    /** PDF公告地址 */
    private  final String PDF_URL="http://static.cninfo.com.cn/finalpage/{announcementTime}/{announcementId}.PDF";

    /** 公告详情地址 */
    private  final String DETAIL_PDF_URL="http://www.cninfo.com.cn/new/disclosure/detail?plate={plate}&stockCode={stockCode}&announcementId={announcementId}&announcementTime={announcementTime}";

    /** 公告地址 */
    private final String TEMPLATE_URL="http://www.cninfo.com.cn/new/disclosure/stock?plate={plate}&stockCode={stockCode}";

    /**
     * 根据股票代码获取巨潮公告地址<br/>
     *  深市  :    szse<br/>
     *  沪市  :    sse<br/>
     * @param code 股票代码
     * @return String
     */
    public String getUrl(String code){
        //深交所
        if(code.matches("^(000|002|300)[\\d]{3}$"))
            return this.TEMPLATE_URL.replace("{plate}","szse").replace("{stockCode}",code);

        //上交所
        if(code.matches("^(600|601|603)[\\d]{3}$"))
            return this.TEMPLATE_URL.replace("{plate}","sse").replace("{stockCode}",code);

        return "";
    }

    /**
     * 根据股票代码获取交易所代码<br/>
     *  深市  :    szse<br/>
     *  沪市  :    sse<br/>
     * @param code 股票代码
     * @return String
     */
    public String getPlateByStockCode(String code){
        //深交所
        if(code.matches("^(000|002|300)[\\d]{3}$"))
            return "szse";

        //上交所
        if(code.matches("^(600|601|603)[\\d]{3}$"))
            return "sse";

        return "";
    }

    /**
     * 获取该股票号所有公告
     * @param code 股票代码
     */
    public void getCurrDisclosures(String code){
        String url = getUrl(code);
        DynamicCrawler dynamicCrawler = DynamicCrawler.getInstance();
        HtmlPage homePage = dynamicCrawler.getHomePage(url);

        //点击公告搜索按钮
        dynamicCrawler.executeJavaScript("javascript:document.getElementsByClassName('sub-more page-more-filter')[0].click();");

        //获取数据总条数
        String strTotals = Jsoup.parse(homePage.asXml()).body().selectFirst("div.page-action-info-search").text().replace(" ","");
        String pageTotals = strTotals.replaceAll("\\D","");

        //获取最后一页数
        String currPageStr = Jsoup.parse(homePage.asXml()).body().select("li.page-tabs-list.active").last().text();
        int currPage = Integer.parseInt(currPageStr);
        logger.info("获取数据总条数:" +pageTotals+",总页数："+currPage);

        //跳转至最后一页
        dynamicCrawler.executeJavaScript(" document.getElementsByClassName('page-tabs-list sub-end')[1].click();");

        //从最后一页保存
        for (int i = 1; i <= currPage; i++){
            //获取当前页table数据
            Elements elementsTr = Jsoup.parse(homePage.asXml()).body().selectFirst(".stock-search").children().eq(3).first().getElementsByTag("tr");

            //当前页数据条数
            int pageSize = elementsTr.size()-1;
            logger.info("第"+(currPage-i+1)+"页，数据条数:" +pageSize);

            ArrayList<t_stock_disclosure> stockDisclosureList = new ArrayList<>();

            //最后一个数据开始取,i1 = 0 为标题栏不取
            for (int i1 =pageSize; i1>=1; i1--) {
                //公告名称
                String disclosure_title = elementsTr.eq(i1).first().children().first().text();
                //公告时间
                String disclosure_time = elementsTr.eq(i1).first().children().last().children().last().text();
                //公告id
                String announcementId = elementsTr.eq(i1).first().children().first().children().first().attr("data-id");
                //公告详情地址
                String disclosure_detail_url = DETAIL_PDF_URL
                        .replace("{plate}",getPlateByStockCode(code))
                        .replace("{stockCode}",code)
                        .replace("{announcementId}",announcementId)
                        .replace("{announcementTime}",disclosure_time);
                //查找公告内容
                Map<String,String> map = getPdfOrCentent(disclosure_detail_url);

                //存入对象
                t_stock_disclosure stockDisclosure = new t_stock_disclosure();
                stockDisclosure.setAnnouncementTime(disclosure_time);
                stockDisclosure.setTitle(disclosure_title);
                stockDisclosure.setStockCode(code);
                stockDisclosure.setAnnouncementId(announcementId);
                stockDisclosure.setDetail_url(disclosure_detail_url);
                stockDisclosure.setPdf_url(map.get("pdf_url"));
                stockDisclosure.setAnnouncementContent(map.get("announcementContent"));

                //存入集合
                stockDisclosureList.add(stockDisclosure);
            }

            //保存当前页数据
            stockDisclosureDao.saveAll(stockDisclosureList);

            //上一页
            dynamicCrawler.executeJavaScript("javascript:document.getElementsByClassName('page-tabs-list sub-prev')[1].click();");
        }

        //关闭client
        dynamicCrawler.getWebClient().close();
    }

    /**
     *  获取详情页pdf文件地址，或者公共内容（html标签）
     * @param detail_url 详情页地址
     * @return Map<String,String>
     */

    public Map<String,String> getPdfOrCentent(String detail_url){
        Map<String,String> map = new HashMap<>();
        map.put("pdf_url","");
        map.put("announcementContent","");
        DynamicCrawler dynamicCrawler =null;
        try {
            dynamicCrawler = DynamicCrawler.getInstance();
            HtmlPage homePage = dynamicCrawler.getHomePage(detail_url);
            Element body = Jsoup.parse(homePage.asXml());

            //获取pdf地址
            Element pdfTag = body.selectFirst("a.page-filedetail-fullscreen");
            if(pdfTag!=null){
                map.put("pdf_url",pdfTag.attr("href"));
                return map;
            }

            //获取文本内容
            Element contentDiv = body.selectFirst("div.sub-content");
            if(contentDiv!=null){
                map.put("announcementContent",contentDiv.html());
                return map;
            }

        } catch (Exception e) {

           logger.error("打开获取详情页",e);
        }finally {
            //关闭client
            dynamicCrawler.getWebClient().close();
        }

        return map;
    }

    /**
     * 批量更新公告数据
     */
    public void updateDisclosure(){
        for (String code1 : StockCodeUtil.getStockCode()) {
            String munberCode = StockCodeUtil.getNumberStockCode(code1);
        }
    }
}
