package cn.beerate.service.base;

import cn.beerate.common.Message;
import cn.beerate.common.util.Crawler;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.jnlp.IntegrationService;
import java.util.Map;

public class BaseCrawlService {

    private static Log log  = LogFactory.getLog(IntegrationService.class);

    //错误代码
    private static int ERROR=-1;

    public Message<String> crawl(String url, Map<String,String> params){
        String result =  Crawler.getInstance().getString(url,params);

        log.debug(result);

        //判断股票代码是否正确
        JSONObject jsonObject = JSONObject.parseObject(result);
        if(jsonObject.getIntValue("status")==ERROR){
            Message<String> message = Message.error(jsonObject.getString("message"));
            message.setData(result);
            return message;
        }

        return Message.success(result);
    }

}
