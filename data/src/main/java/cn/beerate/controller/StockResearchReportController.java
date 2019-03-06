package cn.beerate.controller;

import cn.beerate.common.Constants.StatusCode;
import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.bean.eastmoney.report.GGSR;
import cn.beerate.service.eastmoney.report.StockResearchReportService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "机构研究报告中心")
@RestController
@ApiResponses({
        @ApiResponse(code = StatusCode.SUCCESS,message = "success"),
        @ApiResponse(code = StatusCode.ERROR,message = "error"),
})
public class StockResearchReportController {
    private StockResearchReportService stockResearchReportService;

    public StockResearchReportController(StockResearchReportService stockResearchReportService) {
        this.stockResearchReportService = stockResearchReportService;
    }

    @GetMapping(value = "stockReport")
    @ApiOperation(value = "根据股票代码获取个股研报",notes = "个股研报")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "每页条数", name = "pageSize", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "当前页数", name = "currPage", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string"),
            @ApiImplicitParam(value = "评级类别 \t0-全部 1-买入 2-增持 3-中性 4-减持 5-卖出", name = "mkt", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "评级变动 \t0-全部 1-维持 2-调高 3-调低 4-首次 5-无", name = "stat", paramType = "query", dataType = "string", required = true)
    })
    public Message<List<GGSR>> shareholderResearch(@Param("pageSize") String pageSize,@Param("currPage") String currPage,@Param("code") String code,@Param("mkt") String mkt,@Param("stat") String stat){
       if(code==null||code.isEmpty()){
           code="";
       }else{
           if(!StockCodeUtil.isStockCode(code)){
               return Message.error("股票代码错误");
           }
       }

       return stockResearchReportService.stockResearchReport(pageSize,currPage,code,mkt,stat);
    }
    @GetMapping(value = "industryReport")
    @ApiOperation(value = "根据股票代码获取行业研报",notes = "个股研报")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "每页条数", name = "pageSize", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "当前页数", name = "currPage", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "行业名称 \n" +
                    "\t房地产451 电子信息447 钢铁行业479 机械行业545 煤炭采选437 汽车行业481 水泥建材424 商业百货482 医药制造465 银行475 有色金属478\n" +
                    "\tA.安防设备735\n" +
                    "\tB.包装材料733 玻璃陶瓷546 保险474\n" +
                    "\tC.材料行业537 船舶制造729\n" +
                    "\tD.电力行业428 电子元件459 多元金融738 电信运营736\n" +
                    "\tF.纺织服装436\n" +
                    "\tG.港口水运450 贵金属732 工程建设425 高速公路421 公用事业427 国际贸易484 工艺商品440\n" +
                    "\tH.化工行业538 环保工程728 化纤行业471 化肥行业731 航天航空480\n" +
                    "\tJ.家电行业456 交运物流422 金属制品739 交运设备429\n" +
                    "\tL.旅游酒店485\n" +
                    "\tM.木业家具476\n" +
                    "\tN.农药兽药730 酿酒行业477 农牧饲渔433\n" +
                    "\tQ.券商信托473\n" +
                    "\tR.软件服务737457\n" +
                    "\tS.塑胶制品454 食品饮料438 输配电气457 石油行业464\n" +
                    "\tT.通讯行业448 \n" +
                    "\tW.文教休闲740 文化传媒486 \n" +
                    "\tY.医疗行业727 仪器仪表458 园林工程726 \n" +
                    "\tZ.装修装饰725 珠宝首饰734 造纸印刷470 综合行业539 专用设备910", name = "sc", paramType = "query", dataType = "string"),
            @ApiImplicitParam(value = "评级类别 \t0-全部 1-买入 2-增持 3-中性 4-减持 5-卖出", name = "mkt", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "评级变动 \t0-全部 1-维持 2-调高 3-调低 4-首次 5-无", name = "stat", paramType = "query", dataType = "string", required = true)
    })
    public Message industryResearchReport(String pageSize, String currPage,String sc,String mkt,String stat){
        if(sc==null){
            sc="";
        }
        return stockResearchReportService.industryResearchReport(pageSize,currPage,sc,mkt,stat);
    }
}
