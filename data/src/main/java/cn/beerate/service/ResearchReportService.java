package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.dao.Impl.ResearchReportDaoImpl;
import cn.beerate.model.entity.stock.t_research_report;
import cn.beerate.service.base.BaseCrawlService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
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
    public Message<t_research_report> crawlResearchReport(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);
        params.put("icode","475");

        Message<String> message = super.crawl(this.URL,params);
        if(message.getCode()==Message.Code.ERROR){
            log.info(message.getMsg());
            return Message.error(message.getMsg());
        }
        JSONObject jsonObject = JSONObject.parseObject(message.getData());
        t_research_report research_report = jsonObject.toJavaObject(t_research_report.class);
        research_report.setStockCode(stockCode);

        researchReportDao.save(research_report);

        return Message.success(research_report);
    }

    /**
     * 抓取所有研究报告
     */
    public Message crawlResearchReport(){
        List<String> stockCodeList = StockCodeUtil.getStockCode();
        for (String code : stockCodeList) {
            this.crawlResearchReport(code);
        }
        return Message.ok();
    }

}
