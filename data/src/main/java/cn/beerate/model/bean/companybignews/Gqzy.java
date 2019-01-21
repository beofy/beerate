package cn.beerate.model.bean.companybignews;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "股权质押")
public class Gqzy {
    @ApiModelProperty(value = "公告名称")
    public String  gdmc;

    @ApiModelProperty(value = "公告日期")
    public String  ggrq;

    @ApiModelProperty(value = " 解押日期")
    public String  jyrq;

    @ApiModelProperty(value = " 占股东持股比例(%)")
    public String  zgdcgbl;

    @ApiModelProperty(value = "质押方")
    public String  zyf;

    @ApiModelProperty(value = " 质押股数(万股)")
    public String  zygs;

    @ApiModelProperty(value = "质押截止日")
    public String  zyjzr;

    @ApiModelProperty(value = "质押起始日")
    public String  zyqsr;

    @ApiModelProperty(value = "是否质押式回购 1-是 2-否")
    public String  zyshg;

    @ApiModelProperty(value = " 占总股本比例(%))")
    public String  zzgbbl;
    
}
