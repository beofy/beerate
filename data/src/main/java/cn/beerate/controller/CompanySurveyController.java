package cn.beerate.controller;

import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.bean.eastmoney.CompanySurvey;
import cn.beerate.service.eastmoney.CompanySurveyService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "公司概况")
@RestController
@ApiResponses({
        @ApiResponse(code = Message.Code.SUCCESS,message = "success"),
        @ApiResponse(code = Message.Code.ERROR,message = "error"),
})
public class CompanySurveyController {

    @Autowired
    private CompanySurveyService companySurveyService;


    @GetMapping(value = "/companySurvey")
    @ApiOperation(value = "根据股票代码获取公司概况", notes = "包含(基本资料 | 发行相关)")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
    })
    public Message<CompanySurvey> companySurvey(@Param(value = "code")String code){
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        Message<String> message = companySurveyService.companySurvey(aBStock);
        //未抓取到
        if(message.getCode()==Message.Code.ERROR){
            return Message.error("无数据");
        }

        //json转对象
        JSONObject jsonObject = JSONObject.parseObject(message.getData());

        return Message.success(jsonObject.toJavaObject(CompanySurvey.class));
    }

}
