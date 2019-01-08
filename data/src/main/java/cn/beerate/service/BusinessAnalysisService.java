package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.common.util.Crawler;
import cn.beerate.dao.Impl.BusinessAnalysisDaoImpl;
import cn.beerate.dao.Impl.StockInfoDaoImpl;
import cn.beerate.model.entity.stock.companysurvey.t_stock_info;
import cn.beerate.model.entity.stock.t_business_analysis;
import cn.beerate.service.base.BaseCrawlService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 经营分析
 */
@Component
public class BusinessAnalysisService extends BaseCrawlService {

    @Autowired
    private StockInfoDaoImpl stockInfoDao;

    @Autowired
    private BusinessAnalysisDaoImpl analysisDao;

    private Log log = LogFactory.getLog(BusinessAnalysisService.class);

    private final static String URL="http://emweb.securities.eastmoney.com/BusinessAnalysis/BusinessAnalysisAjax";

    /**
     * 抓取经营分析
     * @param stockCode 股票代码
     */
    @Transactional
    public Message<t_business_analysis> crawlBusinessAnalysis(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);

        Message<String> message = super.crawl(this.URL,params);

        if(message.getCode()==Message.Code.ERROR){
            log.info(message.getMsg());
            return Message.error(message.getMsg());
        }

        JSONObject jsonObject = JSONObject.parseObject(message.getData());
        t_business_analysis business_analysis = jsonObject.toJavaObject(t_business_analysis.class);

        t_stock_info stock_info = stockInfoDao.findByCode(stockCode);
        business_analysis.setStock_info(stock_info);

        analysisDao.save(business_analysis);

        return Message.success(business_analysis);
    }

    /**
     * 抓取所有经营分析
     */
    public Message crawlAllBusinessAnalysis(){
        String[] stockCodeArray = stockInfoDao.findAllStockCode();
        for (String code :stockCodeArray) {
            this.crawlBusinessAnalysis(code);
        }

        return Message.ok();
    }
}
