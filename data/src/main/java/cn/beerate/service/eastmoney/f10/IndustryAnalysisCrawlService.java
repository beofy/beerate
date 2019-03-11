package cn.beerate.service.eastmoney.f10;

import cn.beerate.common.Message;
import cn.beerate.service.BaseCrawlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
@Transactional(readOnly = true)
public class IndustryAnalysisCrawlService extends BaseCrawlService {

    private final String INDEX_URL="http://emweb.securities.eastmoney.com/IndustryAnalysis/Index";
    private final String URL ="http://emweb.securities.eastmoney.com/IndustryAnalysis/IndustryAnalysisAjax";
    private final String STOCKPERFORMANCE_URL ="http://emweb.securities.eastmoney.com/IndustryAnalysis/StockPerformanceAjax";

    /**
     * 根据股票代码抓取
     * @param stockCode 股票代码
     */
    public Message<String> industryAnalysis(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);
        params.put("icode",super.getICode(this.INDEX_URL,stockCode));

        return Message.success(super.getJsonString(this.URL,params));
    }

    /**
     * 根据股票抓取市场涨幅 <br>
     * month : 1 3 6 12
     */
    public Message<String> stockPerformance(String stockCode,String month){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);
        params.put("month",month);

        return Message.success(super.getJsonString(this.STOCKPERFORMANCE_URL,params));
    }

}
