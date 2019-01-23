package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IndustryAnalysisCrawlService extends BaseCrawlService {

    private static Log  log  = LogFactory.getLog(IndustryAnalysisCrawlService.class);

    private final static String INDEX_URL="http://emweb.securities.eastmoney.com/IndustryAnalysis/Index";
    private final static String URL ="http://emweb.securities.eastmoney.com/IndustryAnalysis/IndustryAnalysisAjax";
    private final static String STOCKPERFORMANCE_URL ="http://emweb.securities.eastmoney.com/IndustryAnalysis/StockPerformanceAjax";

    /**
     * 根据股票代码抓取
     * @param stockCode 股票代码
     */
    public Message<String> industryAnalysis(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);
        params.put("icode",super.getICode(this.INDEX_URL,stockCode));

        return  super.crawl(this.URL,params);
    }

    /**
     * 根据股票抓取市场涨幅 <br>
     * month : 1 3 6 12
     */
    public Message<String> stockPerformance(String stockCode,String month){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);
        params.put("month",month);

        return super.crawl(this.STOCKPERFORMANCE_URL,params);
    }



}
