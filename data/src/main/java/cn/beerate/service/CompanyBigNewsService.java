package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.dao.Impl.CompanyBigNewsDaoImpl;
import cn.beerate.model.entity.stock.t_company_big_news;
import cn.beerate.service.base.BaseCrawlService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CompanyBigNewsService extends BaseCrawlService {

    @Autowired
    private CompanyBigNewsDaoImpl companyBigNewsDao;

    private Log log = LogFactory.getLog(CompanyBigNewsService.class);

    private final static String URL = "http://emweb.securities.eastmoney.com/CompanyBigNews/CompanyBigNewsAjax";

    /**
     *  抓取公司大事
     * @param stockCode
     */
    public Message<t_company_big_news> crawlCompanyBigNews(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("requesttimes","1");
        params.put("code",stockCode);

        Message<String> message =  super.crawl(this.URL, params);
        if(message.getCode()==Message.Code.ERROR){
            log.info(message.getMsg());
            return Message.error(message.getMsg());
        }

        JSONObject jsonObject = JSONObject.parseObject(message.getData());
        t_company_big_news company_big_news = jsonObject.toJavaObject(t_company_big_news.class);
        company_big_news.setStockCode(stockCode);

        companyBigNewsDao.save(company_big_news);

        return Message.success(company_big_news);
    }

    /**
     *  抓取所有公司大事
     */
    public Message crawlAllCompanyBigNews(){
        List<String> stockCodeList = StockCodeUtil.getStockCode();
        for (String code : stockCodeList) {
            this.crawlCompanyBigNews(code);
        }

        return Message.ok();
    }

}
