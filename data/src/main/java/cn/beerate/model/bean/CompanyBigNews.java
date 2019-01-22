package cn.beerate.model.bean;

import cn.beerate.model.bean.companybignews.*;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


public class CompanyBigNews {

    @ApiModelProperty(value = "大事提醒")
    public Dstx dstx;

    public List<Dwdb> dwdb;

    public List<Gqzy> gqzy;

    public List<Sszc> sszc;

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
