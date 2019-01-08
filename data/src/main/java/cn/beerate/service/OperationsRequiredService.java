package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.dao.Impl.OperationsRequiredDaoImpl;
import cn.beerate.dao.Impl.StockInfoDaoImpl;
import cn.beerate.model.entity.stock.companysurvey.t_stock_info;
import cn.beerate.model.entity.stock.operationsrequired.t_operations_required;
import cn.beerate.service.base.BaseCrawlService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 *  操盘必读
 */
@Component
public class OperationsRequiredService extends BaseCrawlService {

    @Autowired
    private StockInfoDaoImpl stockInfoDao;
    @Autowired
    private OperationsRequiredDaoImpl operationsRequiredDao;

    private Log log = LogFactory.getLog(OperationsRequiredService.class);

    private final static String URL="http://emweb.securities.eastmoney.com/OperationsRequired/OperationsRequiredAjax";

    /**
     *  操盘必读
     *  @param stockCode
     */
    @Transactional
    public Message<t_operations_required> crawlOperationsRequired(String stockCode){

        Map<String,String> params = new HashMap<String,String>();
        params.put("times","1");
        params.put("code",stockCode);

        Message<String> message = super.crawl(this.URL,params);
        if(message.getCode()==Message.Code.ERROR){
            log.info(message.getMsg());
            return Message.error(message.getMsg());
        }

        JSONObject jsonObject = JSONObject.parseObject(message.getData());

        t_operations_required operations_required= jsonObject.toJavaObject(t_operations_required.class);
        t_stock_info stock_info = stockInfoDao.findByCode(stockCode);
        operations_required.setStock_info(stock_info);

        operationsRequiredDao.save(operations_required);

        return Message.success(operations_required);
    }

    public Message crawlAllOperationsRequired(){
        String[]  stockCodeArray = stockInfoDao.findAllStockCode();
        for (String stockCode:stockCodeArray) {
           this.crawlOperationsRequired(stockCode);
        }

        return Message.ok();
    }
}
