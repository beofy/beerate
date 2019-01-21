package cn.beerate.controller;

import cn.beerate.common.Message;
import cn.beerate.model.bean.CompanyBigNews;
import cn.beerate.model.bean.companybignews.Dwdb;
import cn.beerate.model.bean.companybignews.Gqzy;
import cn.beerate.service.CompanyBigNewsService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @ApiOperation(value = "根据股票代码获取公司大事", notes = "包含(" +
            "dstx:大事提醒|重大事项(股权质押:dzjy,对外担保:dwdb,诉讼仲裁:sszc,违规处理:wgcl)|" +
            "限售解禁:xsjj|十大股东持股变动:sdgdcgbd |高管持股变动:ggcgbd|" +
            "龙虎榜单:lhbd|大宗交易:dzjy|融资融券:rzrq)")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
    })
    public Message<CompanyBigNews> companyBigNews(@Param(value = "code") String code){
        if(StringUtil.isBlank(code)){
            Message.error("股票代码错误");
        }

        Message<String> message = bigNewsService.companyBigNews(code);
        //未抓取到
        if(message.getCode()==Message.Code.ERROR){
           return Message.error("无数据");
        }

        CompanyBigNews companyBigNews = new CompanyBigNews();
        JSONObject jsonObject = JSONObject.parseObject(message.getData());

        //json转对象
        List<Gqzy> gqzyList = jsonObject.getJSONArray("gqzy").toJavaList(Gqzy.class);
        List<Dwdb> dwdbList = jsonObject.getJSONArray("dwdb").toJavaList(Dwdb.class);

        companyBigNews.gqzy=gqzyList;
        companyBigNews.dwdb=dwdbList;

        return Message.success(companyBigNews);

    }
}
