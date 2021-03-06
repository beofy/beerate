package cn.beerate.controller;

import cn.beerate.common.Constants.StatusCode;
import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.bean.tenjqka.Profile;
import cn.beerate.service.tenjqka.RecentNewsService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "最新动态")
@RestController
@ApiResponses({
        @ApiResponse(code = StatusCode.SUCCESS,message = "success"),
        @ApiResponse(code = StatusCode.ERROR,message = "error"),
})
public class RecentNewsController {

    private RecentNewsService recentNewsService;

    public RecentNewsController(RecentNewsService recentNewsService) {
        this.recentNewsService = recentNewsService;
    }

    @GetMapping(value = "/profile")
    @ApiOperation(value = "根据股票代码获最新动态", notes = "包含(最新动态)")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
    })
    public Message<Profile> profile(String code){

        String numberCode = StockCodeUtil.getNumberStockCode(code);
        if (numberCode==null) {
            Message.error("股票代码错误");
        }

        Message<Profile> profileMessage = recentNewsService.profile(numberCode);

        return profileMessage;
    }

}
