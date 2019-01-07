package cn.beerate.service;

import cn.beerate.common.util.Crawler;
import cn.beerate.dao.Impl.ShareholderResearchDaoImpl;
import cn.beerate.dao.Impl.StockInfoDaoImpl;
import cn.beerate.model.entity.stock.companysurvey.t_stock_info;
import cn.beerate.model.entity.stock.t_shareholder_research;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 股东研究
 */
@Component
public class ShareholderResearchService {
    @Autowired
    private StockInfoDaoImpl stockInfoDao;
    @Autowired
    private ShareholderResearchDaoImpl shareholderResearchDao;
    private Log log = LogFactory.getLog(ShareholderResearchService.class);

    private final String URL="http://emweb.securities.eastmoney.com/ShareholderResearch/ShareholderResearchAjax";

    private final String POSITION_URL="http://emweb.securities.eastmoney.com/ShareholderResearch/MainPositionsHodlerAjax";
    /**
     *  根据股票代码抓取-股东研究
     *  @param stockCode 股票代码
     */
    @Transactional
    public void crawlShareholderResearch(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);

        String result = Crawler.getInstance().getString(this.URL,params);
        log.info(result);

        JSONObject jsonObject = JSONObject.parseObject(result);
        t_shareholder_research shareholder_research = jsonObject.toJavaObject(t_shareholder_research.class);
        t_stock_info stock_info = stockInfoDao.findByCode(stockCode);
        shareholder_research.setStock_info(stock_info);

        shareholderResearchDao.save(shareholder_research);
    }

    /**
     * 抓取机构持仓
     * @param stockCode 股票代码
     * @param date 日期
     */
    public String cralwMainPositionsHodler(String stockCode,String date){
        Map<String,String> params = new HashMap<String,String>();
        params.put("date",date);
        params.put("code",stockCode);
        String result= Crawler.getInstance().getString(this.POSITION_URL,params);
        return result;
    }
}
