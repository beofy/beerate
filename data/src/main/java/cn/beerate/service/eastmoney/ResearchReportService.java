package cn.beerate.service.eastmoney;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class ResearchReportService extends BaseCrawlService {
    private final static String INDEX_URL="http://eastmoney.securities.eastmoney.com/ResearchReport/Index";

    private final static String URL="http://eastmoney.securities.eastmoney.com/ResearchReport/ResearchReportAjax";

    /**
     * 抓取研究报告
     * @param stockCode 股票代码
     * @return Message<String>
     */
    public Message<String> researchReport(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);
        params.put("icode",super.getICode(ResearchReportService.INDEX_URL,stockCode));

        return super.crawl(ResearchReportService.URL,params);
    }


}
