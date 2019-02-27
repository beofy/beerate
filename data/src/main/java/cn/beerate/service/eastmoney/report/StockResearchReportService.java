package cn.beerate.service.eastmoney.report;

import cn.beerate.common.Message;
import cn.beerate.model.bean.eastmoney.report.GGSR;
import cn.beerate.service.base.BaseCrawlService;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StockResearchReportService extends BaseCrawlService {

    private final static Log logger  = LogFactory.getLog(BaseCrawlService.class);

    /**
     * 个股研究报告
     * @param pageSize 每页条数
     * @param currPage 当前页
     * @param code 股票代码
     */
    public Message<List<GGSR>> stockResearchReport(String pageSize, String currPage, String code){
        String url="http://datainterface.eastmoney.com//EM_DataCenter/js.aspx";
        Map<String,String> params = new HashMap<>();
        params.put("type","SR");
        params.put("sty","GGSR");
        params.put("ps",pageSize);
        params.put("p",currPage);
        params.put("code",code);

        try{
            String html = super.getDocument(url,params).body().html();
            String jsonArray = html.substring(1,html.length()-1);
            List<GGSR> ggsrList = JSONArray.parseArray(jsonArray).toJavaList(GGSR.class);
            if(ggsrList.size()==0){
                Message.error("无数据");
            }
            return Message.success(ggsrList);
        }catch (Exception e){
            logger.error(e);
            return Message.error("无数据");
        }
    }


}
