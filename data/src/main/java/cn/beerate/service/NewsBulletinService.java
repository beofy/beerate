package cn.beerate.service;

import cn.beerate.common.util.Crawler;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.dao.Impl.NewsBulletinDaoImpl;
import cn.beerate.model.entity.stock.t_news_bulletin;
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
public class NewsBulletinService {
    @Autowired
    private NewsBulletinDaoImpl bulletinDao;

    private final static String URL ="http://emweb.securities.eastmoney.com/NewsBulletin/NewsBulletinAjax";

    private static Log log = LogFactory.getLog(NewsBulletinService.class);

    /**
     * 抓取新闻公告
     * @param stockCode 股票代码
     */
    @Transactional
    public void crawlNewsBulletin(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);

        String result =  Crawler.getInstance().getString(this.URL,params);
        log.info(result);

        //判断股票代码是否正确
        JSONObject jsonObject = JSONObject.parseObject(result);
        if(!StringUtil.isBlank(jsonObject.getString("status"))){
            return;
        }

        t_news_bulletin news_bulletin = jsonObject.toJavaObject(t_news_bulletin.class);
        news_bulletin.setStockCode(stockCode);

        bulletinDao.save(news_bulletin);
    }

    /**
     * 抓取所有新闻公告
     */
    public void crawlAllNewsBulletin(){
        List<String> stockCodeList = StockCodeUtil.getStockCode();
        for (String code : stockCodeList) {
            this.crawlNewsBulletin(code);
        }
    }
}
