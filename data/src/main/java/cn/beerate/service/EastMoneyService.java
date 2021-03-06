package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.Map;

public class EastMoneyService extends BaseCrawlService{

    private final static Log logger = LogFactory.getLog(EastMoneyService.class);

    protected IEastMoneyService eastMoneyService;

    protected  <T> Message<T> getBean(Class<T> tClass,String url, Map<String,String> params){
        JSONObject jsonObject = super.getJsonObject(url,params);
        Message<String> message = isError(jsonObject);

        if(message.fail()){
            return Message.error(message.getMsg());
        }

        T bean= jsonObject.toJavaObject(tClass);

        return Message.success(bean);
    }

    protected <T> Message<List<T>> getListBean(Class<T> tClass, String url, Map<String,String> params){
        String jsonString = super.getJsonString(url,params);
        Object o = JSON.parse(jsonString);

        //异常返回jsonObject,做异常处理
        if(o instanceof JSONObject){
            Message message = isError((JSONObject) o);
            if(message.fail()){
                return Message.error(message.getMsg());
            }
        }

        JSONArray jsonArray = super.getJsonArray(url,params);
        if(jsonArray==null){
            return Message.error();
        }
        List<T> listBean= jsonArray.toJavaList(tClass);

        return Message.success(listBean);
    }

    private Message<String> isError(JSONObject jsonObject){
        if(jsonObject.getIntValue("status")==-1){
            return Message.error(jsonObject.getString("message"));
        }

        return  Message.ok();
    }

    public void updateAllStockCodesData() {
        updateAllStockCodesData(this.eastMoneyService);
    }

    public void updateAllStockCodesData(IEastMoneyService eastMoneyService) {
        for (String s : StockCodeUtil.getStockCode()) {
            try {
                eastMoneyService.updateByStockCodes(s);
            }catch (Exception e){
                logger.info("更新股票数据异常，代码：["+s+"],原因："+e.getMessage());
                logger.info(e.getMessage(),e);
                logger.info("更新下一个股票数据");
            }
        }
    }

}
