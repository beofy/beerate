package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.dao.Impl.ResearchReportDaoImpl;
import cn.beerate.service.base.BaseCrawlService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResearchReportService extends BaseCrawlService {

    @Autowired
    private ResearchReportDaoImpl researchReportDao;
    private Log log = LogFactory.getLog(ResearchReportService.class);
    private final static String URL="http://emweb.securities.eastmoney.com/ResearchReport/ResearchReportAjax";

    /**
     * 抓取研究报告
     * @param stockCode 股票代码
     * @return
     */
    public Message<String> researchReport(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);
        params.put("icode","475");

        return super.crawl(this.URL,params);
    }

}
