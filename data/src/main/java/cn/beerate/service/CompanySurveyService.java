package cn.beerate.service;


import cn.beerate.common.util.Crawler;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.dao.Impl.StockInfoDaoImpl;
import cn.beerate.model.entity.stock.companysurvey.t_stock_fxxg;
import cn.beerate.model.entity.stock.companysurvey.t_stock_info;
import cn.beerate.model.entity.stock.companysurvey.t_stock_jbzl;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 公司概况
 */
@Component
public class CompanySurveyService {

    @Autowired
    private StockInfoDaoImpl stockInfoDao;

    private final static String URL="http://emweb.securities.eastmoney.com/companysurvey/CompanySurveyAjax";

    private Log log = LogFactory.getLog(CompanySurveyService.class);



    //抓取公司概况
    @Transactional
    public void companySurvey(String stockCode){

        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);

        String result= Crawler.getInstance().getString(this.URL,params);
        log.info(result);

        //判断股票代码是否正确
        JSONObject jsonObject = JSONObject.parseObject(result);
        if(!StringUtil.isBlank(jsonObject.getString("status"))){
            return;
        }

        //jsonTobean
        t_stock_info stockInfo = jsonObject.toJavaObject(t_stock_info.class);
        t_stock_fxxg stockFxxg = jsonObject.getJSONObject("fxxg").toJavaObject(t_stock_fxxg.class);
        t_stock_jbzl stockJbzl = jsonObject.getJSONObject("jbzl").toJavaObject(t_stock_jbzl.class);

        //设置主一
        stockInfo.setStock_fxxg(stockFxxg);
        stockInfo.setStock_jbzl(stockJbzl);
        //设置从一
        stockFxxg.setStock_info(stockInfo);
        stockJbzl.setStock_info(stockInfo);

        //级联保存
        stockInfoDao.save(stockInfo);

    }

    //遍历所有股票打头
    public void snatchAllcompanySurvey(){
        List<String> stockCodeList = StockCodeUtil.getStockCode();
        for (String code :stockCodeList) {
            this.companySurvey(code);
        }
    }

}
