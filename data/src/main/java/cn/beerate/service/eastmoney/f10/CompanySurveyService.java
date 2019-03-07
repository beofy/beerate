package cn.beerate.service.eastmoney.f10;


import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.dao.eastmoney.f10.companysurvey.CompanySurveyDao;
import cn.beerate.model.entity.eastmoney.f10.companysurvey.t_eastmoney_companysurvey;
import cn.beerate.service.EastMoneyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 公司概况
 */
@Component
@Transactional(readOnly = true)
public class CompanySurveyService extends EastMoneyService {

    private CompanySurveyDao companySurveyDao;

    public CompanySurveyService(CompanySurveyDao companySurveyDao) {
        this.companySurveyDao = companySurveyDao;
    }

    /**
     * 抓取公司概况
     * @param stockCode 股票代码
     */
    public Message<t_eastmoney_companysurvey> companySurvey(String stockCode){
        String url="http://emweb.securities.eastmoney.com/companysurvey/CompanySurveyAjax";
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);

        return super.getBean(t_eastmoney_companysurvey.class,url,params);
    }

    /**
     * 更新所有公司概况
     */
    @Transactional
    public void updateCompanySurveys(){
        List<t_eastmoney_companysurvey> companysurveyList = new ArrayList<>();
        for (String code : StockCodeUtil.getStockCode()) {
            Message<t_eastmoney_companysurvey> companysurveyMessage = companySurvey(code);
            if(!companysurveyMessage.fail()){
                t_eastmoney_companysurvey companysurvey= companysurveyMessage.getData();
                //因为使用级联批量保存,此处设置从一
                companysurvey.getFxxg().setCompanysurvey(companysurvey);
                companysurvey.getJbzl().setCompanysurvey(companysurvey);
                companysurveyList.add(companysurvey);
            }
            //此处批量级联保存，每次保存一千条，并清空list
            if(companysurveyList.size()==1000){
                companySurveyDao.saveAll(companysurveyList);
                companysurveyList.clear();
            }
        }
    }

    /**
     * 根据股票代码查询
     * @param stockCode 股票代码
     */
    public Message<t_eastmoney_companysurvey> findCompanysurveyByStockCode(String stockCode){
       t_eastmoney_companysurvey companysurvey = companySurveyDao.findByCode(stockCode);
       if(companysurvey==null){
         return Message.error("未查询到该股票数据");
       }

       return Message.success(companysurvey);
    }

}
