package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.dao.Impl.IndustryAnalysisDaoImpl;
import cn.beerate.model.entity.stock.t_industry_analysis;
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
public class IndustryAnalysisCrawlService extends BaseCrawlService {

    @Autowired
    private IndustryAnalysisDaoImpl industryAnalysisDao;
    private static Log  log  = LogFactory.getLog(IndustryAnalysisCrawlService.class);
    private final static String URL ="http://emweb.securities.eastmoney.com/IndustryAnalysis/IndustryAnalysisAjax";
    private final static String STOCKPERFORMANCE_URL ="http://emweb.securities.eastmoney.com/IndustryAnalysis/StockPerformanceAjax";

    /**
     * 根据股票代码抓取
     * @param stockCode 股票代码
     */
    public Message<t_industry_analysis> crawlIndustryAnalysis(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);
        params.put("icode","451");

        Message<String> message = super.crawl(this.URL,params);
        if(message.getCode()==Message.Code.ERROR){
            log.info(message.getMsg());
            return Message.error(message.getMsg());
        }

        JSONObject jsonObject = JSONObject.parseObject(message.getData());
        t_industry_analysis industry_analysis = jsonObject.toJavaObject(t_industry_analysis.class);
        industry_analysis.setStockCode(stockCode);

        industryAnalysisDao.save(industry_analysis);

        return Message.success(industry_analysis);
    }

    /**
     * 根据股票抓取市场涨幅 <br>
     * month : 1 3 6 12
     */
    public Message<String> crawlStockPerformance(String stockCode,String month){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);
        params.put("month",month);
        Message<String> message = super.crawl(this.STOCKPERFORMANCE_URL,params);

        if(message.getCode()==Message.Code.ERROR){
            log.info(message.getMsg());
            return message;
        }

        return message;
    }

    /**
     * 抓取所有同行比较
     */
    public Message crawlAllIndustryAnalysis(){
        List<String> stockCodeList =  StockCodeUtil.getStockCode();
        for (String code :stockCodeList) {
            this.crawlIndustryAnalysis(code);
        }

        return Message.ok();
    }

}
