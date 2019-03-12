package cn.beerate.service.eastmoney.f10;

import cn.beerate.common.Message;
import cn.beerate.dao.eastmoney.f10.companymanagement.RptManagerDao;
import cn.beerate.dao.eastmoney.f10.companymanagement.RptShareHeldChangeDao;
import cn.beerate.model.bean.eastmoney.f10.CompanyManagement;
import cn.beerate.service.EastMoneyService;
import cn.beerate.service.IEastMoneyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 公司高管
 */
@Component
@Transactional(readOnly = true)
public class CompanyManagementService extends EastMoneyService implements IEastMoneyService {

    private RptManagerDao rptManagerDao;
    private RptShareHeldChangeDao rptShareHeldChangeDao;

    public CompanyManagementService(RptManagerDao rptManagerDao, RptShareHeldChangeDao rptShareHeldChangeDao) {
        this.rptManagerDao = rptManagerDao;
        this.rptShareHeldChangeDao = rptShareHeldChangeDao;

        super.eastMoneyService =this;
    }

    /**
     * 获取公司高管
     * @param code 股票代码
     */
    public Message<CompanyManagement> companyManagement(String code){
        String url ="http://emweb.securities.eastmoney.com/CompanyManagement/CompanyManagementAjax";
        Map<String,String> params = new HashMap<>();
        params.put("code",code);

        return super.getBean(CompanyManagement.class,url,params);
    }

    /**
     * 获取公司高管
     * @param code 股票代码
     */
    public Message<CompanyManagement> findCompanyManagementByStockCode(String code){
        CompanyManagement companyManagement =new CompanyManagement();
        companyManagement.setRptManagerList(rptManagerDao.findByCode(code));
        companyManagement.setRptShareHeldChangeList(rptShareHeldChangeDao.findByCode(code));

        return Message.success(companyManagement);
    }

    /**
     * 根据股票代码更新数据
     * @param code 股票代码
     */
    @Override
    public void updateByStockCodes(String code) {
        Message<CompanyManagement> companyManagementMessage = companyManagement(code);
        if (!companyManagementMessage.fail()){
            CompanyManagement companyManagement= companyManagementMessage.getData();
            //高管列表
            companyManagement.getRptManagerList().forEach(rpt_manager -> rpt_manager.setCode(code));
            //高管持股变动
            companyManagement.getRptShareHeldChangeList().forEach(rpt_shareheld_change -> rpt_shareheld_change.setCode(code));

            //删除数据
            rptManagerDao.deleteByCode(code);
            rptShareHeldChangeDao.deleteByCode(code);

            //保存数据，无事务
            rptManagerDao.saveAll(companyManagement.getRptManagerList());
            rptShareHeldChangeDao.saveAll(companyManagement.getRptShareHeldChangeList());
        }
    }
}
