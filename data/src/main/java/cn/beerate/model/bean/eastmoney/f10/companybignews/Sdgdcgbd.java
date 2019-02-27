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
@ApiModel(description = "十大股东持股变动")
@Data
public class Sdgdcgbd {
    @ApiModelProperty(value = "截止时间")
    private String bdsj;

    @ApiModelProperty(value = "名次")
    private String mc;

    @ApiModelProperty(value = "股东名称")
    private String gdmc;

    @ApiModelProperty(value = "股份类型")
    private String gflx;

    @ApiModelProperty(value = "持股数(股)")
    private String cgs;

    @ApiModelProperty(value = "占总股本持股比例")
    private String zzgbcgbl;

    @ApiModelProperty(value = "增减(股")
    private String cj;

    @ApiModelProperty(value = "增减股占原股东持股比例")
    private String cjgzygdcgbl;

    @ApiModelProperty(value = "变动原因")
    private String bdyy;

}