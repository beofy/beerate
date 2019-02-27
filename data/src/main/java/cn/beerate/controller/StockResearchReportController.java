package cn.beerate.controller;

import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.bean.eastmoney.f10.ShareholderResearch;
import cn.beerate.model.bean.eastmoney.report.GGSR;
import cn.beerate.service.eastmoney.f10.ShareholderResearchService;
import cn.beerate.service.eastmoney.report.StockResearchReportService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "机构研究报告中心")
@RestController
@ApiResponses({
        @ApiResponse(code = Message.Code.SUCCESS,message = "success"),
        @ApiResponse(code = Message.Code.ERROR,message = "error"),
})
public class StockResearchReportController {
    @Autowired
    private StockResearchReportService stockResearchReportService;

    @GetMapping(value = "stockReport")
    @ApiOperation(value = "根据股票代码获取个股研报",notes = "个股研报")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "每页条数", name = "pageSize", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "当前页数", name = "currPage", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string"),
            @ApiImplicitParam(value = "评级类别 \t0-全部 1-买入 2-增持 3-中性 4-减持 5-卖出", name = "mkt", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "评级变动 \t0-全部 1-维持 2-调高 3-调低 4-首次 5-无", name = "stat", paramType = "query", dataType = "string", required = true)
    })
    public Message<List<GGSR>> shareholderResearch(@Param("pageSize") String pageSize,@Param("currPage") String currPage,@Param("code") String code,@Param("mkt") String mkt,@Param("stat") String stat){
       if(code==null||code.isEmpty()){
           code="";
       }else{
           if(!StockCodeUtil.isStockCode(code)){
               return Message.error("股票代码错误");
           }
       }

       return stockResearchReportService.stockResearchReport(pageSize,currPage,code,mkt,stat);
    }
}
