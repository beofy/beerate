package cn.beerate.service.tenjqka;

import cn.beerate.common.util.DynamicCrawler;
import cn.beerate.common.util.StringUtils;
import cn.beerate.model.bean.tenjqka.DetailThshy;
import cn.beerate.model.bean.tenjqka.Thshy;
import cn.beerate.service.base.BaseCrawlService;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ThshyService extends BaseCrawlService {


    /**
     * 同花顺行业一览表
     * @param field 排序类型<br>
     *              行业涨跌幅--199112<br>
     *              总成交量（万手）-- 13<br>
     *              总成交额（亿元）-- 19<br>
     *              净流入（亿元）-- zjjlr<br>
     *              均价 -- 330184
     * @param order 排序方式 desc--降序 | asc--升序
     * @param page 页数
     */
    public List<Thshy> indexThshy(String field, String order, String page){
        String urlTemplate="http://q.10jqka.com.cn/thshy/index/field/{field}/order/{order}/page/{page}/ajax/1/";
        String url = urlTemplate.replace("{field}",field)
                .replace("{order}",order)
                .replace("{page}",page);

        DynamicCrawler dynamicCrawler = DynamicCrawler.getInstance();
        HtmlPage htmlPage = dynamicCrawler.getHomePage(url);
        Document document = Jsoup.parse(htmlPage.asXml());
        Element body = document.body();

        //选择table.tbody里面的所有tr
        Elements elementsTr = body.select("tbody>tr");

        List<Thshy> thshyList = new ArrayList<>();
        elementsTr.forEach(element -> {
            Thshy thshy= new Thshy();
            thshy.setXh(element.children().eq(0).text());//序号
            thshy.setBk(element.children().eq(1).text());//板块

            String bk_href = element.children().eq(1).first().children().first().attr("href");
            String bk_code= StringUtils.getStrByRegx("\\d{6}",bk_href).get(0);
            thshy.setBk_code(bk_code);//板块代码

            thshy.setHyzdf_bfb(element.children().eq(2).text());//行业涨跌幅
            thshy.setZcjl(element.children().eq(3).text());//总成交量
            thshy.setZcje(element.children().eq(4).text());//总成交额
            thshy.setJlr(element.children().eq(5).text());//净流入
            thshy.setSzjs(element.children().eq(6).text());//上涨家数
            thshy.setXdjs(element.children().eq(7).text());//下跌家数
            thshy.setJj(element.children().eq(8).text());//均价
            thshy.setLzg_name(element.children().eq(9).text());//领涨股名称

            String code_href = element.children().eq(9).first().children().first().attr("href");
            String lcg_code= StringUtils.getStrByRegx("\\d{6}",code_href).get(0);
            thshy.setLzg_code(lcg_code);//领涨股代码

            thshy.setLzg_zxj(element.children().eq(10).text());//领涨股最新价
            thshy.setLzg_zdf(element.children().eq(11).text());//领涨股涨跌幅

            //存入集合
            thshyList.add(thshy);
        });

        return thshyList;
    }

    /**
     * 行业详情涨跌排行榜
     * @param field 排序类型<br>
     *              现价--10 <br>
     *              涨跌幅(%)--199112 <br>
     *              涨跌--264648 <br>
     *              涨速(%)-- 48	<br>
     *              换手(%)-- 1968584 <br>
     *              量比-- 1771976 <br>
     *              振幅(%)-- 526792 <br>
     *              成交额-- 19	<br>
     *              流通股-- 407	<br>
     *              流通市值-- 3475914	<br>
     *              市盈率-- 2034120 <br>
     * @param order 排序方式 desc--降序 | asc--升序
     * @param page 页数
     * @param code 行业代码
     */
    public List<DetailThshy> detailThshy(String field, String order, String page, String code){
        String urlTemplate = "http://q.10jqka.com.cn/thshy/detail/field/{field}/order/{order}/page/{page}/ajax/1/code/{code}";

        String url = urlTemplate.replace("{field}",field)
                .replace("{order}",order)
                .replace("{page}",page)
                .replace("{code}",code);

        DynamicCrawler dynamicCrawler = DynamicCrawler.getInstance();
        HtmlPage htmlPage = dynamicCrawler.getHomePage(url);
        Document document = Jsoup.parse(htmlPage.asXml());
        Element body = document.body();

        //选择table.tbody里面的所有tr
        Elements elementsTr = body.select("tbody>tr");

        List<DetailThshy> detailThshyList = new ArrayList<>();
        elementsTr.forEach(element -> {
            DetailThshy detailThshy = new DetailThshy();
            detailThshy.setXh(element.children().eq(0).text());//序号
            detailThshy.setDm(element.children().eq(1).text());//代码
            detailThshy.setMc(element.children().eq(2).text());//名称
            detailThshy.setXj(element.children().eq(3).text());//现价
            detailThshy.setZdf(element.children().eq(4).text());//涨跌幅(%)
            detailThshy.setZd(element.children().eq(5).text());//涨跌
            detailThshy.setZs(element.children().eq(6).text());//涨速(%)
            detailThshy.setHs(element.children().eq(7).text());//换手(%)
            detailThshy.setLb(element.children().eq(8).text());//量比
            detailThshy.setZf(element.children().eq(9).text());//振幅(%)
            detailThshy.setCje(element.children().eq(10).text());//成交额
            detailThshy.setLtg(element.children().eq(11).text());//流通股
            detailThshy.setLtsz(element.children().eq(12).text());//流通市值
            detailThshy.setSyl(element.children().eq(13).text());//市盈率

            //存入集合
            detailThshyList.add(detailThshy);
        });

        return detailThshyList;
    }

}
