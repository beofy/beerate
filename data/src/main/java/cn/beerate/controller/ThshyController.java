package cn.beerate.controller;

import cn.beerate.common.Constants.StatusCode;
import cn.beerate.common.Message;
import cn.beerate.model.bean.tenjqka.DetailThshy;
import cn.beerate.model.bean.tenjqka.Thshy;
import cn.beerate.service.tenjqka.ThshyService;
import io.swagger.annotations.*;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "同花顺行业")
@RestController
@ApiResponses({
        @ApiResponse(code = StatusCode.SUCCESS,message = "success"),
        @ApiResponse(code = StatusCode.ERROR,message = "error"),
})
public class ThshyController {

    private ThshyService thshyService;

    public ThshyController(ThshyService thshyService) {
        this.thshyService = thshyService;
    }

    @GetMapping(value = "indexThshy")
    @ApiOperation(value = "获取同花顺行业表",notes = "同花顺行业表")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "排序类型 \n" +
                    "行业涨跌幅--199112 \n" +
                    "总成交量（万手）-- 13 \n" +
                    "总成交额（亿元）-- 19 \n" +
                    "净流入（亿元）-- zjjlr \n" +
                    "均价 -- 330184", name = "field", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "排序方式 \tdesc--降序 | asc--升序", name = "order", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "页数", name = "page", paramType = "query", dataType = "string", required = true),
    })
    public Message<List<Thshy>> indexThshy(@Param("field") String field, @Param("order") String order,@Param("page") String page){
        List<Thshy> thshyList = thshyService.indexThshy(field,order,page);

        if (thshyList.isEmpty()){
            Message.error("无数据");
        }

        return Message.success(thshyList);
    }

    @GetMapping(value = "detailThshy")
    @ApiOperation(value = "根据行业代码获取行业涨跌排行",notes = "行业涨跌排行")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "排序类型 \n" +
                    "现价--10 \n" +
                    "涨跌幅(%)--199112 \n" +
                    "涨跌--264648 \n" +
                    "涨速(%)-- 48 \n" +
                    "换手(%)-- 1968584 \n" +
                    "量比-- 1771976 \n" +
                    "振幅(%)-- 526792 \n" +
                    "成交额-- 19 \n" +
                    "流通股-- 407 \n" +
                    "流通市值-- 3475914 \n" +
                    "市盈率-- 2034120", name = "field", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "排序方式 \tdesc--降序 | asc--升序", name = "order", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "页数", name = "page", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "行业代码", name = "code", paramType = "query", dataType = "string", required = true),
    })
    public Message<List<DetailThshy>> detailThshy(@Param("field")String field, @Param("order")String order, @Param("page")String page,  @Param("code")String code){
        List<DetailThshy> detailThshyList = thshyService.detailThshy(field,order,page,code);

        if (detailThshyList.isEmpty()){
            Message.error("无数据");
        }

        return Message.success(detailThshyList);
    }


}
