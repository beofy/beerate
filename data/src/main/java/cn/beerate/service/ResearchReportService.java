package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.common.util.Crawler;
import cn.beerate.service.base.BaseCrawlService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class ResearchReportService extends BaseCrawlService {

    private Log log = LogFactory.getLog(ResearchReportService.class);

    private final static String INDEX_URL="http://emweb.securities.eastmoney.com/ResearchReport/Index";

    private final static String URL="http://emweb.securities.eastmoney.com/ResearchReport/ResearchReportAjax";

    /**
     * 抓取研究报告
     * @param stockCode 股票代码
     * @return
     */
    public Message<String> researchReport(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);
        params.put("icode",super.getICode(this.INDEX_URL,stockCode));

        return super.crawl(this.URL,params);
    }


}
