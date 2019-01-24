package cn.beerate.service.base;

import cn.beerate.common.Message;
import cn.beerate.common.util.Crawler;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

public class BaseCrawlService {

    private static Log log  = LogFactory.getLog(BaseCrawlService.class);

    //错误代码
    protected Message<String> crawl(String url, Map<String,String> params){
        String result =  Crawler.getInstance().getString(url,params);

        log.debug(result);

        //判断数据是否异常
        Object object = JSONObject.parse(result);

        //如果是jsonObject，判断是否
        if(object instanceof com.alibaba.fastjson.JSONObject){
            JSONObject jsonObject = ((JSONObject) object);
            if(jsonObject.getIntValue("status")==Message.Code.ERROR){
                Message<String> message = Message.error(jsonObject.getString("message"));
                message.setData(result);
                return message;
            }
        }

        return Message.success(result);
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
