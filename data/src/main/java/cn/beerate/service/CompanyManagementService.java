package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 公司高管
 */
@Component
public class CompanyManagementService extends BaseCrawlService {
    private Log log = LogFactory.getLog(CompanyManagementService.class);

    private final static String COMPANY_MANAGEMENT_AJAX="http://emweb.securities.eastmoney.com/CompanyManagement/CompanyManagementAjax";

    /**
     * 公司高管
     * @param code 股票代码
     */
    public Message<String> companyManagement(String code){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",code);

        return super.crawl(this.COMPANY_MANAGEMENT_AJAX,params);
    }

}
