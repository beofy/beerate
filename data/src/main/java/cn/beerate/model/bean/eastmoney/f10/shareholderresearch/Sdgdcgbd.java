/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.f10.shareholderresearch;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Auto-generated: 2019-01-24 14:51:13
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "十大股东持股变动")
@Data
public class Sdgdcgbd {

    @ApiModelProperty("变动时间")
    private String bdsj;

    @ApiModelProperty("名次")
    private String mc;

    @ApiModelProperty("股东名称")
    private String gdmc;

    @ApiModelProperty("股份类型")
    private String gflx;

    @ApiModelProperty("持股数(股)")
    private String cgs;

    @ApiModelProperty("占总股本持股比例")
    private String zzgbcgbl;

    @ApiModelProperty("增减(股)")
    private String cj;

    @ApiModelProperty("增减股占原股东持股比例")
    private String cjgzygdcgbl;

    @ApiModelProperty("变动原因")
    private String bdyy;

}