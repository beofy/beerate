package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.dao.Impl.NewsBulletinDaoImpl;
import cn.beerate.model.entity.stock.t_news_bulletin;
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

@Component
public class NewsBulletinService extends BaseCrawlService {
    @Autowired
    private NewsBulletinDaoImpl bulletinDao;

    private final static String URL ="http://emweb.securities.eastmoney.com/NewsBulletin/NewsBulletinAjax";

    private static Log log = LogFactory.getLog(NewsBulletinService.class);

    /**
     * 抓取新闻公告
     * @param stockCode 股票代码
     */
    @Transactional
    public Message<t_news_bulletin> crawlNewsBulletin(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);

        Message<String> message = super.crawl(this.URL,params);
        if(message.getCode()==Message.Code.ERROR){
            log.info(message.getMsg());
            return Message.error(message.getMsg());
        }

        JSONObject jsonObject = JSONObject.parseObject(message.getData());

        t_news_bulletin news_bulletin = jsonObject.toJavaObject(t_news_bulletin.class);
        news_bulletin.setStockCode(stockCode);

        bulletinDao.save(news_bulletin);

        return Message.success(news_bulletin);
    }

    /**
     * 抓取所有新闻公告
     */
    public Message crawlAllNewsBulletin(){
        List<String> stockCodeList = StockCodeUtil.getStockCode();
        for (String code : stockCodeList) {
            this.crawlNewsBulletin(code);
        }

        return Message.ok();
    }
}
