package cn.beerate.model.bean.companybignews;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "对外担保")
public class Dwdb {
    @ApiModelProperty(value = "被担保方")
    public String bdbf;

    @ApiModelProperty(value = "报告期")
    public String  bgq;

    @ApiModelProperty(value = "报告期类别")
    public String  bgqlb;

    @ApiModelProperty(value = "币种")
    public String bz;

    @ApiModelProperty(value = "担保方")
    public String dbf;

    @ApiModelProperty(value = "担保方式")
    public String  dbfs;

    @ApiModelProperty(value = "担保金额(万元)")
    public String  dbje;

    @ApiModelProperty(value = "担保起始日")
    public String  dbqsr;

    @ApiModelProperty(value = "担保期限(年)")
    public String  dbqx;

    @ApiModelProperty(value = "担保事件说明")
    public String dbsjsm;

    @ApiModelProperty(value = "担保终止日")
    public String dbzzr;

    @ApiModelProperty(value = "公告日期")
    public String ggrq;

    @ApiModelProperty(value = "交易日期")
    public String jyrq;

    @ApiModelProperty(value = "是否关联交易")
    public String  sfgljy;

    @ApiModelProperty(value = "是否履行完毕")
    public String  sflxwb;

}
