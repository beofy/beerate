package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class NewsBulletinService extends BaseCrawlService {

    private final static String URL ="http://emweb.securities.eastmoney.com/NewsBulletin/NewsBulletinAjax";

    private static Log log = LogFactory.getLog(NewsBulletinService.class);

    /**
     * 抓取新闻公告
     * @param stockCode 股票代码
     */
    public Message<String> newsBulletin(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);

        return super.crawl(this.URL,params);
    }

}
