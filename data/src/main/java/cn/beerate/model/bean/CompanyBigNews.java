package cn.beerate.model.bean;

import cn.beerate.model.bean.companybignews.*;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


public class CompanyBigNews {

    @ApiModelProperty(value = "大事提醒")
    public Dstx dstx;

    //@ApiModelProperty(value = "对外担保")
    public List<Dwdb> dwdb;

    //@ApiModelProperty(value = "股权质押")
    public List<Gqzy> gqzy;

    //@ApiModelProperty(value = "诉讼仲裁")
    public List<Sszc> sszc;

    //@ApiModelProperty(value = "违规处理")
    public List<Wgcl> wgcl;

    @ApiModelProperty(value = "大宗交易")
    public String dzjy;

    @ApiModelProperty(value = "高管持股变动")
    public String ggcgbd;

    @ApiModelProperty(value = "龙虎榜单")
    public String lhbd;

    @ApiModelProperty(value = "融资融券")
    public String  rzrq;

    @ApiModelProperty(value = "十大股东持股变动")
    public String  sdgdcgbd;

    @ApiModelProperty(value = "限售解禁")
    public String  xsjj;
}
