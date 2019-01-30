/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.shareholderresearch;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Auto-generated: 2019-01-24 14:51:13
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "实际控制人")
@Data
public class Kggx {
    @ApiModelProperty(value = "实际控制人")
    private String sjkzr;

    @ApiModelProperty(value = "持股比例")
    private String cgbl;
}