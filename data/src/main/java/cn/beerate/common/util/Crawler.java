package cn.beerate.common.util;

import cn.beerate.service.CompanySurveyService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Crawler {
    private Log log = LogFactory.getLog(CompanySurveyService.class);

    public Connection getConnect(String url){
        return   Jsoup.connect(url);
    }


    public String getString(String url, Map<String,String> params){
        String string=null;
        try {
            string= getConnect(url)
                    .data(params)
                    .ignoreContentType(true)
                    .execute()
                    .body();
        } catch (IOException e) {
            log.warn(e.getMessage());
        }

        return string;
    }

    public static Crawler getInstance(){
        return new Crawler();
    }


    public static void main(String[] args) {
        Map<String,String> params = new HashMap<String,String>();
        params.put("code","SZ000001");
        String result = Crawler.getInstance().getString("http://emweb.securities.eastmoney.com/ShareholderResearch/ShareholderResearchAjax",params);
        System.out.println(result);
    }

}
