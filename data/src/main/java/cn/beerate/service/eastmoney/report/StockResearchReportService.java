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
     * @param sc 行业名称:<br>
     *  房地产451 电子信息447 钢铁行业479 机械行业545 煤炭采选437 汽车行业481 水泥建材424 商业百货482 医药制造465 银行475 有色金属478<br>
     * 	A.安防设备735<br>
     * 	B.包装材料733 玻璃陶瓷546 保险474<br>
     * 	C.材料行业537 船舶制造729<br>
     * 	D.电力行业428 电子元件459 多元金融738 电信运营736<br>
     * 	F.纺织服装436<br>
     * 	G.港口水运450 贵金属732 工程建设425 高速公路421 公用事业427 国际贸易484 工艺商品440<br>
     * 	H.化工行业538 环保工程728 化纤行业471 化肥行业731 航天航空480<br>
     * 	J.家电行业456 交运物流422 金属制品739 交运设备429<br>
     * 	L.旅游酒店485<br>
     * 	M.木业家具476<br>
     * 	N.农药兽药730 酿酒行业477 农牧饲渔433<br>
     * 	Q.券商信托473<br>
     * 	R.软件服务737<br>457
     * 	S.塑胶制品454 食品饮料438 输配电气457 石油行业464<br>
     * 	T.通讯行业448 <br>
     * 	W.文教休闲740 文化传媒486 <br>
     * 	Y.医疗行业727 仪器仪表458 园林工程726 <br>
     * 	Z.装修装饰725 珠宝首饰734 造纸印刷470 综合行业539 专用设备910<br>
     * @param mkt 评级类别 0-全部 1-买入 2-增持 3-中性 4-减持 5-卖出
     * @param stat 评级变动 0-全部 1-维持 2-调高 3-调低 4-首次 5-无
     */
    public Message<String> industryResearchReport(String pageSize, String currPage,String sc,String mkt,String stat){
        String url="http://datainterface.eastmoney.com//EM_DataCenter/js.aspx";
        Map<String,String> params = new HashMap<>();
        params.put("type","SR");
        params.put("sty","HYSR");
        params.put("ps",pageSize);
        params.put("p",currPage);
        params.put("mkt",mkt);
        params.put("stat",stat);
        params.put("sc",sc);
        try{
            String html = super.getDocument(url,params).body().html();
            String result = html.substring(1,html.length()-1);

            return Message.success(result);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Message.error("无数据");
        }
    }


}
