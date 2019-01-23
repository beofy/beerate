package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 经营分析
 */
@Component
@Transactional
public class BusinessAnalysisService extends BaseCrawlService {

    private Log log = LogFactory.getLog(BusinessAnalysisService.class);

    private final static String URL="http://emweb.securities.eastmoney.com/BusinessAnalysis/BusinessAnalysisAjax";

    /**
     * 抓取经营分析
     * @param stockCode 股票代码
     */
    public Message<String> businessAnalysis(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);

        return super.crawl(this.URL,params);
    }

}
