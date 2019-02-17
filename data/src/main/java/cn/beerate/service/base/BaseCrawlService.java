package cn.beerate.service.base;

import cn.beerate.common.util.Crawler;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import springfox.documentation.spring.web.json.Json;

import java.util.HashMap;
import java.util.Map;

public class BaseCrawlService {

    private static Log log  = LogFactory.getLog(BaseCrawlService.class);

    /**
     * 请求数据
     * @param url 请求地址
     * @param params 参数
     * @return String
     */
    protected Object crawl(String url, Map<String,String> params){
        String result =  Crawler.getInstance().getString(url,params);
        //log.debug(result);

        //判断数据是否异常.并去除字符串中转义字符
        return JSON.parse(result);
    }

    /**
     * 获取字符串
     * @param url 请求地址
     * @param params 参数
     * @return String
     *
     */
    public String getText(String url, Map<String,String> params){
        Object object =  this.crawl(url,params);
        return object.toString();
    }

    /**
     * 获取json
     * @param url 请求地址
     * @param params 参数
     * @return String
     *
     */
    public JSON getJsonObject(String url, Map<String,String> params){
        return (JSONObject) this.crawl(url,params);
    }

    /**
     * 获取jsonArray
     * @param url 请求地址
     * @param params 参数
     * @return String
     */
    public JSONArray getJsonArray(String url, Map<String,String> params){
        Object object = this.crawl(url,params);
        return (JSONArray) object;
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
