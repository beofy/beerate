package cn.beerate.service;

import cn.beerate.dao.Impl.OperationsRequiredDaoImpl;
import cn.beerate.dao.Impl.StockInfoDaoImpl;
import cn.beerate.model.entity.stock.companysurvey.t_stock_info;
import cn.beerate.model.entity.stock.operationsrequired.t_operations_required;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 *  操盘必读
 */
@Component
@Transactional
public class OperationsRequiredService {

    @Autowired
    private StockInfoDaoImpl stockInfoDao;
    @Autowired
    private OperationsRequiredDaoImpl operationsRequiredDao;

    private Log log = LogFactory.getLog(CompanySurveyService.class);

    private final static String URL="http://emweb.securities.eastmoney.com/OperationsRequired/OperationsRequiredAjax";

    /**
     * 操盘必读
     */
    public void OperationsRequired(){

    }


    /**
     * @param stockCode
     */
    public void crawlOperationsRequired(String stockCode){
        Document document = null;
        try {
            document = Jsoup.connect(this.URL)
                            .ignoreContentType(true)
                            .data("times","1")
                            .data("code",stockCode)//股票代码
                            .get();
        } catch (IOException e) {
            log.warn(e);
        }

        String result = document.body().text();
        log.info(result);

        JSONObject jsonObject = JSONObject.parseObject(result);

        t_operations_required operations_required= JSONObject.toJavaObject(jsonObject, t_operations_required.class);
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
