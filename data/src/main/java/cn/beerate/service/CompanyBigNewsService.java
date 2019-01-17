package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.dao.CompanyBigNewsDao;
import cn.beerate.model.entity.stock.t_company_big_news;
import cn.beerate.service.base.BaseCrawlService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CompanyBigNewsService extends BaseCrawlService {

    private Log log = LogFactory.getLog(CompanyBigNewsService.class);

    @Autowired
    private CompanyBigNewsDao companyBigNewsDao;

    private final static String URL = "http://emweb.securities.eastmoney.com/CompanyBigNews/CompanyBigNewsAjax";

    /**
     *  抓取公司大事
     * @param stockCode
     */
    public Message<String> companyBigNews(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("requesttimes","1");
        params.put("code",stockCode);

        return super.crawl(this.URL, params);
    }

    /**
     * 根据股票代码查询
     * @param stockCode
     */
    public Message<t_company_big_news> findByCode(String stockCode){
        t_company_big_news company_big_news = companyBigNewsDao.findByStockCode(stockCode);

        if(company_big_news==null){
            return Message.error("无数据");
        }

         return Message.success(company_big_news);
    }


}
