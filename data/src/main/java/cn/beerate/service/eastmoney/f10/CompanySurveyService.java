package cn.beerate.service.eastmoney.f10;


import cn.beerate.common.Message;
import cn.beerate.dao.eastmoney.f10.companysurvey.CompanySurveyDao;
import cn.beerate.model.entity.eastmoney.f10.companysurvey.t_eastmoney_companysurvey;
import cn.beerate.service.EastMoneyService;
import cn.beerate.service.IEastMoneyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 公司概况
 */
@Component
@Transactional(readOnly = true)
public class CompanySurveyService extends EastMoneyService implements IEastMoneyService {

    private CompanySurveyDao companySurveyDao;

    public CompanySurveyService(CompanySurveyDao companySurveyDao) {
        this.companySurveyDao = companySurveyDao;

        super.eastMoneyService=this;
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
     * 根据股票代码查询
     * @param stockCode 股票代码
     */
    public Message<t_eastmoney_companysurvey> findCompanysurveyByStockCode(String stockCode){
       t_eastmoney_companysurvey companysurvey = companySurveyDao.findByCodeOrderByCreateTimeAsc(stockCode);
       if(companysurvey==null){
         return Message.error("未查询到该股票数据");
       }

       return Message.success(companysurvey);
    }

    @Override
    @Transactional
    public void updateByStockCodes(String code) {
        Message<t_eastmoney_companysurvey> companysurveyMessage = companySurvey(code);
        if(!companysurveyMessage.fail()){
            //查询数据是否存在
            t_eastmoney_companysurvey companysurvey =companySurveyDao.findByCodeOrderByCreateTimeAsc(code);
            if(companysurvey==null){
                //设置主一
                companysurvey= companysurveyMessage.getData();

                //因为使用级联批量保存,此处设置从一
                companysurvey.getFxxg().setCompanysurvey(companysurvey);
                companysurvey.getJbzl().setCompanysurvey(companysurvey);

                //此处无事务，批量级联保存
                companySurveyDao.save(companysurvey);
            }else{
                t_eastmoney_companysurvey companysurveyUpdate = companysurveyMessage.getData();

                Date now = new Date();
                companysurveyUpdate.setId(companysurvey.getId());
                companysurveyUpdate.setCreateTime(companysurvey.getCreateTime());//创建时间
                companysurveyUpdate.setUpdateTime(now);//更新时间

                companysurveyUpdate.getFxxg().setId(companysurvey.getFxxg().getId());
                companysurveyUpdate.getFxxg().setCreateTime(companysurvey.getCreateTime());//创建时间
                companysurveyUpdate.getFxxg().setUpdateTime(now);//更新时间

                companysurveyUpdate.getJbzl().setId(companysurvey.getJbzl().getId());
                companysurveyUpdate.getJbzl().setCreateTime(companysurvey.getCreateTime());//创建时间
                companysurveyUpdate.getJbzl().setUpdateTime(now);//更新时间

                //因为使用级联批量保存,此处设置从一
                companysurveyUpdate.getFxxg().setCompanysurvey(companysurvey);
                companysurveyUpdate.getJbzl().setCompanysurvey(companysurvey);

                //此处无事务，批量级联保存
                companySurveyDao.save(companysurveyUpdate);
            }
        }
    }
}
