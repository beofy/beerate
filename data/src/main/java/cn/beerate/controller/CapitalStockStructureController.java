package cn.beerate.controller;

import cn.beerate.common.Constants.StatusCode;
import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.bean.eastmoney.f10.CapitalStockStructure;
import cn.beerate.service.eastmoney.f10.CapitalStockStructureService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "股本结构")
@RestController
@ApiResponses({
        @ApiResponse(code = StatusCode.SUCCESS,message = "success"),
        @ApiResponse(code = StatusCode.ERROR,message = "error"),
})
public class CapitalStockStructureController {

    private CapitalStockStructureService capitalStockStructureService;

    public CapitalStockStructureController(CapitalStockStructureService capitalStockStructureService) {
        this.capitalStockStructureService = capitalStockStructureService;
    }

    @GetMapping(value = "/capitalStockStructure")
    @ApiOperation(value = "根据股票代码获取股本结构", notes = "包含(限售解禁| 股本结构| 历年股本变动| 股本构成)")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
    })
    public Message<CapitalStockStructure> capitalStockStructure(@Param("code") String code){
        //参数校验
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        //从数据库查询
        Message<CapitalStockStructure> message = capitalStockStructureService.findCapitalStockStructureByStockCode(aBStock);
        if(!message.fail()){
            return message;
        }

        return capitalStockStructureService.capitalStockStructure(aBStock);
    }

}
