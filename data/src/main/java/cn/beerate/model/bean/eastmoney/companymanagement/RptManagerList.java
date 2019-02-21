/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.companymanagement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Auto-generated: 2019-01-24 11:1:15
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "高管列表")
@Data
public class RptManagerList {
    @ApiModelProperty(value = "姓名")
    private String xm;

    @ApiModelProperty(value = "性别")
    private String xb;

    @ApiModelProperty(value = "年龄")
    private String nl;

    @ApiModelProperty(value = "学历")
    private String xl;

    @ApiModelProperty(value = "职务")
    private String zw;

    @ApiModelProperty(value = "任职时间")
    private String rzsj;

    @ApiModelProperty(value = "简介")
    private String jj;
}