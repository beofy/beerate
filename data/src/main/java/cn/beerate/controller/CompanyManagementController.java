package cn.beerate.controller;

import cn.beerate.common.Constants.StatusCode;
import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.bean.eastmoney.f10.CompanyManagement;
import cn.beerate.service.eastmoney.f10.CompanyManagementService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(description = "公司高管")
@RestController
@ApiResponses({
        @ApiResponse(code = StatusCode.SUCCESS,message = "success"),
        @ApiResponse(code = StatusCode.ERROR,message = "error"),
})
public class CompanyManagementController {
    private CompanyManagementService companyManagementService;

    public CompanyManagementController(CompanyManagementService companyManagementService){
        this.companyManagementService=companyManagementService;
    }

    @GetMapping(value = "/companyManagement")
    @ApiOperation(value = "根据股票代码获取公司高管", notes = "包含(高管列表|高管持股变动|管理层简介)")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
    })
    public Message<CompanyManagement> companyManagement(@Param("code") String code){
        //参数校验
        String aBStock = StockCodeUtil.getABStock(code);
        if(aBStock==null){
            return Message.error("股票代码错误");
        }

        //从数据库获取
        Message<CompanyManagement> message = companyManagementService.findCompanyManagementByStockCode(aBStock);
        if(!message.fail()){
            return message;
        }

        return companyManagementService.companyManagement(aBStock);
    }
}
