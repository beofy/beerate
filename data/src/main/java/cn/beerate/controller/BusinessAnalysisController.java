package cn.beerate.controller;

import cn.beerate.common.Constants.StatusCode;
import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.bean.eastmoney.f10.BusinessAnalysis;
import cn.beerate.service.eastmoney.f10.BusinessAnalysisService;
import io.swagger.annotations.*;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "经营分析")
@RestController
@ApiResponses({
        @ApiResponse(code = StatusCode.SUCCESS,message = "success"),
        @ApiResponse(code = StatusCode.ERROR,message = "error"),
})
public class BusinessAnalysisController {
    private BusinessAnalysisService businessAnalysisService;

    public BusinessAnalysisController(BusinessAnalysisService businessAnalysisService){
        this.businessAnalysisService=businessAnalysisService;
    }

    @GetMapping("/businessAnalysis")
    @ApiOperation(value = "根据股票代码获取经营分析", notes = "包含(主营范围 | 主营构成分析 | 经营评述)")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
    })
    public Message<BusinessAnalysis> businessAnalysis(@Param("code") String code){
        //参数校验
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        //从数据库中获取
        Message<BusinessAnalysis> businessAnalysisMessage = businessAnalysisService.findBusinessAnalysisByStockCode(aBStock);
        if(!businessAnalysisMessage.fail()){
            return businessAnalysisMessage;
        }

        return businessAnalysisService.businessAnalysis(aBStock);
    }
}
