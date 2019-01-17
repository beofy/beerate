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
 * 公司概况
 */
@Component
public class CompanySurveyService extends BaseCrawlService {
    private Log log = LogFactory.getLog(CompanySurveyService.class);
    private final static String URL="http://emweb.securities.eastmoney.com/companysurvey/CompanySurveyAjax";

    //抓取公司概况
    @Transactional
    public Message<String> companySurvey(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);

        return super.crawl(this.URL,params);
    }
}
