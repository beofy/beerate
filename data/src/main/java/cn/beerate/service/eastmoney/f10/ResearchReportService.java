package cn.beerate.service.eastmoney.f10;

import cn.beerate.common.Message;
import cn.beerate.service.BaseCrawlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class ResearchReportService extends BaseCrawlService {
    private final String INDEX_URL="http://emweb.securities.eastmoney.com/ResearchReport/Index";

    private final String URL="http://emweb.securities.eastmoney.com/ResearchReport/ResearchReportAjax";

    /**
     * 抓取研究报告
     * @param stockCode 股票代码
     * @return Message<String>
     */
    public Message<String> researchReport(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);
        params.put("icode",super.getICode(this.INDEX_URL,stockCode));

        return Message.success(super.getJsonString(this.URL,params));
    }


}
