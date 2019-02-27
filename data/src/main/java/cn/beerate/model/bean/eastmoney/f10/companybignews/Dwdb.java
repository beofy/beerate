/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.f10.companybignews;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Auto-generated: 2019-01-22 17:37:49
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "对外担保")
@Data
public class Dwdb {
    @ApiModelProperty(value = "公告日期")
    private String ggrq;

    @ApiModelProperty(value = "担保方")
    private String dbf;

    @ApiModelProperty(value = "被担保方")
    private String bdbf;

    @ApiModelProperty(value = "担保方式")
    private String dbfs;

    @ApiModelProperty(value = "担保金额(万元)")
    private String dbje;

    @ApiModelProperty(value = "币种")
    private String bz;

    @ApiModelProperty(value = "担保期限(年)")
    private String dbqx;

    @ApiModelProperty(value = "担保起始日")
    private String dbqsr;

    @ApiModelProperty(value = "担保终止日")
    private String dbzzr;

    @ApiModelProperty(value = "是否履行完毕")
    private String sflxwb;

    @ApiModelProperty(value = "是否关联交易")
    private String sfgljy;

    @ApiModelProperty(value = "交易日期")
    private String jyrq;

    @ApiModelProperty(value = "担保事件说明")
    private String dbsjsm;

    @ApiModelProperty(value = "报告期")
    private String bgq;

    @ApiModelProperty(value = "报告期类别")
    private String bgqlb;
}