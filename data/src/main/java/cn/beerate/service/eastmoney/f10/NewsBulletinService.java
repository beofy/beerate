package cn.beerate.service.eastmoney.f10;

import cn.beerate.common.Message;
import cn.beerate.service.BaseCrawlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
@Transactional(readOnly = true)
public class NewsBulletinService extends BaseCrawlService {
    private final String URL ="http://emweb.securities.eastmoney.com/NewsBulletin/NewsBulletinAjax";

    /**
     * 抓取新闻公告
     * @param stockCode 股票代码
     */
    public Message<String> newsBulletin(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);

        return Message.success(super.getJsonString(this.URL,params));
    }

}
