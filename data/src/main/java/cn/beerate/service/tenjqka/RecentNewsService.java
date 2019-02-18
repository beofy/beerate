package cn.beerate.service.tenjqka;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 最新动态
 */
@Component
public class RecentNewsService extends BaseCrawlService {
    private final String URL="http://basic.10jqka.com.cn";


    private String getHtml(String code){
        Map<String,String> params = new HashMap<>();
        params.put("code",code);

        return super.getHtml(this.URL, params);
    }

    /**
     * 获取公司概要
     * @param code 股票代码
     * @return
     */
    public Message profile(String code){
        String html= this.getHtml(code);
        Document document = Jsoup.parse(html);

        return null;
    }
}
