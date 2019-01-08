package cn.beerate.service;

import cn.beerate.common.util.Crawler;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.dao.Impl.BusinessAnalysisDaoImpl;
import cn.beerate.dao.Impl.CoreConceptionDaoImpl;
import cn.beerate.dao.Impl.StockInfoDaoImpl;
import cn.beerate.model.entity.stock.companysurvey.t_stock_info;
import cn.beerate.model.entity.stock.t_core_conception;
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

@Component
public class CoreConceptionService {

    @Autowired
    private CoreConceptionDaoImpl conceptionDao;

    private Log log = LogFactory.getLog(CoreConceptionService.class);

    private final static String URL="http://emweb.securities.eastmoney.com/CoreConception/CoreConceptionAjax";


    /**
     * 抓取核心题材
     * @param stockCode 股票代码
     */
    @Transactional
    public void crawlCoreConception(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);

        String result =  Crawler.getInstance().getString(this.URL,params);
        log.info(result);

        //判断股票代码是否正确
        JSONObject jsonObject = JSONObject.parseObject(result);
        if(!StringUtil.isBlank(jsonObject.getString("status"))){
            return;
        }

        t_core_conception core_conception = jsonObject.toJavaObject(t_core_conception.class);
        core_conception.setStockCode(stockCode);//股票代码

        conceptionDao.save(core_conception);
    }

    /**
     * 抓取所有核心题材
     */
    public void crawlAllCoreConception(){
        List<String> stockCodeList =  StockCodeUtil.getStockCode();
        for (String code :stockCodeList) {
            this.crawlCoreConception(code);
        }
    }
}
