package cn.beerate.controller;

import cn.beerate.common.Constants.StatusCode;
import cn.beerate.common.Message;
import cn.beerate.common.util.DateUtil;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.bean.eastmoney.f10.BonusFinancing;
import cn.beerate.service.eastmoney.f10.BonusFinancingService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "分红融资")
@RestController
@ApiResponses({
        @ApiResponse(code = StatusCode.SUCCESS,message = "success"),
        @ApiResponse(code = StatusCode.ERROR,message = "error"),
})
public class BonusFinancingController {
    private BonusFinancingService bonusFinancingService;

    public BonusFinancingController(BonusFinancingService bonusFinancingService){
        this.bonusFinancingService=bonusFinancingService;
    }

    @GetMapping(value = "/bonusFinancing")
    @ApiOperation(value = "根据股票代码获取分红融资", notes = "包含(分红影响 |历年分红融资|增发明细|配股明细)")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
    })
    public Message<BonusFinancing> bonusFinancing(@Param("code") String code){
        //参数校验
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        //从数据库查询
        Message<BonusFinancing>  bonusFinancingMessage = bonusFinancingService.findByStockCode(aBStock);
        if(!bonusFinancingMessage.fail()){
            return bonusFinancingMessage;
        }

        return bonusFinancingService.bonusFinancing(aBStock);
    }

    @GetMapping(value = "/getBonusDetail")
    @ApiOperation(value = "按日期获取分红融资明细", notes = "时期内每日收盘价格(元)")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "日期", name = "date", paramType = "query", dataType = "string", required = true),
    })
    public Message<List<String>> getBonusDetail(@Param("code") String code, @Param("date") String date){
        //参数校验
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }
        if(!DateUtil.isDateString(date)){
            return Message.error("时间格式错误");
        }

        Message<String> message = bonusFinancingService.bonusDetailChart(aBStock,date);
        //未抓取到
        if(message.getCode()==StatusCode.ERROR){
            return Message.error("无数据");
        }
        List<String> stringList =  JSONObject.parseArray(message.getData()).toJavaList(String.class);

        return Message.success(stringList);
    }


}
