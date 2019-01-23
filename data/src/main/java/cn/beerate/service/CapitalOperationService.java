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
 * 资本运作
 */
@Component
@Transactional
public class CapitalOperationService extends BaseCrawlService {

    private Log log = LogFactory.getLog(CapitalOperationService.class);

    private final static String CAPITAL_OPERATION_AJAX="http://emweb.securities.eastmoney.com/CapitalOperation/CapitalOperationAjax";

    /**
     * 资本运作
     * @param code
     * @param orderBy
     * @param isAsc
     * @return
     */
    public Message<String> capitalOperation(String code, String orderBy, String isAsc){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",code);
        params.put("orderBy",orderBy);
        params.put("isAsc",isAsc);

        return super.crawl(this.CAPITAL_OPERATION_AJAX,params);
    }

}
