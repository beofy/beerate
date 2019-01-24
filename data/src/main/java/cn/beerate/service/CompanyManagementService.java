package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 公司高管
 */
@Component
@Transactional
public class CompanyManagementService extends BaseCrawlService {
    private final static String COMPANY_MANAGEMENT_AJAX="http://emweb.securities.eastmoney.com/CompanyManagement/CompanyManagementAjax";

    /**
     * 公司高管
     * @param code 股票代码
     */
    public Message<String> companyManagement(String code){
        Map<String,String> params = new HashMap<>();
        params.put("code",code);

        return super.crawl(CompanyManagementService.COMPANY_MANAGEMENT_AJAX,params);
    }

}
