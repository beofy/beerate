package cn.beerate.service.tenjqka;

import cn.beerate.common.Message;
import cn.beerate.common.util.Crawler;
import cn.beerate.model.bean.tenjqka.Profile;
import cn.beerate.service.base.BaseCrawlService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
        Elements elementsA =  body.getElementsByTag("a");
        Elements elementsSpan =  body.getElementsByTag("span");
        Elements elementsDiv =  body.getElementsByTag("div");

        //主营业务
        String zyyw=elementsA.eq(36).attr("title");
        //所属行业
        String sshy=elementsSpan.eq(7).text();
        //概念强排名弱
        String gnqrpm=elementsDiv.eq(34).text();

        //市盈率(动态)
        String dtsyl=elementsSpan.eq(9).text();
        //每股收益
        String mgsy=elementsSpan.eq(11).text();
        //每股资本公积金
        String mgzbgjj=elementsSpan.eq(18).text();
        //分类
        String fl=elementsSpan.eq(25).text();

        //市盈率(静态)
        String jtsyl=elementsSpan.eq(27).text();
        //营业收入
        String yysr=elementsSpan.eq(29).text();
        //每股未分配利润
        String mgwfplr=elementsSpan.eq(36).text();
        //总股本
        String zgb=elementsSpan.eq(43).text();

        //市净率
        String sjl=elementsSpan.eq(45).text();
        //净利润
        String jlr=elementsSpan.eq(47).text();
        //每股经营现金流
        String xjl=elementsSpan.eq(54).text();
        //总市值
        String zsz=elementsSpan.eq(61).text();

        //每股净资产
        String mgjzc=elementsSpan.eq(63).text();
        //毛利率
        String mlr=elementsSpan.eq(70).text();
        //净资产收益率
        String jzcsyl=elementsSpan.eq(77).text();
        //流通A股
        String ltAg=elementsSpan.eq(84).text();

        //最新解禁
        String zxjj=elementsSpan.eq(87).text();
        //解禁股份类型
        String jjgflx=elementsSpan.eq(89).text();
        //解禁数量
        String jjsl=elementsSpan.eq(91).text();
        //占总股本比例
        String zzgbbl=elementsSpan.eq(95).text();

        //更新日期
        String gxsj=elementsSpan.eq(98).text();
        //总质押股份数量
        String zzygfsl=elementsSpan.eq(100).text();
        //质押股份占A股总股本比
        String zygfzAgzgbz=elementsSpan.eq(104).text();

        Profile profile = new Profile();
        profile.setZyyw(zyyw);
        profile.setSshy(sshy);
        profile.setGnqrpm(gnqrpm);

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
