package cn.beerate.controller;

import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.bean.eastmoney.CompanyManagement;
import cn.beerate.service.eastmoney.CompanyManagementService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(description = "公司高管")
@RestController
@ApiResponses({
        @ApiResponse(code = Message.Code.SUCCESS,message = "success"),
        @ApiResponse(code = Message.Code.ERROR,message = "error"),
})
public class CompanyManagementController {

    @Autowired
    private CompanyManagementService companyManagementService;

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

        Message<String> message = companyManagementService.companyManagement(aBStock);
        //未抓取到
        if(message.getCode()==Message.Code.ERROR){
            return Message.error("无数据");
        }

        //json转对象
        JSONObject jsonObject = JSONObject.parseObject(message.getData());

        return Message.success(jsonObject.toJavaObject(CompanyManagement.class));
    }
}
