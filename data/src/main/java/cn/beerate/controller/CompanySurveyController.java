package cn.beerate.controller;

import cn.beerate.common.Message;
import cn.beerate.model.entity.stock.t_company_big_news;
import cn.beerate.model.entity.stock.t_company_survey;
import cn.beerate.service.CompanySurveyService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.jsoup.helper.StringUtil;
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
    public Message<t_company_survey> companySurvey(@Param(value = "code")String code){
        if(StringUtil.isBlank(code)){
            Message.error("股票代码错误");
        }

        Message<t_company_survey> message = companySurveyService.findByCode(code);
        //如果数据库中未保存
        if(message.getCode()==Message.Code.ERROR){
            Message<String> message1 = companySurveyService.companySurvey(code);
            //未抓取到
            if(message1.getCode()==Message.Code.ERROR){
                return message;
            }

            //json转对象
            return Message.success(JSONObject.parseObject(message1.getData()).toJavaObject(t_company_survey.class));
        }

        return message;
    }

}
