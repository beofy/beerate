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
 *  操盘必读
 */
@Component
@Transactional
public class OperationsRequiredService extends BaseCrawlService {

    private Log log = LogFactory.getLog(OperationsRequiredService.class);

    private final static String URL="http://emweb.securities.eastmoney.com/OperationsRequired/OperationsRequiredAjax";

    /**
     *  操盘必读
     *  @param stockCode
     */
    public Message<String> operationsRequired(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("times","1");
        params.put("code",stockCode);

        return super.crawl(this.URL,params);
    }
}
