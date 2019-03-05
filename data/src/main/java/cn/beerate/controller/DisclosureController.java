package cn.beerate.controller;

import cn.beerate.common.Message;
import cn.beerate.common.util.StockCodeUtil;
import cn.beerate.model.bean.cninfo.AnnouncementsBean;
import cn.beerate.service.cninfo.DisclosureService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "巨潮资讯")
@RestController
@ApiResponses({
        @ApiResponse(code = Message.Code.SUCCESS,message = "success"),
        @ApiResponse(code = Message.Code.ERROR,message = "error"),
})
public class DisclosureController {

    @Autowired
    private DisclosureService disclosureService;

    @GetMapping(value = "getAnnouncements")
    @ApiOperation(value = "根据股票代码公司公告", notes = "公司公告")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "股票代码", name = "code", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "当前页", name = "currPage", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "每页条数 默认30条", name = "pageSize", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "查询条件 \n" +
                    "年报 - category_ndbg_szsh \n" +
                    "半年报 - category_bndbg_szsh \n" +
                    "一季报 - category_yjdbg_szsh \n" +
                    "三季报 - category_sjdbg_szsh \n" +
                    "业绩预告 - category_yjygjxz_szsh \n" +
                    "权益分派 - category_qyfpxzcs_szsh \n" +
                    "董事会 - category_dshgg_szsh \n" +
                    "监事会 - category_jshgg_szsh \n" +
                    "股东大会 - category_gddh_szsh \n" +
                    "日常经营 - category_rcjy_szsh \n" +
                    "公司治理 - category_gszl_szsh \n" +
                    "中介报告 - category_zj_szsh \n" +
                    "首发 - category_sf_szsh \n" +
                    "增发 - category_zf_szsh \n" +
                    "股权激励 - category_gqjl_szsh \n" +
                    "配股 - category_pg_szsh \n" +
                    "解禁 - category_jj_szsh \n" +
                    "债券 - category_zq_szsh \n" +
                    "其他融资 - category_qtrz_szsh \n" +
                    "股权变动 - category_gqbd_szsh \n" +
                    "补充更正 - category_bcgz_szsh \n" +
                    "澄清致歉 - category_cqdq_szsh \n" +
                    "风险提示 - category_fxts_szsh \n" +
                    "特别处理和退市 - category_tbclts_szsh " +
                    "使用：多字段中间用;分割", name = "searchkey", paramType = "query", dataType = "string"),
            @ApiImplicitParam(value = "开始时间 最早:2000-01-01", name = "beginDate", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(value = "结束时间", name = "endDate", paramType = "query", dataType = "string", required = true),
    })
    public Message<AnnouncementsBean> getAnnouncementsBean(@Param("code") String code,
                                                           @Param("currPage") int currPage,
                                                           @Param("pageSize") int pageSize,
                                                           @Param("searchkey") String searchkey,
                                                           @Param("beginDate") String beginDate,
                                                           @Param("endDate") String endDate){
        //参数校验
        if(!StockCodeUtil.isStockCode(code)){
           return Message.error("股票代码错误");
        }

        if(null==searchkey){
            searchkey="";
        }

        if(currPage<=0){
            currPage=1;
        }

        if (pageSize<=0){
            currPage=30;
        }

        AnnouncementsBean announcementsBean = disclosureService.getFirstAnnouncementsBean(code,currPage,pageSize,searchkey,beginDate,endDate);

        return Message.success(announcementsBean);
    }

}
