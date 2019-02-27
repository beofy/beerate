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
     * @param mkt 评级类别 0-全部 1-买入 2-增持 3-中性 4-减持 5-卖出
     * @param stat 评级变动 0-全部 1-维持 2-调高 3-调低 4-首次 5-无
     */
    public Message<List<GGSR>> stockResearchReport(String pageSize, String currPage, String code,String mkt,String stat){
        String url="http://datainterface.eastmoney.com//EM_DataCenter/js.aspx";
        Map<String,String> params = new HashMap<>();
        params.put("type","SR");
        params.put("sty","GGSR");
        params.put("ps",pageSize);
        params.put("p",currPage);
        params.put("code",code);
        params.put("mkt",mkt);
        params.put("stat",stat);
        //作用未知
        //params.put("cmd","");
        try{
            String html = super.getDocument(url,params).body().html();
            String jsonArray = html.substring(1,html.length()-1);
            List<GGSR> ggsrList = JSONArray.parseArray(jsonArray).toJavaList(GGSR.class);
            if(ggsrList.size()==0){
                Message.error("无数据");
            }
            return Message.success(ggsrList);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Message.error("无数据");
        }
    }

    /**
     * 个股研究报告
     * @param pageSize 每页条数
     * @param currPage 当前页
     */
    public Message industryResearchReport(String pageSize, String currPage){
        String url="http://datainterface.eastmoney.com//EM_DataCenter/js.aspx";
        Map<String,String> params = new HashMap<>();
        params.put("type","SR");
        params.put("sty","HYSR");
        params.put("mkt","0");
        params.put("stat","0");
        params.put("ps",pageSize);
        params.put("p",currPage);
        try{
            String html = super.getDocument(url,params).body().html();

            System.out.println(html);
            return Message.error("");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Message.error("无数据");
        }
    }


}
