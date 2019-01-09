package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.dao.Impl.ProfitForecastDaoImpl;
import cn.beerate.model.entity.stock.t_profit_forecast;
import cn.beerate.service.base.BaseCrawlService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProfitForecastService extends BaseCrawlService {
    @Autowired
    private ProfitForecastDaoImpl profitForecastDao;
    private Log log = LogFactory.getLog(ProfitForecastService.class);

    private final static String URL="http://emweb.securities.eastmoney.com/ProfitForecast/ProfitForecastAjax";

    /**
     * 抓取机构预测
     * @param stockCode 股票代码
     */
    public Message<t_profit_forecast> crawlProfitForecast(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);

        Message<String> message = super.crawl(this.URL,params);
        if(message.getCode()==Message.Code.ERROR){
            log.info(message.getMsg());
            return Message.error(message.getMsg());
        }

        JSONObject jsonObject = JSONObject.parseObject(message.getData());
        t_profit_forecast profit_forecast = jsonObject.toJavaObject(t_profit_forecast.class);
        profit_forecast.setStockCode(stockCode);

        profitForecastDao.save(profit_forecast);

        return Message.success(profit_forecast);
    }


    /**
     * 抓取所有机构预测
     * @return
     */
    public Message crawlAllProfitForecast(){
        List<String> stockCodeList = StockCodeUtil.getStockCode();
        for (String code : stockCodeList) {
            this.crawlProfitForecast(code);
        }
        return Message.ok();

    }
}
