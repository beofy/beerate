package cn.beerate.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Crawler {
    private Log log = LogFactory.getLog(Crawler.class);

    public static Crawler getInstance(){
        return new Crawler();
    }

    public Connection getConnect(String url){
        return   Jsoup.connect(url);
    }

    public Connection.Response getResponse(String url,Map<String,String> params){
        Connection.Response response = null;
        try {
            Connection connection = this.getConnect(url);
            connection .ignoreContentType(true);

            //无参数
            if(params!=null&&!params.isEmpty()){
                connection .data(params);
            }

            response= connection.execute();
        } catch (IOException e) {
            log.warn(e.getMessage(),e);
        }
        return response;
    }

    public String getString(String url, Map<String,String> params){
        return this.getResponse(url,params).body();
    }

    public Document getDocument(String url, Map<String,String> params){
        try {
            return this.getResponse(url,params).parse();
        } catch (IOException e) {
            log.warn(e.getMessage(),e);
            return null;
        }
    }

    public Document getDocument(String url){
        try {
            return this.getResponse(url,null).parse();
        } catch (IOException e) {
            log.warn(e.getMessage(),e);
            return null;
        }
    }

    /**
     * 获取html页面内容
     * @param url
     * @return
     */
    public String getHtml(String url){
        return this.getDocument(url,null).outerHtml();
    }

    /**
     * 获取html页面内容
     * @param url
     * @param params
     * @return String
     */
    public String getHtml(String url,Map<String,String> params){
        return this.getDocument(url,params).outerHtml();
    }

    /**
     * 获取所有的隐藏区域元素
     * @param url
     * @param params
     * @return
     */
    public Map<String,String> getHidden(String url, Map<String,String> params){
        Document document=  this.getDocument(url,params);
        //所有隐藏域元素
        Elements input_hiddens = document.select("input[type=hidden]");

        Iterator<Element> iterator = input_hiddens.iterator();

        Map<String,String> map  = new HashMap<String,String>();
        while (iterator.hasNext()){
            Element element = iterator.next();
            String key = element.attr("id");
            String value=element.attr("value");
            //存入map
            map.put(key,value);
        }
        return map;
    }
    /**
     * 获取所有的隐藏区域元素
     * @param url
     * @return
     */
    public Map<String,String> getHidden(String url){
       return this.getHidden(url,null);
    }


    public static void main(String[] args) {
//        Map<String,String> params = new HashMap<String,String>();
//        params.put("code","SZ000001");
//        String result = Crawler.getInstance().getString("http://emweb.securities.eastmoney.com/ShareholderResearch/ShareholderResearchAjax",params);
//        System.out.println(result);

//       String html = Crawler.getInstance().getHtml("http://emweb.securities.eastmoney.com/NewFinanceAnalysis/Index?type=soft&code=SZ000001");
//       System.out.println(html);

        Map map = Crawler.getInstance().getHidden("http://emweb.securities.eastmoney.com/NewFinanceAnalysis/Index?type=soft&code=SZ000001");


    }

}
