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
 * 股本结构
 */
@Component
@Transactional
public class CapitalStockStructureService extends BaseCrawlService {

    private Log log = LogFactory.getLog(CapitalStockStructureService.class);

    private final static String CAPITAL_STOCK_STRUCTURE_AJAX="http://emweb.securities.eastmoney.com/CapitalStockStructure/CapitalStockStructureAjax";

    /**
     * 股本结构
     * @param code 股票代码
     * @return
     */
    public Message<String> capitalStockStructure(String code){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",code);

        return super.crawl(this.CAPITAL_STOCK_STRUCTURE_AJAX,params);
    }
}
