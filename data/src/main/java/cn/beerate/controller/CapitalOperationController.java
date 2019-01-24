package cn.beerate.controller;

import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.bean.CapitalOperation;
import cn.beerate.service.CapitalOperationService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "资本运作")
@RestController
@ApiResponses({
        @ApiResponse(code = Message.Code.SUCCESS,message = "success"),
        @ApiResponse(code = Message.Code.ERROR,message = "error"),
})
public class CapitalOperationController {
    @Autowired
    private CapitalOperationService capitalOperationService;

    @GetMapping(value = "/capitalOperation")
    @ApiOperation(value = "根据股票代码获取资本运作", notes = "包含(募集资金来源 | 项目进度)")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "排序类型:\n截止日期 -- 1\n计划投资(万元) -- 2\n已投入募集资金(万元) -- 3\n建设期(年) -- 4\n收益率(税后) -- 5\n投资回收期(年) -- 6", name = "orderBy", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "是否升序:\n false--降序\ntrue--升序", name = "isAsc", paramType = "query", dataType = "string", required = true),
    })
    public Message<CapitalOperation> capitalOperation(@Param("code") String code, @Param("orderBy")String orderBy, @Param("isAsc")String isAsc){
        //参数校验
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        Message<String> message = capitalOperationService.capitalOperation(aBStock,orderBy,isAsc);
        //未抓取到
        if(message.getCode()==Message.Code.ERROR){
            return Message.error("无数据");
        }

        //json转对象
        JSONObject jsonObject = JSONObject.parseObject(message.getData());

        return Message.success(jsonObject.toJavaObject(CapitalOperation.class));
    }



}
