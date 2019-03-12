package cn.beerate.service.eastmoney.f10;

import cn.beerate.common.Message;
import cn.beerate.service.BaseCrawlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 财务分析
 */
@Component
@Transactional(readOnly = true)
public class NewFinanceAnalysisService extends BaseCrawlService {

    /** 财务分析-页面 */
    private final String INDEX_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/Index";
    /** 主要指标 */
    private final String MAIN_TARGET_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/MainTargetAjax";
    /** 杜邦分析 */
    private final String DUBANG_ANALYSIS_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/DubangAnalysisAjax";
    /** 资产负载表 */
    private final String ZCFZB_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/zcfzbAjax";
    /** 利润表 */
    private final String LRB_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/lrbAjax";
    /** 现金流量表 */
    private final String XJLLB_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/xjllbAjax";
    /** 百分比报表 */
    private final String PERCENT_INDEX_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/PercentAjax_Indx";
    private final String PERCENT_URL="http://emweb.securities.eastmoney.com/NewFinanceAnalysis/PercentAjax";

    /**
     * 抓取主要指标
     * @param type 0-按报告期 1-按年度 2-按单季度
     * @param stockCode 股票代码
     */
    public Message<String> mainTarget(String type,String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);
        params.put("type",type);

        return Message.success(super.getJsonString(this.MAIN_TARGET_URL,params));
    }

    /**
     * 抓取杜邦分析
     * @param stockCode 股票代码
     * @return Message<String>
     */
    public Message<String> dubangAnalysis(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);

        return Message.success(super.getJsonString(this.DUBANG_ANALYSIS_URL,params));
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
    public Message<String> zcfzb(String companyType,String reportDateType, String  reportType, String  endDate, String  stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("companyType",companyType);
        params.put("reportDateType",reportDateType);
        params.put("reportType",reportType);
        params.put("endDate",endDate);//可为空
        params.put("code",stockCode);

        return Message.success(super.getJsonString(this.ZCFZB_URL,params));
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
     * @param reportDateType reportDateType
     * @param reportType reportType
     * @param endDate endDate
     * @param stockCode 股票代码
     * @return Message<String>
     */
    public Message<String> zcfzb(String reportDateType, String  reportType, String  endDate, String  stockCode){
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
    public Message<String> lrb(String companyType,String reportDateType, String  reportType, String  endDate, String  stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("companyType",companyType);
        params.put("reportDateType",reportDateType);
        params.put("reportType",reportType);
        params.put("endDate",endDate);//可为空
        params.put("code",stockCode);

        return Message.success(super.getJsonString(this.LRB_URL,params));
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
     * @param reportDateType reportDateType
     * @param reportType reportType
     * @param endDate endDate
     * @param stockCode stockCode
     * @return Message<String>
     */
    public Message<String> lrb(String reportDateType,String reportType,String endDate,String stockCode){
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
    public Message<String> xjllb(String companyType,String reportDateType, String  reportType, String  endDate, String  stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("companyType",companyType);
        params.put("reportDateType",reportDateType);
        params.put("reportType",reportType);
        params.put("endDate",endDate);//可为空
        params.put("code",stockCode);

        return Message.success(super.getJsonString(this.XJLLB_URL,params));
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
     * @param reportDateType reportDateType
     * @param reportType reportType
     * @param endDate endDate
     * @param stockCode stockCode
     * @return Message<String>
     */
    public Message<String> xjllb(String reportDateType, String  reportType, String  endDate, String  stockCode){
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
    public Message<String> percent(String stockCode,String ctype,String type){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);
        params.put("ctype",ctype);
        params.put("type",type);

        return Message.success(super.getJsonString(this.PERCENT_URL,params));
    }

    /**
     * 抓取百分比报表
     * @param stockCode 股票代码
     * @return Message<String>
     */
    public Message<String> percentIndex(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);

        return Message.success(super.getJsonString(this.PERCENT_INDEX_URL,params));
    }

    /**
     *  按类型-抓取百分比表
     * @param stockCode 股票代码
     * @param type 0-按报告期 1-按年度 2-按单季度
     * @return Message<String>
     */
    public Message<String> percent(String stockCode,String type){
        String companyType=this.getCompanyType(this.INDEX_URL,stockCode);
        return this.percent( stockCode, companyType, type);
    }

}
