package cn.beerate.service;

import cn.beerate.common.Message;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public class EastMoneyService extends BaseCrawlService {

    public <T> Message<T> getBean(Class<T> tClass,String url, Map<String,String> params){
        JSONObject jsonObject = super.getJsonObject(url,params);
        Message<String> message = isError(jsonObject);

        if(message.fail()){
            return Message.error(message.getMsg());
        }

        T bean= jsonObject.toJavaObject(tClass);

        return Message.success(bean);
    }

    public <T> Message<List<T>> getListBean(Class<T> tClass, String url, Map<String,String> params){
        JSONObject jsonObject = super.getJsonObject(url,params);
        Message message = isError(jsonObject);
        if(message.fail()){
            return Message.error(message.getMsg());
        }

        JSONArray jsonArray = super.getJsonArray(url,params);
        List<T> listBean= jsonArray.toJavaList(tClass);

        return Message.success(listBean);
    }

    private Message<String> isError(JSONObject jsonObject){
        if(jsonObject.getIntValue("status")==-1){
            return Message.error(jsonObject.getString("message"));
        }

        return  Message.ok();
    }
}
