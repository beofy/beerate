package cn.beerate.service;


import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.dao.Impl.StockInfoDaoImpl;
import cn.beerate.model.entity.stock.companysurvey.t_stock_fxxg;
import cn.beerate.model.entity.stock.companysurvey.t_stock_info;
import cn.beerate.model.entity.stock.companysurvey.t_stock_jbzl;
import cn.beerate.service.base.BaseCrawlService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
public class CompanySurveyService extends BaseCrawlService {

    @Autowired
    private StockInfoDaoImpl stockInfoDao;

    private final static String URL="http://emweb.securities.eastmoney.com/companysurvey/CompanySurveyAjax";

    private Log log = LogFactory.getLog(CompanySurveyService.class);



    //抓取公司概况
    @Transactional
    public Message<t_stock_info> companySurvey(String stockCode){

        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);

        Message<String> message = super.crawl(this.URL,params);
        if(message.getCode()==Message.Code.ERROR){
            log.info(message.getMsg());
            return Message.error(message.getMsg());
        }

        JSONObject jsonObject = JSONObject.parseObject(message.getData());

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

        return Message.success(stockInfo);
    }

    //遍历所有股票打头
    public Message snatchAllcompanySurvey(){
        List<String> stockCodeList = StockCodeUtil.getStockCode();
        for (String code :stockCodeList) {
            this.companySurvey(code);
        }
        return Message.ok();
    }

}
