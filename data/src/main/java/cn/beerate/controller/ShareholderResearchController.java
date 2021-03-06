package cn.beerate.controller;

import cn.beerate.common.Constants.StatusCode;
import cn.beerate.common.Message;
import cn.beerate.common.util.DateUtil;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.bean.eastmoney.f10.ShareholderResearch;
import cn.beerate.model.entity.eastmoney.f10.shareholderresearch.t_eastmoney_zlcc;
import cn.beerate.service.eastmoney.f10.ShareholderResearchService;
import io.swagger.annotations.*;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "股东研究")
@RestController
@ApiResponses({
        @ApiResponse(code = StatusCode.SUCCESS,message = "success"),
        @ApiResponse(code = StatusCode.ERROR,message = "error"),
})
public class ShareholderResearchController {

    private ShareholderResearchService shareholderResearchService;

    public ShareholderResearchController(ShareholderResearchService shareholderResearchService) {
        this.shareholderResearchService = shareholderResearchService;
    }

    @GetMapping(value = "shareholderResearch")
    @ApiOperation(value = "根据股票代码获取股东研究",notes = "包含(股东人数 |十大流通股东 |十大股东 |机构持仓 |十大股东持股变动 |基金持股 | 限售解禁)")
    @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true)
    public Message<ShareholderResearch> shareholderResearch(@Param("code") String code){
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        return shareholderResearchService.shareholderResearch(aBStock);
    }

    @GetMapping(value = "/mainPositionsHodler")
    @ApiOperation(value = "根据股票代码和日期获取机构持仓",notes = "机构持仓")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "日期", name = "date", paramType = "query", dataType = "string", required = true),
    })
    public Message<List<t_eastmoney_zlcc>> mainPositionsHodler(@Param("code") String code, @Param("date") String date){
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        if(!DateUtil.isDateString(date)){
            return Message.error("时间格式错误");
        }

        return shareholderResearchService.mainPositionsHodler(aBStock,date);
    }
}
