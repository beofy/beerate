package cn.beerate.controller;

import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.bean.eastmoney.BusinessAnalysis;
import cn.beerate.service.eastmoney.BusinessAnalysisService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "经营分析")
@RestController
@ApiResponses({
        @ApiResponse(code = Message.Code.SUCCESS,message = "success"),
        @ApiResponse(code = Message.Code.ERROR,message = "error"),
})
public class BusinessAnalysisController {

    @Autowired
    private BusinessAnalysisService businessAnalysisService;

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

        Message<String> message = businessAnalysisService.businessAnalysis(aBStock);
        //未抓取到
        if(message.getCode()==Message.Code.ERROR){
            return Message.error("无数据");
        }

        //json转对象
        JSONObject jsonObject = JSONObject.parseObject(message.getData());

        return Message.success(jsonObject.toJavaObject(BusinessAnalysis.class));
    }
}