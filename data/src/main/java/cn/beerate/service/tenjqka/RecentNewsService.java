package cn.beerate.service.tenjqka;

import cn.beerate.common.Message;
import cn.beerate.model.bean.tenjqka.Profile;
import cn.beerate.service.base.BaseCrawlService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.Iterator;


/**
 * 最新动态
 */
@Component
public class RecentNewsService extends BaseCrawlService {
    private final String URL="http://basic.10jqka.com.cn/{code}";

    private Document getDocument(String code){
        return super.getDocument(this.URL.replace("{code}",code), null);
    }

    /**
     * 获取公司概要
     * @param code 股票代码
     * @return Message<Profile>
     */
    public Message<Profile> profile(String code){
        Document document = this.getDocument(code);
        Element body = document.body();
        Elements profileTables= body.select("#profile table.m_table.m_table_db");
        Element table1 = profileTables.first();
        Element table2 = profileTables.last();

        //主营业务
        String zyyw=table1.select("tbody>tr").eq(0).select("td").eq(0).select("span").eq(1).first().text();
        //所属行业
        String sshy=table1.select("tbody>tr").eq(0).select("td").eq(1).select("span").eq(1).first().text();
        //概念强排名弱
        String gnqrpm=table1.select("tbody>tr").eq(1).select("td").eq(0).select("div.f14.newconcept").eq(0).text();
        //财务分析
        String cwfx=null;
        if(table1.select("tbody>tr").eq(1).select("td").size()>1){
            cwfx = table1.select("tbody>tr").eq(1).select("td").eq(1).select("div").eq(1).first().text();
        }

        //市盈率(动态)
        String dtsyl=table2.selectFirst("tbody").children().select("tr").eq(0).select("td").eq(0).select("span").eq(1).text();
        //每股收益
        String mgsy=table2.selectFirst("tbody").children().select("tr").eq(0).select("td").eq(1).select("span").eq(1).text();
        //每股资本公积金
        String mgzbgjj=table2.selectFirst("tbody").children().select("tr").eq(0).select("td").eq(2).select("span").eq(1).text();
        //分类
        String fl=table2.selectFirst("tbody").children().select("tr").eq(0).select("td").eq(3).select("span").eq(1).text();

        //市盈率(静态)
        String jtsyl=table2.selectFirst("tbody").children().select("tr").eq(1).select("td").eq(0).select("span").eq(1).text();
        //营业收入
        String yysr=table2.selectFirst("tbody").children().select("tr").eq(1).select("td").eq(1).select("span").eq(1).text();
        //每股未分配利润
        String mgwfplr=table2.selectFirst("tbody").children().select("tr").eq(1).select("td").eq(2).select("span").eq(1).text();
        //总股本
        String zgb=table2.selectFirst("tbody").children().select("tr").eq(1).select("td").eq(3).select("span").eq(1).text();

        //市净率
        String sjl=table2.selectFirst("tbody").children().select("tr").eq(2).select("td").eq(0).select("span").eq(1).text();
        //净利润
        String jlr=table2.selectFirst("tbody").children().select("tr").eq(2).select("td").eq(1).select("span").eq(1).text();
        //每股经营现金流
        String xjl=table2.selectFirst("tbody").children().select("tr").eq(2).select("td").eq(2).select("span").eq(1).text();
        //总市值
        String zsz=table2.selectFirst("tbody").children().select("tr").eq(2).select("td").eq(3).select("span").eq(1).text();

        //每股净资产
        String mgjzc=table2.selectFirst("tbody").children().select("tr").eq(3).select("td").eq(0).select("span").eq(1).text();
        //毛利率
        String mlr=table2.selectFirst("tbody").children().select("tr").eq(3).select("td").eq(1).select("span").eq(1).text();
        //净资产收益率
        String jzcsyl=table2.selectFirst("tbody").children().select("tr").eq(3).select("td").eq(2).select("span").eq(1).text();
        //流通A股
        String ltAg=table2.selectFirst("tbody").children().select("tr").eq(3).select("td").eq(3).select("span").eq(1).text();

        //最新解禁
        String zxjj=null;
        //解禁股份类型
        String jjgflx=null;
        //解禁数量
        String jjsl=null;
        //占总股本比例
        String zzgbbl=null;
        if(table2.select("tbody>tr").size()>5){
            zxjj=table2.selectFirst("tbody").children().last().previousElementSibling().select("td").eq(0).first().children().eq(1).text();
            jjgflx=table2.selectFirst("tbody").children().last().previousElementSibling().select("td").eq(1).select("span").eq(1).text();
            jjsl=table2.selectFirst("tbody").children().last().previousElementSibling().select("td").eq(2).select("span").eq(1).text();
            zzgbbl=table2.selectFirst("tbody").children().last().previousElementSibling().children().eq(3).first().children().eq(1).text();
        }

        //更新日期
        String gxsj=table2.selectFirst("tbody").children().last().select("td").eq(0).select("span").eq(1).text();
        //总质押股份数量
        String zzygfsl=table2.selectFirst("tbody").children().last().select("td").eq(1).select("span").eq(1).text();
        //质押股份占A股总股本比
        String zygfzAgzgbz=table2.selectFirst("tbody").children().last().children().eq(2).select("span").eq(1).text();

        Profile profile = new Profile();
        profile.setZyyw(zyyw);
        profile.setSshy(sshy);
        profile.setGnqrpm(gnqrpm);
        profile.setCwfx(cwfx);

        profile.setDtsyl(dtsyl);
        profile.setMgsy(mgsy);
        profile.setMgzbgjj(mgzbgjj);
        profile.setFl(fl);

        profile.setJtsyl(jtsyl);
        profile.setYysr(yysr);
        profile.setMgwfplr(mgwfplr);
        profile.setZgb(zgb);

        profile.setSjl(sjl);
        profile.setJlr(jlr);
        profile.setXjl(xjl);
        profile.setZsz(zsz);

        profile.setMgjzc(mgjzc);
        profile.setMlr(mlr);
        profile.setJzcsyl(jzcsyl);
        profile.setLtAg(ltAg);

        profile.setZxjj(zxjj);
        profile.setJjgflx(jjgflx);
        profile.setJjsl(jjsl);
        profile.setZzgbbl(zzgbbl);

        profile.setGxsj(gxsj);
        profile.setZzygfsl(zzygfsl);
        profile.setZygfzAgzgbz(zygfzAgzgbz);

        System.out.println(profile);
        return Message.success(profile);

    }

    /**
     * 获取公司概要
     * @param code 股票代码
     * @return Message<Profile>
     */
    public Message pointNew(String code){
        Document document = this.getDocument(code);
        Element body = document.body();
        Elements elementsTable = body.getElementsByTag("table");

        Element elementTable = elementsTable.eq(4).first();
        Elements elementsTr = elementTable.getElementsByTag("tr");

        Iterator<Element> iterator = elementsTr.iterator();
        while (iterator.hasNext()){
            Element elementTr = iterator.next();
            Elements elementTd = elementTr.getElementsByTag("td");
            //时间
            System.out.println(elementTd.first().text());
            //类型
            System.out.println(elementTd.last().text());
        }
        return null;
    }

}
