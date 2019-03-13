package cn.beerate.service.eastmoney.report;

import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.dao.eastmoney.report.GgsrDao;
import cn.beerate.dao.eastmoney.report.HysrDao;
import cn.beerate.model.entity.eastmoney.report.t_eastmoney_ggsr;
import cn.beerate.model.entity.eastmoney.report.t_eastmoney_hysr;
import cn.beerate.service.BaseCrawlService;
import cn.beerate.service.EastMoneyService;
import cn.beerate.service.IEastMoneyService;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StockResearchReportService extends EastMoneyService implements IEastMoneyService {

    private GgsrDao ggsrDao;
    private HysrDao hysrDao;

    public StockResearchReportService(GgsrDao ggsrDao,HysrDao hysrDao) {
        this.ggsrDao = ggsrDao;
        this.hysrDao = hysrDao;

        super.eastMoneyService=this;
    }

    private final static Log logger  = LogFactory.getLog(BaseCrawlService.class);

    /**
     * 个股研究报告
     * @param pageSize 每页条数
     * @param currPage 当前页
     * @param code 股票代码
     * @param mkt 评级类别 0-全部 1-买入 2-增持 3-中性 4-减持 5-卖出
     * @param stat 评级变动 0-全部 1-维持 2-调高 3-调低 4-首次 5-无
     */
    public Message<List<t_eastmoney_ggsr>> stockResearchReport(String pageSize, String currPage, String code, String mkt, String stat){
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
            String result = html.substring(1,html.length()-1);

            JSONArray jsonArray = JSONArray.parseArray(result);
            if(jsonArray.getJSONObject(0).getBoolean("stats")!=null&&!(jsonArray.getJSONObject(0).getBoolean("stats"))){
                return Message.error();
            }

            List<t_eastmoney_ggsr> ggsrList = jsonArray.toJavaList(t_eastmoney_ggsr.class);
            if(ggsrList.size()==0){
                return Message.error();
            }
            return Message.success(ggsrList);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Message.error();
        }
    }


    /*
     * 根据股票代码分页
     */
    public Message<List<t_eastmoney_ggsr>> findStockResearchReport(String code,String currPage,String pageSize){
        Pageable pageable = PageRequest.of(Integer.parseInt(currPage),Integer.parseInt(pageSize));
        Page<t_eastmoney_ggsr> ggsrList = ggsrDao.findByCode(code,pageable);

        return Message.success(ggsrList.getContent());
    }

    /**
     * 行业研究报告
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
    public Message<List<t_eastmoney_hysr>> industryResearchReport(String pageSize, String currPage,String sc,String mkt,String stat){
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

            //这里处理内容中的双引号导致json转化异常问题
            String[] resArr = result.substring(2,result.length()-2).split("\",\"");
            List<String> stringList= new ArrayList<>();
            for (String s : resArr) {
                stringList.add(s.replace("\"","&quot;"));
            }

            List<t_eastmoney_hysr> hysrList= new ArrayList<>();
            for (String s : stringList) {
                String[] arr = s.split(",");
                t_eastmoney_hysr hysr = new t_eastmoney_hysr();
                hysr.setPjbd(arr[0]);//评级变动
                hysr.setBgrq(arr[1]);//报告日期
                hysr.setInfoCode(arr[2]);//研报地址标识
                hysr.setJgmc(arr[4]);//机构名称
                hysr.setPjlb(arr[7]);//评级类别
                hysr.setBt(arr[9]);//标题
                hysr.setHymc(arr[10]);//行业名称
                hysr.setZdf(arr[11]);//涨跌幅

                hysrList.add(hysr);
            }

            return Message.success(hysrList);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Message.error();
        }
    }

    /*
     * 分页查询行业研报
     */
    public Message<List<t_eastmoney_hysr>> findIndustryResearchReport(String currPage,String pageSize){
        Pageable pageable = PageRequest.of(Integer.parseInt(currPage),Integer.parseInt(pageSize));
        Page<t_eastmoney_hysr> ggsrList = hysrDao.findAll(pageable);

        return Message.success(ggsrList.getContent());
    }

    @Override
    //更新个股研报
    public void updateByStockCodes(String code) {
        updatestockResearchReport("50","1",StockCodeUtil.getNumberStockCode(code),"0","0");
    }

    /**
     * 获取该股票所有的个股研报
     */
    private void updatestockResearchReport(String pageSize, String currPage, String code, String mkt, String stat){
        Message<List<t_eastmoney_ggsr>> listMessage = stockResearchReport(pageSize,currPage,code,mkt,stat);
        if(!listMessage.fail()){
            //更新数据
            for (t_eastmoney_ggsr ggsr : listMessage.getData()) {
                if(ggsrDao.findByInfoCode(ggsr.getInfoCode())==null){
                    ggsr.setCode(code);
                    ggsrDao.save(ggsr);
                }
            }

            //下一页数据
            if(!(listMessage.getData().size()<Integer.parseInt(pageSize))){
                updatestockResearchReport(pageSize,String.valueOf(Integer.parseInt(currPage)+1),code,mkt,stat);
            }
        }
    }

    /**
     * 获取该股票所有的行业研报
     */
    public void updateIndustryResearchReport(String pageSize, String currPage, String sc, String mkt, String stat){
        Message<List<t_eastmoney_hysr>>  hysrMessage =  industryResearchReport(pageSize,currPage,sc,mkt,stat);
        if(!hysrMessage.fail()){
            //更新数据
            for (t_eastmoney_hysr hysr : hysrMessage.getData()) {
                if(hysrDao.findByInfoCode(hysr.getInfoCode())==null){
                    hysrDao.save(hysr);
                }
            }

            //下一页数据
            if(!(hysrMessage.getData().size()<Integer.parseInt(pageSize))){
                updateIndustryResearchReport(pageSize,String.valueOf(Integer.parseInt(currPage)+1),sc,mkt,stat);
            }
        }
    }
}
