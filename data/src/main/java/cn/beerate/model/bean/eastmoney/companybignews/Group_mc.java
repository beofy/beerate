/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.companybignews;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Auto-generated: 2019-01-22 17:37:49
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "卖出营业部")
@Data
public class Group_mc {
    @ApiModelProperty(value = "营业部名称")
    private String yybmc;

    @ApiModelProperty(value = "买入金额(元)")
    private String mrje;

    @ApiModelProperty(value = "买入占金额比(%)")
    private String zjeb_mr;

    @ApiModelProperty(value = "卖出金额")
    private String mcje;

    @ApiModelProperty(value = "卖出占金额比(%)")
    private String zjeb_mc;
}