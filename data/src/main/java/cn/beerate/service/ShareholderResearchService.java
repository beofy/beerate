package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 股东研究
 */
@Component
@Transactional
public class ShareholderResearchService extends BaseCrawlService {

    private Log log = LogFactory.getLog(ShareholderResearchService.class);

    private final String URL="http://emweb.securities.eastmoney.com/ShareholderResearch/ShareholderResearchAjax";

    private final String POSITION_URL="http://emweb.securities.eastmoney.com/ShareholderResearch/MainPositionsHodlerAjax";
    /**
     *  根据股票代码抓取-股东研究
     *  @param stockCode 股票代码
     */
    public Message<String> shareholderResearch(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);

        return super.crawl(this.URL,params);
    }

    /**
     * 抓取机构持仓
     * @param stockCode 股票代码
     * @param date 日期
     */
    public Message<String> mainPositionsHodler(String stockCode,String date){
        Map<String,String> params = new HashMap<String,String>();
        params.put("date",date);
        params.put("code",stockCode);

        return super.crawl(this.POSITION_URL,params);
    }

}
