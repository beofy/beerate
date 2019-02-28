package cn.beerate.service.cninfo;

import cn.beerate.common.util.Crawler;
import cn.beerate.common.util.DateUtil;
import cn.beerate.common.util.DynamicCrawler;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.dao.cninfo.StockAnnouncementDao;
import cn.beerate.dao.cninfo.StockDisclosureDao;
import cn.beerate.model.bean.cninfo.AnnouncementsBean;
import cn.beerate.model.entity.cninfo.t_stock_announcement;
import cn.beerate.model.entity.cninfo.t_stock_disclosure;
import cn.beerate.service.base.BaseCrawlService;
import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Logger;

/**
 * 巨潮公告
 */
@Component
public class DisclosureService extends BaseCrawlService {

    private Log logger = LogFactory.getLog(DisclosureService.class);

    @Autowired
    private StockDisclosureDao stockDisclosureDao;

    @Autowired
    private StockAnnouncementDao stockAnnouncementDao;

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
    private String getUrl(String code){
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
    private String getPlateByStockCode(String code){
        //深交所
        if(code.matches("^(000|002|300)[\\d]{3}$"))
            return "szse";

        //上交所
        if(code.matches("^(600|601|603)[\\d]{3}$"))
            return "sse";

        return "";
    }

    /**
     * 保存该股票号所有公告<br>
     * htmlunit模拟浏览器行为，效率非常慢，但方法通用
     * @param code 股票代码
     */
    @Deprecated
    public void getCurrDisclosures(String code){
        String url = getUrl(code);
        DynamicCrawler dynamicCrawler = DynamicCrawler.getInstance();
        HtmlPage homePage = dynamicCrawler.getHomePage(url);

        //点击公告搜索按钮
        dynamicCrawler.executeJavaScript("javascript:document.getElementsByClassName('sub-more page-more-filter')[0].click();");
        //跳转至最后一页
        dynamicCrawler.executeJavaScript("javascript:document.getElementsByClassName('page-tabs-list sub-end')[1].click();");

        //获取数据总条数
        String strTotals = Jsoup.parse(homePage.asXml()).body().selectFirst("div.page-action-info-search").text().replace(" ","");
        String pageTotals = strTotals.replaceAll("\\D","");

        //获取最后一页数
        String currPageStr = Jsoup.parse(homePage.asXml()).body().select("li.page-tabs-list.active").last().text();
        int currPage = Integer.parseInt(currPageStr);
        logger.info("获取数据总条数:" +pageTotals+",总页数："+currPage);

        //查询已存数据
        String[] announcementIdArr= stockDisclosureDao.getAllannouncementId(code);
        Map<String,String> announcementIdMap = new HashMap<>();
        if(announcementIdArr.length!=0) {
            for (String s : announcementIdArr) {
                announcementIdMap.put(s,"");
            }
        }

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

                //判断当前数据时候存在
                if(announcementIdMap.get(announcementId)==null){
                    //存入集合
                    stockDisclosureList.add(stockDisclosure);
                }
            }

            //保存当前页数据，此处没有事务，直接保存数据
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
            if(dynamicCrawler!=null){
                dynamicCrawler.getWebClient().close();
            }
        }

        return map;
    }

    /**
     * 批量更新公告数据
     */
    @Deprecated
    public void updateDisclosure(){
        for (String code1 : StockCodeUtil.getStockCode()) {
            String numberCode = StockCodeUtil.getNumberStockCode(code1);
            getCurrDisclosures(numberCode);
        }
    }

    /**
     * 获取第几页公告数据<br/>
     * @param code 股票代码
     * @param currPage 当前页
     * @param pageSize 每页条数
     * @param searchkey  查询条件如下：<br/>
     * 年报 - category_ndbg_szsh<br/>
     * 半年报 - category_bndbg_szsh<br/>
     * 一季报 - category_yjdbg_szsh<br/>
     * 三季报 - category_sjdbg_szsh<br/>
     * 业绩预告 - category_yjygjxz_szsh<br/>
     * 权益分派 - category_qyfpxzcs_szsh<br/>
     * 董事会 - category_dshgg_szsh<br/>
     * 监事会 - category_jshgg_szsh<br/>
     * 股东大会 - category_gddh_szsh<br/>
     * 日常经营 - category_rcjy_szsh<br/>
     * 公司治理 - category_gszl_szsh<br/>
     * 中介报告 - category_zj_szsh<br/>
     * 首发 - category_sf_szsh<br/>
     * 增发 - category_zf_szsh<br/>
     * 股权激励 - category_gqjl_szsh<br/>
     * 配股 - category_pg_szsh<br/>
     * 解禁 - category_jj_szsh<br/>
     * 债券 - category_zq_szsh<br/>
     * 其他融资 - category_qtrz_szsh<br/>
     * 股权变动 - category_gqbd_szsh<br/>
     * 补充更正 - category_bcgz_szsh<br/>
     * 澄清致歉 - category_cqdq_szsh<br/>
     * 风险提示 - category_fxts_szsh<br/>
     * 特别处理和退市 - category_tbclts_szsh<br/>
     * 使用：多字段中间用;分割
     * @param beginDate 开始时间
     * @param endDate 结束时间
     * @return AnnouncementsBean
     */
    public AnnouncementsBean getFirstAnnouncementsBean(String code, int currPage,int pageSize, String searchkey, String beginDate, String endDate){
        String url = "http://www.cninfo.com.cn/new/hisAnnouncement/query";

        //header参数
        Map<String,String> header = new HashMap<>();
        header.put("Content-Type","application/x-www-form-urlencoded");

        //参数
        Map<String,String> data = new HashMap<>();
        data.put("pageNum",String.valueOf(currPage));
        data.put("pageSize",String.valueOf(pageSize));
        data.put("tabName","fulltext");
        data.put("column",getPlateByStockCode(code));
        data.put("stock",code);
        data.put("searchkey",searchkey);
        data.put("secid","");
        data.put("plate","");
        data.put("category","");
        data.put("seDate",beginDate+" ~ "+endDate);
        Document document = null;
        try {
            document = Crawler.getInstance().getConnect(url).data(data)
                    .headers(header)
                    .ignoreContentType(true)
                    .post();
        } catch (IOException e) {
            logger.error("巨潮api接口获取公告数据异常",e);
            AnnouncementsBean announcementsBean = new AnnouncementsBean();
            announcementsBean.setAnnouncements(new ArrayList<>());
            announcementsBean.setHasMore(false);
            return announcementsBean;
        }

        try {
            String result = document.text();
            JSONObject jsonObject = JSONObject.parseObject(result);
            return jsonObject.toJavaObject(AnnouncementsBean.class);
        } catch (Exception e) {
            logger.error("数据转换json异常:result",e);
            AnnouncementsBean announcementsBean = new AnnouncementsBean();
            announcementsBean.setAnnouncements(new ArrayList<>());
            announcementsBean.setHasMore(false);
            return announcementsBean;
        }
    }

    /**
     * 根据api接口获取股票号所有公告数据<br/>
     */
    public List<t_stock_announcement> getCurrDisclosuresByApi(String code, int currPage,int pageSize ,String searchkey, String beginDate, String endDate, Map<String,String> announcementIdMap){
        AnnouncementsBean announcementsBean = getFirstAnnouncementsBean(code,currPage,pageSize,searchkey, beginDate,endDate);

        //查询的公告，默认按照最新时间靠前，从时间靠前依次往后判断，当已存数据的announcementIdMap(该股票号的所有announcementId)能取到时,则返回(退出递归)
        for (t_stock_announcement announcement : announcementsBean.getAnnouncements()) {
            //已存的announcementId
            String announcementId = announcementIdMap.get(announcement.getAnnouncementId());
            if(announcementId==""){
                //设置没有下一页数据
                announcementsBean.setHasMore(false);
                return announcementsBean.getAnnouncements();
            }
        }

        int nextPage = currPage + 1;
        //没有下一页数据
        if(!announcementsBean.isHasMore()){
           return announcementsBean.getAnnouncements();
        }else{
            List<t_stock_announcement> stockAnnouncementList = getCurrDisclosuresByApi(code,nextPage,pageSize,searchkey,beginDate,endDate, announcementIdMap);
            announcementsBean.getAnnouncements().forEach(stockAnnouncement -> { stockAnnouncementList.add(stockAnnouncement);});
            return stockAnnouncementList;
        }

    }

    /**
     * 批量更新公告数据
     */
    public void updateDisclosureByApi(){
        for (String code1 : StockCodeUtil.getStockCode()) {
            String numberCode = StockCodeUtil.getNumberStockCode(code1);
            String[] announcementIdArr = stockAnnouncementDao.getAllannouncementId(numberCode);
            AnnouncementsBean announcementsBean = getFirstAnnouncementsBean(numberCode,1,30,"","2000-01-01", DateUtil.dateToString(new Date(),"yyyy-MM-dd"));

            //没有新出公告
            if(announcementIdArr.length==announcementsBean.getTotalRecordNum()){
                logger.info("股票代码："+numberCode+"，没有新出公告");
            }else{
                //将announcementId保存为map的key
                Map<String,String> announcementIdMap = new HashMap<>();
                for (String s : announcementIdArr) {
                    announcementIdMap.put(s,"");
                }

                //新出的公告
                List<t_stock_announcement> stockAnnouncementList =getCurrDisclosuresByApi(numberCode,1,30,"","2000-01-01", DateUtil.dateToString(new Date(),"yyyy-MM-dd"),announcementIdMap);

                List<t_stock_announcement> stockAnnouncementList1 = new ArrayList<>();
                stockAnnouncementList.forEach(stockAnnouncement -> {
                   String announcementId = announcementIdMap.get(stockAnnouncement.getAnnouncementId());
                   if(announcementId==null){
                       stockAnnouncementList1.add(stockAnnouncement);
                   }
                });

                //保存新出的公告，此处没事务,直接保存数据库
                stockAnnouncementDao.saveAll(stockAnnouncementList1);
                logger.info("股票代码："+numberCode+"，新出公告已更新");
            }
        }
    }
}
