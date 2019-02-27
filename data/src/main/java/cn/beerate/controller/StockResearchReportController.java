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
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string")
    })
    public Message<List<GGSR>> shareholderResearch(@Param("pageSize") String pageSize,@Param("currPage") String currPage,@Param("code") String code){
       if(code==null||code.isEmpty()){
           code="";
       }else{
           if(!StockCodeUtil.isStockCode(code)){
               return Message.error("股票代码错误");
           }
       }

       return stockResearchReportService.stockResearchReport(pageSize,currPage,code);
    }
}
