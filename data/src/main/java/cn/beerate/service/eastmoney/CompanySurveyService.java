package cn.beerate.service.eastmoney;


import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;


/**
 * 公司概况
 */
@Component
@Transactional
public class CompanySurveyService extends BaseCrawlService {
    private final String URL="http://emweb.securities.eastmoney.com/companysurvey/CompanySurveyAjax";

    //抓取公司概况
    public Message<String> companySurvey(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);

        return Message.success(super.getJsonString(this.URL,params));
    }
}
