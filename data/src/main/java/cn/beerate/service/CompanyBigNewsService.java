package cn.beerate.service;

import cn.beerate.common.util.Crawler;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.dao.Impl.CompanyBigNewsDaoImpl;
import cn.beerate.model.entity.stock.t_company_big_news;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CompanyBigNewsService {

    @Autowired
    private CompanyBigNewsDaoImpl companyBigNewsDao;

    private Log log = LogFactory.getLog(CompanyBigNewsService.class);

    private final static String URL = "http://emweb.securities.eastmoney.com/CompanyBigNews/CompanyBigNewsAjax";

    /**
     *  抓取公司大事
     * @param stockCode
     */
    public void crawlCompanyBigNews(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("requesttimes","1");
        params.put("code",stockCode);

        String result = Crawler.getInstance().getString(this.URL,params);
        log.info(result);

        JSONObject jsonObject = JSONObject.parseObject(result);
        if(!StringUtil.isBlank(jsonObject.getString("status"))){
            return;
        }

        t_company_big_news company_big_news = jsonObject.toJavaObject(t_company_big_news.class);
        company_big_news.setStockCode(stockCode);

        companyBigNewsDao.save(company_big_news);
    }

    /**
     *  抓取所有公司大事
     */
    public void crawlAllCompanyBigNews(){
        List<String> stockCodeList = StockCodeUtil.getStockCode();
        for (String code : stockCodeList) {
            this.crawlCompanyBigNews(code);
        }
    }

}
