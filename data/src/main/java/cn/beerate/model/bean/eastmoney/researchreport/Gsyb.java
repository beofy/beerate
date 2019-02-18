/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.researchreport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Auto-generated: 2019-01-23 17:3:41
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "公司研报")
@Data
public class Gsyb {
    @ApiModelProperty(value = "等级")
    private String grade;

    @ApiModelProperty(value = "时间")
    private String date;

    @ApiModelProperty(value = "链接地址：/report/{date}/{linkid}.html")
    private String linkid;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;
}