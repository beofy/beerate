package cn.beerate.controller;

import cn.beerate.common.Constants.StatusCode;
import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.bean.eastmoney.f10.ResearchReport;
import cn.beerate.service.eastmoney.f10.ResearchReportService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "研究报告")
@RestController
@ApiResponses({
        @ApiResponse(code = StatusCode.SUCCESS,message = "success"),
        @ApiResponse(code = StatusCode.ERROR,message = "error"),
})
public class ResearchReportController {

    private ResearchReportService researchReportService;

    public ResearchReportController(ResearchReportService researchReportService) {
        this.researchReportService = researchReportService;
    }

    @GetMapping(value = "/researchReport")
    @ApiOperation(value = "根据股票代码获取研究报告", notes = "包含(研报摘要 公司研报 行业研报)")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
    })
    public Message<ResearchReport> researchReport(@Param(value = "code")String code){
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        Message<String> message = researchReportService.researchReport(aBStock);
        //未抓取到
        if(message.fail()){
            return Message.error("无数据");
        }

        //json转对象
        JSONObject jsonObject = JSONObject.parseObject(message.getData());

        return Message.success(jsonObject.toJavaObject(ResearchReport.class));
    }

}
