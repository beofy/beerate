package cn.beerate.controller;

import cn.beerate.common.Constants.StatusCode;
import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.bean.eastmoney.f10.CompanyBigNews;
import cn.beerate.model.bean.eastmoney.f10.companybignews.Gqzy;
import cn.beerate.service.eastmoney.f10.CompanyBigNewsService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "公司大事")
@RestController
@ApiResponses({
        @ApiResponse(code = StatusCode.SUCCESS,message = "success"),
        @ApiResponse(code = StatusCode.ERROR,message = "error"),
})
public class CompanyBigNewsController {

    private CompanyBigNewsService bigNewsService;

    public CompanyBigNewsController(CompanyBigNewsService bigNewsService) {
        this.bigNewsService = bigNewsService;
    }

    @GetMapping(value = "/companyBigNews")
    @ApiOperation(value = "根据股票代码获取公司大事", notes = "包含(大事提醒|重大事项|限售解禁|十大股东持股变动|高管持股变动|龙虎榜单|大宗交易|融资融券)")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
    })
    public Message<CompanyBigNews> companyBigNews(@Param(value = "code") String code){
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        Message<String> message = bigNewsService.companyBigNews(aBStock);
        //未抓取到
        if(message.fail()){
           return Message.error("无数据");
        }

        //json转对象
        JSONObject jsonObject = JSONObject.parseObject(message.getData());

        return Message.success(jsonObject.toJavaObject(CompanyBigNews.class));
    }

    @GetMapping(value = "/getPledgeHolder")
    @ApiOperation(value = "分页获取股票质押", notes = "分页获取股票质押")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "页数", name = "index", paramType = "query", dataType = "string", required = true),
    })
    public Message<List<Gqzy>> getPledgeHolder(@Param(value = "code") String code,@Param(value = "index") String index){
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        Message<String> message = bigNewsService.getPledgeHolder(aBStock,index);
        if(message.fail()){
            return Message.error("无数据");
        }

        return Message.success(JSONObject.parseArray(message.getData()).toJavaList(Gqzy.class));
    }
}
