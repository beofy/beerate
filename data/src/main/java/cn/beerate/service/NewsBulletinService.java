package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class NewsBulletinService extends BaseCrawlService {
    private final static String URL ="http://emweb.securities.eastmoney.com/NewsBulletin/NewsBulletinAjax";

    /**
     * 抓取新闻公告
     * @param stockCode 股票代码
     */
    public Message<String> newsBulletin(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);

        return super.crawl(NewsBulletinService.URL,params);
    }

}
