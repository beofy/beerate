/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.f10.companymanagement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Auto-generated: 2019-01-24 11:1:15
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "高管持股变动")
@Data
public class RptShareHeldChangeList {
    @ApiModelProperty(value = "日期")
    private String rq;

    @ApiModelProperty(value = "变动人")
    private String bdr;

    @ApiModelProperty(value = "变动数量(股")
    private String bdsl;

    @ApiModelProperty(value = "结存股票(股)")
    private String jcgp;

    @ApiModelProperty(value = "交易均价(元)")
    private String jjjj;

    @ApiModelProperty(value = "董监高管")
    private String djgg;

    @ApiModelProperty(value = "与高管关系")
    private String ygggx;

    @ApiModelProperty(value = "股份变动途径")
    private String gfbdtj;
}