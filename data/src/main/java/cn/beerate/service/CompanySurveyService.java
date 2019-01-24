package cn.beerate.service;


import cn.beerate.common.Message;
import cn.beerate.dao.CompanySurveyDao;
import cn.beerate.model.entity.stock.t_company_survey;
import cn.beerate.service.base.BaseCrawlService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final static String URL="http://emweb.securities.eastmoney.com/companysurvey/CompanySurveyAjax";

    @Autowired
    private CompanySurveyDao companySurveyDao;

    //抓取公司概况
    public Message<String> companySurvey(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);

        return super.crawl(CompanySurveyService.URL,params);
    }

    public Message<t_company_survey> findByCode(String stockCode){
        t_company_survey companySurvey= companySurveyDao.findByCode(stockCode);
        if(companySurvey==null){
            return Message.error("无数据");
        }

        return Message.success(companySurvey);
    }
}
