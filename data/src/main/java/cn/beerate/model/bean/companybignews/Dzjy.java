/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.companybignews;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Auto-generated: 2019-01-22 17:37:49
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "大宗交易")
@Data
public class Dzjy {
    @ApiModelProperty(value = "交易日期")
    private String jyrq;

    @ApiModelProperty(value = "成交价(元)")
    private String cjj;

    @ApiModelProperty(value = "成交量(股)")
    private String cjl;

    @ApiModelProperty(value = "成交金额(元)")
    private String cjje;

    @ApiModelProperty(value = "买入营业部")
    private String mryyb;

    @ApiModelProperty(value = "卖出营业部")
    private String mcyyb;
}