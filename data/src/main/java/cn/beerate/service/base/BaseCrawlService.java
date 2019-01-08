package cn.beerate.service.base;

import cn.beerate.common.Message;
import cn.beerate.common.util.Crawler;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.helper.StringUtil;

import javax.jnlp.IntegrationService;
import java.util.HashMap;
import java.util.Map;

public class BaseCrawlService {

    private static Log log  = LogFactory.getLog(IntegrationService.class);

    public Message<String> crawl(String url, Map<String,String> params){
        String result =  Crawler.getInstance().getString(url,params);

        log.debug(result);

        //判断股票代码是否正确
        JSONObject jsonObject = JSONObject.parseObject(result);
        if(!StringUtil.isBlank(jsonObject.getString("status"))){
            Message<String> message = Message.error("股票代码不合法");
            message.setData(result);
            return message;
        }

        return Message.success(result);
    }



}
