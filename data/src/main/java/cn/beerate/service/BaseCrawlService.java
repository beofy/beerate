package cn.beerate.service;

import cn.beerate.common.util.Crawler;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.Map;

public class BaseCrawlService {

    private final static Log logger  = LogFactory.getLog(BaseCrawlService.class);

    /**
     * 请求数据
     * @param url 请求地址
     * @param params 参数
     * @return String
     */
    private String request(String url, Map<String,String> params){
        return Crawler.getInstance().getString(url,params);
    }

    /**
     * 获取页面html字符
     * @param url 请求地址
     * @param params 参数
     * @return String
     */
    protected String getHtml(String url, Map<String,String> params){

        return this.getDocument(url,params).outerHtml();
    }

    protected Document getDocument(String url, Map<String,String> params){

        return Crawler.getInstance().getDocument(url,params);
    }

    /**
     * 获取jsonObject
     * @param url 请求地址
     * @param params 参数
     * @return String
     */
    protected String getJsonString(String url, Map<String,String> params){
        try{
            String text = this.request(url,params);
            String title = Jsoup.parse(text).body().getElementsByTag("title").text();
            if(title.equals("无F10资料")){
                return "{\"status\":\"-1\",\"message\":\"无F10资料\"}";
            }

            //解析json，并去除转义字符
            Object o = JSON.parse(text);

            return o.toString();
        }catch (Exception e){
            logger.info("json string parse was exception",e);

            return null;
        }
    }

    /**
     * 获取jsonObject
     * @param url 请求地址
     * @param params 参数
     * @return String
     *
     */
    protected JSONObject getJsonObject(String url, Map<String,String> params){
        String jsonObject = this.getJsonString(url,params);

        return JSONObject.parseObject(jsonObject);
    }

    /**
     * 获取jsonArray
     * @param url 请求地址
     * @param params 参数
     * @return String
     */
    protected JSONArray getJsonArray(String url, Map<String,String> params){
        String jsonArray = this.getJsonString(url,params);

        return JSONArray.parseArray(jsonArray);
    }

    /**
     * 获取icode
     * @param stockCode 股票代码
     * @return String
     */
    protected String getICode(String url,String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("type","soft");
        params.put("code",stockCode);

        Map<String,String> map = Crawler.getInstance().getHidden(url,params);
        if(map==null||map.isEmpty()){
            return "";
        }

        return map.get("hidIndustryCode");
    }


    /**
     * 获取companyType
     * @param stockCode 股票代码
     * @return String
     */
    protected String getCompanyType(String url,String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("type","soft");
        params.put("code",stockCode);

        Map<String,String> map = Crawler.getInstance().getHidden(url,params);
        if(map==null||map.isEmpty()){
            return "";
        }

        return map.get("hidctype");
    }

}
