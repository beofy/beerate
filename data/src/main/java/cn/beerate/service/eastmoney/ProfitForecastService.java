package cn.beerate.service.eastmoney;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class ProfitForecastService extends BaseCrawlService {
    private final String URL="http://emweb.securities.eastmoney.com/ProfitForecast/ProfitForecastAjax";

    /**
     * 抓取机构预测
     * @param stockCode 股票代码
     */
    public Message<String> profitForecast(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);

        return Message.success(super.getJsonString(this.URL,params));
    }

}
