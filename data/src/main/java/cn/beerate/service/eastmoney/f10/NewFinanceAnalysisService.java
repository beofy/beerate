package cn.beerate.service.eastmoney.f10;

import cn.beerate.common.Message;
import cn.beerate.dao.eastmoney.f10.newfinanceanalysis.*;
import cn.beerate.model.bean.eastmoney.f10.Zb;
import cn.beerate.model.bean.eastmoney.f10.DubangAnalysis;
import cn.beerate.model.entity.eastmoney.f10.newfinanceanalysis.*;
import cn.beerate.service.EastMoneyService;
import cn.beerate.service.IEastMoneyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 财务分析
 */
@Component
@Transactional(readOnly = true)
public class NewFinanceAnalysisService extends EastMoneyService {

    private DubangDao dubangDao;
    private LrbDao lrbDao;
    private LrDao lrDao;
    private MainTargetDao mainTargetDao;
    private XjllbDao xjllbDao;
    private ZbDetailDao zbDetailDao;
    private ZcfzbDao zcfzbDao;

    private MainTargetService mainTargetService = new MainTargetService();
    private DubangAnalysisService dubangAnalysisService = new DubangAnalysisService();
    private ZcfzbService zcfzbService = new ZcfzbService();
    private LrbService lrbService = new LrbService();
    private XjllbService xjllbService = new XjllbService();
    private PercentService percentService = new PercentService();

    public NewFinanceAnalysisService(DubangDao dubangDao, LrbDao lrbDao, LrDao lrDao, MainTargetDao mainTargetDao, XjllbDao xjllbDao, ZbDetailDao zbDetailDao, ZcfzbDao zcfzbDao) {
        this.dubangDao = dubangDao;
        this.lrbDao = lrbDao;
        this.lrDao = lrDao;
        this.mainTargetDao = mainTargetDao;
        this.xjllbDao = xjllbDao;
        this.zbDetailDao = zbDetailDao;
        this.zcfzbDao = zcfzbDao;
    }

    /** 财务分析-页面 */
    private final String INDEX_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/Index";

    /**
     * 抓取主要指标
     * @param type 0-按报告期 1-按年度 2-按单季度
     * @param stockCode 股票代码
     */
    public Message<List<t_eastmoney_main_target>> mainTarget(String type,String stockCode){
        String url ="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/MainTargetAjax";
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);
        params.put("type",type);

        return super.getListBean(t_eastmoney_main_target.class,url,params);
    }

    /**
     * 抓取杜邦分析
     * @param stockCode 股票代码
     * @return Message<String>
     */
    public Message<DubangAnalysis> dubangAnalysis(String stockCode){
        String url="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/DubangAnalysisAjax";
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);

        return super.getBean(DubangAnalysis.class,url,params);
    }

    /**
     * 资产负债表 <br>
     * <ul style="color:red">
     *      <li >
     *          <span>按报告期 -- reportdatetype="0" reporttype="1"</span>
     *      </li>
     *      <li>
     *          <span>按年度 -- reportdatetype="1" reporttype="1"</span>
     *      </li>
     *      <li>
     *          <span>按单季度 -- reportdatetype="0" reporttype="2"</span>
     *      </li>
     * </ul>
     * @param companyType companyType
     * @param reportDateType reportDateType
     * @param reportType reportDateType
     * @param endDate reportDateType
     * @param stockCode 股票代码
     * @return Message<String>
     */
    private Message<List<t_eastmonney_zcfzb>> zcfzb(String companyType, String reportDateType, String  reportType, String  endDate, String  stockCode){
        String url="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/zcfzbAjax";
        Map<String,String> params = new HashMap<>();
        params.put("companyType",companyType);
        params.put("reportDateType",reportDateType);
        params.put("reportType",reportType);
        params.put("endDate",endDate);//可为空
        params.put("code",stockCode);

        return super.getListBean(t_eastmonney_zcfzb.class,url,params);
    }

    /**
     * @see NewFinanceAnalysisService#zcfzb(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public Message<List<t_eastmonney_zcfzb>> zcfzb(String reportDateType, String  reportType, String  endDate, String  stockCode){
        String companyType=this.getCompanyType(this.INDEX_URL,stockCode);
        return this.zcfzb(companyType,reportDateType,reportType,endDate,stockCode);
    }

    /**
     * 抓取利润表
     * <ul style="color:red">
     *      <li >
     *          <span>按报告期 -- reportdatetype="0" reporttype="1"</span>
     *      </li>
     *      <li>
     *          <span>按年度 -- reportdatetype="1" reporttype="1"</span>
     *      </li>
     *      <li>
     *          <span>按单季度 -- reportdatetype="0" reporttype="2"</span>
     *      </li>
     * </ul>
     * @param companyType companyType
     * @param reportDateType reportDateType
     * @param reportType reportType
     * @param endDate endDate
     * @param stockCode 股票代码
     * @return Message<String>
     */
    private Message<List<t_eastmoney_lrb>> lrb(String companyType, String reportDateType, String  reportType, String  endDate, String  stockCode){
        String url="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/lrbAjax";
        Map<String,String> params = new HashMap<>();
        params.put("companyType",companyType);
        params.put("reportDateType",reportDateType);
        params.put("reportType",reportType);
        params.put("endDate",endDate);//可为空
        params.put("code",stockCode);

        return super.getListBean(t_eastmoney_lrb.class,url,params);
    }

    /**
     * @see NewFinanceAnalysisService#lrb(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public Message<List<t_eastmoney_lrb>> lrb(String reportDateType, String reportType, String endDate, String stockCode){
        String companyType=this.getCompanyType(this.INDEX_URL,stockCode);
        return this.lrb(companyType,reportDateType,reportType,endDate,stockCode);
    }

    /**
     * 抓取现金流量表
     * <ul style="color:red">
     *      <li >
     *          <span>按报告期 -- reportdatetype="0" reporttype="1"</span>
     *      </li>
     *      <li>
     *          <span>按年度 -- reportdatetype="1" reporttype="1"</span>
     *      </li>
     *      <li>
     *          <span>按单季度 -- reportdatetype="0" reporttype="2"</span>
     *      </li>
     * </ul>
     * @param companyType companyType
     * @param reportDateType reportDateType
     * @param reportType reportType
     * @param endDate endDate
     * @param stockCode stockCode
     * @return Message<String>
     */
    private Message<List<t_eastmoney_xjllb>> xjllb(String companyType, String reportDateType, String  reportType, String  endDate, String  stockCode){
        String url="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/xjllbAjax";
        Map<String,String> params = new HashMap<>();
        params.put("companyType",companyType);
        params.put("reportDateType",reportDateType);
        params.put("reportType",reportType);
        params.put("endDate",endDate);//可为空
        params.put("code",stockCode);

        return super.getListBean(t_eastmoney_xjllb.class,url,params);
    }

    /**
    * @see NewFinanceAnalysisService#xjllb(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public Message<List<t_eastmoney_xjllb>> xjllb(String reportDateType, String  reportType, String  endDate, String  stockCode){
        String companyType=this.getCompanyType(this.INDEX_URL,stockCode);
        return this.xjllb(companyType,reportDateType,reportType,endDate,stockCode);
    }

    /**
     * 抓取百分比表
     * @param stockCode 股票代码
     * @param ctype ctype
     * @param type 0-按报告期 1-按年度 2-按单季度
     * @return Message<String>
     */
    private Message<Zb> percent(String stockCode,String ctype,String type){
        String url="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/PercentAjax";
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);
        params.put("ctype",ctype);
        params.put("type",type);

        return super.getBean(Zb.class,url,params);
    }

    /**
     * 抓取百分比报表
     * @param stockCode 股票代码
     * @return Message<String>
     */
    public Message<List<t_eastmoney_zb_detail>> percentIndex(String stockCode){
        String url="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/PercentAjax_Indx";
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);

        return super.getListBean(t_eastmoney_zb_detail.class,url,params);
    }

    /**
     *  按类型-抓取百分比表
     * @param stockCode 股票代码
     * @param type 0-按报告期 1-按年度 2-按单季度
     * @return Message<String>
     */
    public Message<Zb> percent(String stockCode, String type){
        String companyType=this.getCompanyType(this.INDEX_URL,stockCode);
        return this.percent( stockCode, companyType, type);
    }

    /**
     * 根据股票代码更新主要指标
     */
    @Transactional
    public void updateMainTarget(String code){
        Message<List<t_eastmoney_main_target>> listMessage0 =  mainTarget("0",code);//报告期
        if(listMessage0.fail()){
            return;
        }
        listMessage0.getData().forEach(t_eastmoney_main_target -> t_eastmoney_main_target.setType("0"));

        Message<List<t_eastmoney_main_target>> listMessage1 =  mainTarget("1",code);//年度
        if(listMessage1.fail()){
            return;
        }
        listMessage1.getData().forEach(t_eastmoney_main_target -> t_eastmoney_main_target.setType("1"));

        Message<List<t_eastmoney_main_target>> listMessage2 =  mainTarget("2",code);//单季度
        if(listMessage2.fail()){
            return;
        }
        listMessage2.getData().forEach(t_eastmoney_main_target -> t_eastmoney_main_target.setType("2"));

        List<t_eastmoney_main_target> mainTargetList = new ArrayList<>();
        mainTargetList.addAll(listMessage0.getData());
        mainTargetList.addAll(listMessage1.getData());
        mainTargetList.addAll(listMessage2.getData());
        mainTargetList.forEach(t_eastmoney_main_target -> t_eastmoney_main_target.setCode(code));

        //删除数据
        mainTargetDao.deleteByCode(code);

        //保存数据
        mainTargetDao.saveAll(mainTargetList);
    }

    /**
     * 根据股票更新杜邦分析
     */
    @Transactional
    public void updateDubangAnalysis(String code){
        Message<DubangAnalysis> dubangAnalysisMessage = dubangAnalysis(code);
        if(dubangAnalysisMessage.fail()){
            return;
        }
        dubangAnalysisMessage.getData().getBgq().forEach(t_eastmoney_dubang -> t_eastmoney_dubang.setType("0"));//报告期
        dubangAnalysisMessage.getData().getNd().forEach(t_eastmoney_dubang -> t_eastmoney_dubang.setType("1"));//年度

        List<t_eastmoney_dubang> dubangList = new ArrayList<>(dubangAnalysisMessage.getData().getBgq());
        dubangList.addAll(dubangAnalysisMessage.getData().getNd());

        //添加股票代码
        dubangList.forEach(t_eastmoney_dubang -> t_eastmoney_dubang.setCode(code));

        //删除数据
        dubangDao.deleteByCode(code);

        //保存数据
        dubangDao.saveAll(dubangList);
    }

    /**
     * 根据股票更新资产负债表
     */
    @Transactional
    public void updateZcfzb(String code){
        List<t_eastmonney_zcfzb> zcfzbList= new ArrayList<>();

        Message<List<t_eastmonney_zcfzb>> listMessage0=null;
        do{
            String endDate=listMessage0==null?"":listMessage0.getData().get(listMessage0.getData().size()-1).getREPORTDATE();
            listMessage0 = zcfzb("0","1",endDate,code);
            if(listMessage0.getData()!=null){
                zcfzbList.addAll(listMessage0.getData());
            }else{
                listMessage0.setData(new ArrayList<>());
            }
        } while (!listMessage0.fail()||!(listMessage0.getData().size()<5));//报告期


        Message<List<t_eastmonney_zcfzb>> listMessage1=null;
        do {
            String endDate=listMessage1==null?"":listMessage1.getData().get(listMessage1.getData().size()-1).getREPORTDATE();
            listMessage1= zcfzb("1","1",endDate,code);
            if(listMessage1.getData()!=null){
                zcfzbList.addAll(listMessage1.getData());
            }else{
                listMessage1.setData(new ArrayList<>());
            }
        }while (!listMessage1.fail()||!(listMessage1.getData().size()<5));//按年度

        //添加股票代码
        zcfzbList.forEach(t_eastmonney_zcfzb -> t_eastmonney_zcfzb.setCode(code));

        //删除数据
        zcfzbDao.deleteByCode(code);

        //保存数据
        zcfzbDao.saveAll(zcfzbList);
    }

    /**
     * 根据股票更新利润表
     */
    @Transactional
    public void updateLrb(String code){
        List<t_eastmoney_lrb> lrbList =new ArrayList<>();

        Message<List<t_eastmoney_lrb>> listMessage0=null;
        do {
            String endDate=listMessage0==null?"":listMessage0.getData().get(listMessage0.getData().size()-1).getREPORTDATE();
            listMessage0 = lrb("0","1",endDate,code);
            if(listMessage0.getData()!=null){
                lrbList.addAll(listMessage0.getData());
            }else{
                listMessage0.setData(new ArrayList<>());
            }
        }while (!listMessage0.fail()||!(listMessage0.getData().size()<5));//按报告期

        Message<List<t_eastmoney_lrb>> listMessage1=null;
        do {
            String endDate=listMessage1==null?"":listMessage1.getData().get(listMessage1.getData().size()-1).getREPORTDATE();
            listMessage1 = lrb("1","1",endDate,code);
            if(listMessage1.getData()!=null){
                lrbList.addAll(listMessage1.getData());
            }else{
                listMessage1.setData(new ArrayList<>());
            }
        }while (!listMessage1.fail()||!(listMessage1.getData().size()<5));//按年度

        Message<List<t_eastmoney_lrb>> listMessage2=null;
        do {
            String endDate=listMessage2==null?"":listMessage2.getData().get(listMessage2.getData().size()-1).getREPORTDATE();
            listMessage2 = lrb("0","2",endDate,code);
            if(listMessage2.getData()!=null){
                lrbList.addAll(listMessage2.getData());
            }else{
                listMessage2.setData(new ArrayList<>());
            }
        }while (!listMessage2.fail()||!(listMessage2.getData().size()<5));//按单季度

        //添加股票代码
        lrbList.forEach(t_eastmoney_lrb -> t_eastmoney_lrb.setCode(code));

        //删除数据
        lrbDao.deleteByCode(code);

        //保存数据
        lrbDao.saveAll(lrbList);
    }

    /**
     * 根据股票更新现金流量表
     */
    @Transactional
    public void updateXjllb(String code){
        List<t_eastmoney_xjllb> xjllbList =new ArrayList<>();

        Message<List<t_eastmoney_xjllb>> listMessage0=null;
        do {
            String endDate=listMessage0==null?"":listMessage0.getData().get(listMessage0.getData().size()-1).getREPORTDATE();
            listMessage0 = xjllb("0","1",endDate,code);
            if(listMessage0.getData()!=null){
                xjllbList.addAll(listMessage0.getData());
            }else{
                listMessage0.setData(new ArrayList<>());
            }
        }while (!listMessage0.fail()||!(listMessage0.getData().size()<5));//按报告期

        Message<List<t_eastmoney_xjllb>> listMessage1=null;
        do {
            String endDate=listMessage1==null?"":listMessage1.getData().get(listMessage1.getData().size()-1).getREPORTDATE();
            listMessage1 = xjllb("1","1",endDate,code);
            if(listMessage1.getData()!=null){
                xjllbList.addAll(listMessage1.getData());
            }else{
                listMessage1.setData(new ArrayList<>());
            }
        }while (!listMessage1.fail()||!(listMessage1.getData().size()<5));//按年度

        Message<List<t_eastmoney_xjllb>> listMessage2=null;
        do {
            String endDate=listMessage2==null?"":listMessage2.getData().get(listMessage2.getData().size()-1).getREPORTDATE();
            listMessage2 = xjllb("0","2",endDate,code);
            if(listMessage2.getData()!=null){
                xjllbList.addAll(listMessage2.getData());
            }else{
                listMessage2.setData(new ArrayList<>());
            }
        }while (!listMessage2.fail()||!(listMessage2.getData().size()<5));//按单季度

        //添加股票代码
        xjllbList.forEach(t_eastmoney_xjllb -> t_eastmoney_xjllb.setCode(code));

        //删除数据
        xjllbDao.deleteByCode(code);

        //保存数据
        xjllbDao.saveAll(xjllbList);

    }

    /**
     * 根据股票更新百分比报表
     */
    @Transactional
    public void updatePercent(String code){
        List<t_eastmoney_zb_detail> zbDetailList = new ArrayList<>();
        List<t_eastmoney_lr> lrList = new ArrayList<>();

        //按报告期
        Message<Zb> listMessage0 = percent(code,"0");
        if(listMessage0.fail()){
            return;
        }
        if(listMessage0.getData().getZb()!=null){
            listMessage0.getData().getZb().setType("0");
            zbDetailList.add(listMessage0.getData().getZb());
        }
        listMessage0.getData().getLr0().forEach(t_eastmoney_lr -> t_eastmoney_lr.setType("0"));
        listMessage0.getData().getLr1().forEach(t_eastmoney_lr -> t_eastmoney_lr.setType("0"));
        listMessage0.getData().getLr2().forEach(t_eastmoney_lr -> t_eastmoney_lr.setType("0"));
        listMessage0.getData().getLr3().forEach(t_eastmoney_lr -> t_eastmoney_lr.setType("0"));
        lrList.addAll(listMessage0.getData().getLr0());
        lrList.addAll(listMessage0.getData().getLr1());
        lrList.addAll(listMessage0.getData().getLr2());
        lrList.addAll(listMessage0.getData().getLr3());

        // 按年度
        Message<Zb> listMessage1 = percent(code,"1");
        if(listMessage1.fail()){
            return;
        }
        if(listMessage1.getData().getZb()!=null){
            listMessage1.getData().getZb().setType("1");
            zbDetailList.add(listMessage1.getData().getZb());
        }
        listMessage1.getData().getLr0().forEach(t_eastmoney_lr -> t_eastmoney_lr.setType("1"));
        listMessage1.getData().getLr1().forEach(t_eastmoney_lr -> t_eastmoney_lr.setType("1"));
        listMessage1.getData().getLr2().forEach(t_eastmoney_lr -> t_eastmoney_lr.setType("1"));
        listMessage1.getData().getLr3().forEach(t_eastmoney_lr -> t_eastmoney_lr.setType("1"));
        lrList.addAll(listMessage1.getData().getLr0());
        lrList.addAll(listMessage1.getData().getLr1());
        lrList.addAll(listMessage1.getData().getLr2());
        lrList.addAll(listMessage1.getData().getLr3());

        // 按单季度
        Message<Zb> listMessage2 = percent(code,"2");
        if(listMessage2.fail()){
            return;
        }
        if(listMessage2.getData().getZb()!=null){
            listMessage2.getData().getZb().setType("2");
            zbDetailList.add(listMessage2.getData().getZb());
        }
        listMessage2.getData().getLr0().forEach(t_eastmoney_lr -> t_eastmoney_lr.setType("2"));
        listMessage2.getData().getLr1().forEach(t_eastmoney_lr -> t_eastmoney_lr.setType("2"));
        listMessage2.getData().getLr2().forEach(t_eastmoney_lr -> t_eastmoney_lr.setType("2"));
        listMessage2.getData().getLr3().forEach(t_eastmoney_lr -> t_eastmoney_lr.setType("2"));
        lrList.addAll(listMessage2.getData().getLr0());
        lrList.addAll(listMessage2.getData().getLr1());
        lrList.addAll(listMessage2.getData().getLr2());
        lrList.addAll(listMessage2.getData().getLr3());

        //添加股票代码
        zbDetailList.forEach(t_eastmoney_zb_detail -> t_eastmoney_zb_detail.setCode(code));
        lrList.forEach(t_eastmoney_lr -> t_eastmoney_lr.setCode(code));

        //删除数据
        zbDetailDao.deleteByCode(code);
        lrbDao.deleteByCode(code);

        //保存数据
        zbDetailDao.saveAll(zbDetailList);
        lrDao.saveAll(lrList);

    }

    public  Message<List<t_eastmoney_main_target>> findMainTargetByCodeAndType(String code,String type){
        List<t_eastmoney_main_target> mainTargetList = mainTargetDao.findByCodeAndTypeOrderByCreateTimeDesc(code, type);
        if(mainTargetList.isEmpty()){
            return Message.error();
        }

        return Message.success(mainTargetList);
    }

    public Message<DubangAnalysis> findDubangAnalysis(String code){
        List<t_eastmoney_dubang>  dubangList0 = dubangDao.findByCodeAndTypeOrderByCreateTimeDesc(code,"0");//报告期
        List<t_eastmoney_dubang>  dubangList1 = dubangDao.findByCodeAndTypeOrderByCreateTimeDesc(code,"1");//年度

        if(dubangList0.isEmpty()&&dubangList1.isEmpty()){
            return Message.error();
        }

        DubangAnalysis dubangAnalysis = new DubangAnalysis();
        dubangAnalysis.setBgq(dubangList0);
        dubangAnalysis.setNd(dubangList1);

        return Message.success(dubangAnalysis);
    }

    public class MainTargetService implements IEastMoneyService {
        @Override
        public void updateByStockCodes(String code) {
            updateMainTarget(code);
        }
    }

    public class DubangAnalysisService implements IEastMoneyService{
        @Override
        public void updateByStockCodes(String code) {
            updateDubangAnalysis(code);
        }
    }

    public class ZcfzbService implements IEastMoneyService{
        @Override
        public void updateByStockCodes(String code) {
            updateZcfzb(code);
        }
    }

    public class LrbService implements IEastMoneyService{
        @Override
        public void updateByStockCodes(String code) {
            updateLrb(code);
        }
    }


    public class XjllbService implements IEastMoneyService{
        @Override
        public void updateByStockCodes(String code) {
            updateXjllb(code);
        }
    }

    public class PercentService implements IEastMoneyService{
        @Override
        public void updateByStockCodes(String code) {
            updatePercent(code);
        }
    }

    public MainTargetService getMainTargetService() {
        return mainTargetService;
    }

    public DubangAnalysisService getDubangAnalysisService() {
        return dubangAnalysisService;
    }

    public ZcfzbService getZcfzbService() {
        return zcfzbService;
    }

    public LrbService getLrbService() {
        return lrbService;
    }

    public XjllbService getXjllbService() {
        return xjllbService;
    }

    public PercentService getPercentService() {
        return percentService;
    }
}

