package cn.beerate.controller;

import cn.beerate.common.Constants.StatusCode;
import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.entity.eastmoney.f10.companysurvey.t_eastmoney_companysurvey;
import cn.beerate.service.eastmoney.f10.CompanySurveyService;
import io.swagger.annotations.*;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "公司概况")
@RestController
@ApiResponses({
        @ApiResponse(code = StatusCode.SUCCESS,message = "success"),
        @ApiResponse(code = StatusCode.ERROR,message = "error"),
})
public class CompanySurveyController {

    private final CompanySurveyService companySurveyService;

    public CompanySurveyController(CompanySurveyService companySurveyService){
        this.companySurveyService=companySurveyService;
    }

    @GetMapping(value = "/companySurvey")
    @ApiOperation(value = "根据股票代码获取公司概况", notes = "包含(基本资料 | 发行相关)")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
    })
    public Message<t_eastmoney_companysurvey> companySurvey(@Param(value = "code")String code){
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        //从数据库查询
        Message<t_eastmoney_companysurvey> message = companySurveyService.findCompanysurveyByStockCode(aBStock);
        if(!message.fail()){
            return message;
        }

        return companySurveyService.companySurvey(aBStock);
    }

}
