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
@ApiModel(description = "分红影响")
@Data
public class Fhyx {
    @ApiModelProperty(value = "公告日期")
    private String ggrq;

    @ApiModelProperty(value = "分红方案")
    private String fhfa;

    @ApiModelProperty(value = "股权登记日")
    private String gqdjr;

    @ApiModelProperty(value = "除权除息日")
    private String cqcxr;

    @ApiModelProperty(value = "派息日")
    private String pxr;

    @ApiModelProperty(value = "方案进度")
    private String fajd;
}