package cn.beerate.service.eastmoney.f10;


import cn.beerate.common.Message;
import cn.beerate.model.entity.eastmoney.f10.companysurvey.t_eastmoney_companysurvey;
import cn.beerate.service.EastMoneyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 公司概况
 */
@Component
@Transactional
public class CompanySurveyService extends EastMoneyService {
    //抓取公司概况
    public Message<t_eastmoney_companysurvey> companySurvey(String stockCode){
        String url="http://emweb.securities.eastmoney.com/companysurvey/CompanySurveyAjax";

        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);

        return super.getBean(t_eastmoney_companysurvey.class,url,params);
    }
}
