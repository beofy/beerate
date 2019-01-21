package cn.beerate.controller;

import cn.beerate.common.Message;
import cn.beerate.model.entity.stock.t_company_big_news;
import cn.beerate.service.CompanyBigNewsService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "公司大事")
@RestController
@ApiResponses({
        @ApiResponse(code = Message.Code.SUCCESS,message = "success"),
        @ApiResponse(code = Message.Code.ERROR,message = "error"),
})
public class CompanyBigNewsController {

    @Autowired
    private CompanyBigNewsService bigNewsService;

    @GetMapping(value = "/companyBigNews")
    @ApiOperation(value = "根据股票代码获取公司大事", notes = "包含(大事提醒|重大事项|限售解禁|十大股东持股变动|高管持股变动|龙虎榜单|大宗交易|融资融券)")

    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
    })
    public Message companyBigNews(@Param(value = "code") String code){
        if(StringUtil.isBlank(code)){
            Message.error("股票代码错误");
        }

        Message<t_company_big_news> message = bigNewsService.findByCode(code);
        //如果数据库中未保存
        if(message.getCode()==Message.Code.ERROR){
            Message<String> message1 = bigNewsService.companyBigNews(code);
            //未抓取到
            if(message1.getCode()==Message.Code.ERROR){
               return message;
            }

            //json转对象
            return Message.success(JSONObject.parseObject(message1.getData()));
        }

        return message;
    }
}
