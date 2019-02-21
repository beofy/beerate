/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.bonusfinancing;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Auto-generated: 2019-01-23 13:57:36
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "历年分红融资")
@Data
public class Lnfhrz {
    @ApiModelProperty(value = "时间")
    private String sj;

    @ApiModelProperty(value = "分红总额(万元)")
    private String fhze;

    @ApiModelProperty(value = "增发(万股)")
    private String zf;

    @ApiModelProperty(value = "配股(万股)")
    private String pg;

    @ApiModelProperty(value = "新股发行(万股)")
    private String xgfx;
}