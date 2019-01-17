package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.common.util.Crawler;
import cn.beerate.service.base.BaseCrawlService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 财务分析
 */
@Component
public class NewFinanceAnalysisService extends BaseCrawlService {

    private Log log = LogFactory.getLog(NewFinanceAnalysisService.class);

    /** 财务分析-页面 */
    private final static String INDEX_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/Index";
    /** 主要指标 */
    private final static String MAIN_TARGET_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/MainTargetAjax";
    /** 杜邦分析 */
    private final static String DUBANG_ANALYSIS_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/DubangAnalysisAjax";
    /** 资产负载表 */
    private final static String ZCFZB_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/zcfzbAjax";
    /** 利润表 */
    private final static String LRB_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/lrbAjax";
    /** 现金流量表 */
    private final static String XJLLB_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/xjllbAjax";
    /** 百分比报表 */
    private final static String PERCENT_INDEX_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/PercentAjax_Indx";
    private final static String PERCENT_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/PercentAjax";

    /**
     * 抓取主要指标
     * @param type 0-按报告期 1-按年度 2-按单季度
     * @param stockCode 股票代码
     */
    public Message<String> mainTarget(String type,String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);
        params.put("type",type);

        return  super.crawl(this.MAIN_TARGET_URL,params);
    }

    /**
     * 抓取杜邦分析
     * @param stockCode 股票代码
     * @return
     */
    public Message<String> dubangAnalysis(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);

        return super.crawl(this.DUBANG_ANALYSIS_URL,params);
    }

    /**
     * 资产负债表 <br>
     * <ul style="color:red">
     *      <li >
     *          <span>按报告期 -- reportdatetype="0" reporttype="1"</span>
     *      </li>
     *      <li>
     *          <span>按单季度 -- reportdatetype="1" reporttype="1"</span>
     *      </li>
     *      <li>
     *          <span>按报告期同比 -- reportdatetype="0" reporttype="1"</span>
     *      </li>
     *      <li>
     *          <span>年度同比 -- reportdatetype="0" reporttype="1"</span>
     *      </li>
     * </ul>
     * @param companyType
     * @param reportDateType
     * @param reportType
     * @param endDate
     * @param stockCode 股票代码
     * @return
     */
    public Message<String> zcfzb(String companyType,String reportDateType, String  reportType, String  endDate, String  stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("companyType",companyType);
        params.put("reportDateType",reportDateType);
        params.put("reportType",reportType);
        params.put("endDate",endDate);//可为空
        params.put("code",stockCode);

        return super.crawl(this.ZCFZB_URL,params);
    }
    /**
     * 资产负债表 <br>
     * <ul style="color:red">
     *      <li >
     *          <span>按报告期 -- reportdatetype="0" reporttype="1"</span>
     *      </li>
     *      <li>
     *          <span>按单季度 -- reportdatetype="1" reporttype="1"</span>
     *      </li>
     *      <li>
     *          <span>按报告期同比 -- reportdatetype="0" reporttype="1"</span>
     *      </li>
     *      <li>
     *          <span>年度同比 -- reportdatetype="0" reporttype="1"</span>
     *      </li>
     * </ul>
     * @param reportDateType
     * @param reportType
     * @param endDate
     * @param stockCode 股票代码
     * @return
     */
    public Message<String> zcfzb(String reportDateType, String  reportType, String  endDate, String  stockCode){
        String companyType=this.getCompanyType(stockCode);
        return this.zcfzb(companyType,reportDateType,reportType,endDate,stockCode);
    }

    /**
     * 获取companyType
     * @param stockCode
     * @return
     */
    public String getCompanyType(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("type","soft");
        params.put("code",stockCode);

        Map<String,String> map = Crawler.getInstance().getHidden(this.INDEX_URL,params);
        if(map==null||map.isEmpty()){
            return "";
        }

        return map.get("hidctype");
    }

    /**
     * 抓取利润表
     * @param companyType
     * @param reportDateType
     * @param reportType
     * @param endDate
     * @param stockCode
     * @return
     */
    public Message<String> lrb(String companyType,String reportDateType, String  reportType, String  endDate, String  stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("companyType",companyType);
        params.put("reportDateType",reportDateType);
        params.put("reportType",reportType);
        params.put("endDate",endDate);//可为空
        params.put("code",stockCode);

        return super.crawl(this.LRB_URL,params);
    }

    /**
     * 抓取利润表
     * @param reportDateType
     * @param reportType
     * @param endDate
     * @param stockCode
     * @return
     */
    public Message<String> lrb(String reportDateType,String reportType,String endDate,String stockCode){
        String companyType=this.getCompanyType(stockCode);
        return this.lrb(companyType,reportDateType,reportType,endDate,stockCode);
    }

    /**
     * 抓取现金流量表
     * @param companyType
     * @param reportDateType
     * @param reportType
     * @param endDate
     * @param stockCode
     * @return
     */
    public Message<String> xjllb(String companyType,String reportDateType, String  reportType, String  endDate, String  stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("companyType",companyType);
        params.put("reportDateType",reportDateType);
        params.put("reportType",reportType);
        params.put("endDate",endDate);//可为空
        params.put("code",stockCode);

        return super.crawl(this.XJLLB_URL,params);
    }

    /**
     * 抓取现金流量表
     * @param reportDateType
     * @param reportType
     * @param endDate
     * @param stockCode
     * @return
     */
    public Message<String> xjllb(String reportDateType, String  reportType, String  endDate, String  stockCode){
        String companyType=this.getCompanyType(stockCode);
        return this.xjllb(companyType,reportDateType,reportType,endDate,stockCode);
    }

    /**
     * 抓取百分比表
     * @param stockCode 股票代码
     * @param ctype
     * @param type 0-按报告期 1-按年度 2-按单季度
     * @return
     */
    public Message<String> percent(String stockCode,String ctype,String type){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);
        params.put("ctype",ctype);
        params.put("type",type);

        return super.crawl(this.PERCENT_URL,params);
    }

    /**
     * 抓取百分比报表
     * @param stockCode 股票代码
     * @return
     */
    public Message<String> percentIndex(String stockCode){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",stockCode);

        return super.crawl(this.PERCENT_INDEX_URL,params);
    }

    /**
     *  按类型-抓取百分比表
     * @param stockCode 股票代码
     * @param type 0-按报告期 1-按年度 2-按单季度
     * @return
     */
    public Message<String> percent(String stockCode,String type){
        String companyType=this.getCompanyType(stockCode);
        return this.percent( stockCode, companyType, type);
    }

}
