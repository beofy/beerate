package cn.beerate.service.emweb;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class IndustryAnalysisCrawlService extends BaseCrawlService {

    private final static String INDEX_URL="http://emweb.securities.eastmoney.com/IndustryAnalysis/Index";
    private final static String URL ="http://emweb.securities.eastmoney.com/IndustryAnalysis/IndustryAnalysisAjax";
    private final static String STOCKPERFORMANCE_URL ="http://emweb.securities.eastmoney.com/IndustryAnalysis/StockPerformanceAjax";

    /**
     * 根据股票代码抓取
     * @param stockCode 股票代码
     */
    public Message<String> industryAnalysis(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);
        params.put("icode",super.getICode(IndustryAnalysisCrawlService.INDEX_URL,stockCode));

        return  super.crawl(IndustryAnalysisCrawlService.URL,params);
    }

    /**
     * 根据股票抓取市场涨幅 <br>
     * month : 1 3 6 12
     */
    public Message<String> stockPerformance(String stockCode,String month){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);
        params.put("month",month);

        return super.crawl(IndustryAnalysisCrawlService.STOCKPERFORMANCE_URL,params);
    }



}
