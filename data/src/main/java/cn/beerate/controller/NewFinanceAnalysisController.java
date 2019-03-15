package cn.beerate.controller;

import cn.beerate.common.Constants.StatusCode;
import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.bean.eastmoney.f10.Zb;
import cn.beerate.model.bean.eastmoney.f10.DubangAnalysis;
import cn.beerate.model.entity.eastmoney.f10.newfinanceanalysis.*;
import cn.beerate.service.eastmoney.f10.NewFinanceAnalysisService;
import io.swagger.annotations.*;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "财务分析")
@RestController
@ApiResponses({
        @ApiResponse(code = StatusCode.SUCCESS,message = "success"),
        @ApiResponse(code = StatusCode.ERROR,message = "error"),
})
public class NewFinanceAnalysisController {

    private NewFinanceAnalysisService newFinanceAnalysisService;

    public NewFinanceAnalysisController(NewFinanceAnalysisService newFinanceAnalysisService) {
        this.newFinanceAnalysisService = newFinanceAnalysisService;
    }

    @GetMapping("/mainTarget")
    @ApiOperation(value = "根据股票代码获取主要指标", notes = "主要指标")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "指标类型：\n0-按报告期\n1-按年度\n2-按单季度", name = "type", paramType = "query", dataType = "string", required = true),
    })
    public Message<List<t_eastmoney_main_target>> mainTarget(@Param("code") String code, @Param("type") String type){
        //参数校验
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        //校验type
        String[] types = {"0","1","2"};
        boolean isType=false;
        for (String s : types) {
           if(s.equals(type)) isType=true ;
        }
        if(!isType){
            return  Message.error("type参数错误");
        }

        //从数据库获取
        Message<List<t_eastmoney_main_target>> message = newFinanceAnalysisService.findMainTargetByCodeAndType(aBStock,type);
        if(!message.fail()){
            return message;
        }

        return newFinanceAnalysisService.mainTarget(type,aBStock);
    }

    @GetMapping(value = "/dubangAnalysis")
    @ApiOperation(value = "根据股票代码获取杜邦分析", notes = "杜邦分析")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
    })
    public Message<DubangAnalysis> dubangAnalysis(@Param("code") String code){

        //参数校验
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }
        Message<DubangAnalysis> dubangAnalysisMessage =newFinanceAnalysisService.findDubangAnalysis(aBStock);

        //从数据库获取
        if(!dubangAnalysisMessage.fail()){
            return dubangAnalysisMessage;
        }

        return newFinanceAnalysisService.dubangAnalysis(aBStock);
    }

    @GetMapping(value = "/zcfzb")
    @ApiOperation(value = "根据股票代码获取资产负债表", notes = "资产负债表\n" +
            "按报告期 -- reportdatetype=0 reporttype=1\n" +
            "按年度 -- reportdatetype=1 reporttype=1\n" +
            "按单季度 -- reportdatetype=0 reporttype=2")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "报告日期类型", name = "reportDateType", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "报告类型", name = "reportType", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "结束时间", name = "endDate", paramType = "query", dataType = "string"),
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
    })
    public Message<List<t_eastmonney_zcfzb>> zcfzb(String reportDateType, String  reportType, String  endDate, String  code){

        //参数校验
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        if(null==endDate){
            endDate="";
        }

        return newFinanceAnalysisService.zcfzb(reportDateType,reportType,endDate,aBStock);
    }

    @GetMapping(value = "/lrb")
    @ApiOperation(value = "根据股票代码获取利润表", notes = "利润表\n" +
            "按报告期 -- reportdatetype=0 reporttype=1\n" +
            "按年度 -- reportdatetype=1 reporttype=1\n" +
            "按单季度 -- reportdatetype=0 reporttype=2")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "报告日期类型", name = "reportDateType", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "报告类型", name = "reportType", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "结束时间", name = "endDate", paramType = "query", dataType = "string"),
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
    })
    public Message<List<t_eastmoney_lrb>> lrb(String reportDateType, String reportType, String endDate, String code){
        //参数校验
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        if(null==endDate){
            endDate="";
        }

        return newFinanceAnalysisService.lrb(reportDateType,reportType,endDate,aBStock);
    }

    @GetMapping(value = "/xjllb")
    @ApiOperation(value = "根据股票代码获取现金流量表", notes = "现金流量表\n" +
            "按报告期 -- reportdatetype=0 reporttype=1\n" +
            "按年度 -- reportdatetype=1 reporttype=1\n" +
            "按单季度 -- reportdatetype=0 reporttype=2")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "报告日期类型", name = "reportDateType", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "报告类型", name = "reportType", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "结束时间", name = "endDate", paramType = "query", dataType = "string"),
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
    })
    public Message<List<t_eastmoney_xjllb>> xjllb(String reportDateType, String  reportType, String  endDate, String  code){
        //参数校验
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        if(null==endDate){
            endDate="";
        }

        return newFinanceAnalysisService.xjllb(reportDateType,reportType,endDate,aBStock);
    }

    @GetMapping(value = "/percent")
    @ApiOperation(value = "根据股票代码获取百分比表", notes = "type 0-按报告期 | 1-按年度 | 2-按单季度")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "类型", name = "type", paramType = "query", dataType = "string", required = true),
    })
    public Message<Zb> percent(String code, String type){
        //参数校验
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        return newFinanceAnalysisService.percent(aBStock,type);
    }
}
