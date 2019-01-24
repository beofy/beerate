package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
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
    private final static String URL="http://emweb.securities.eastmoney.com/BusinessAnalysis/BusinessAnalysisAjax";

    /**
     * 抓取经营分析
     * @param stockCode 股票代码
     * @return Message<String>
     */
    public Message<String> businessAnalysis(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);

        return super.crawl(BusinessAnalysisService.URL,params);
    }

}
