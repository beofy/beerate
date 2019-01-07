package cn.beerate.service;

import cn.beerate.common.util.Crawler;
import cn.beerate.dao.Impl.OperationsRequiredDaoImpl;
import cn.beerate.dao.Impl.StockInfoDaoImpl;
import cn.beerate.model.entity.stock.companysurvey.t_stock_info;
import cn.beerate.model.entity.stock.operationsrequired.t_operations_required;
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
public class OperationsRequiredService {

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
    public void crawlOperationsRequired(String stockCode){

        Map<String,String> params = new HashMap<String,String>();
        params.put("times","1");
        params.put("code",stockCode);

        String result = Crawler.getInstance().getString(this.URL,params);
        log.info(result);

        JSONObject jsonObject = JSONObject.parseObject(result);

        t_operations_required operations_required= jsonObject.toJavaObject(t_operations_required.class);
        t_stock_info stock_info = stockInfoDao.findByCode(stockCode);
        operations_required.setStock_info(stock_info);

        operationsRequiredDao.save(operations_required);
    }

    public void crawlAllOperationsRequired(){
        String[]  stockCodeArray = stockInfoDao.findAllStockCode();
        for (String stockCode:stockCodeArray) {
           this.crawlOperationsRequired(stockCode);
        }
    }
}
