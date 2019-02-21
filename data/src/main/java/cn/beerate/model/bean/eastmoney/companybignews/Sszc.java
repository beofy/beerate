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
@ApiModel(description = "诉讼仲裁")
@Data
public class Sszc {
    @ApiModelProperty(value = "公告日期")
    private String ggrq;

    @ApiModelProperty(value = "案件名称")
    private String ajmc;

    @ApiModelProperty(value = "案件简介")
    private String ajjj;

    @ApiModelProperty(value = "原告方")
    private String ygf;

    @ApiModelProperty(value = "被告方")
    private String bgf;

    @ApiModelProperty(value = "诉讼类型")
    private String sslx;

    @ApiModelProperty(value = "涉案金额(万元)")
    private String saje;

    @ApiModelProperty(value = "币种")
    private String bz;

    @ApiModelProperty(value = "一审_起诉日期")
    private String ysqsrq;

    @ApiModelProperty(value = "一审_受理法院")
    private String ysslfy;

    @ApiModelProperty(value = "一审_判决日期")
    private String yspjrq;

    @ApiModelProperty(value = "一审_判决内容")
    private String yspjnr;

    @ApiModelProperty(value = "一审_是否上诉")
    private String yssfss;

    @ApiModelProperty(value = "二审_上诉方")
    private String esssf;

    @ApiModelProperty(value = "二审_受理法院")
    private String esslfy;

    @ApiModelProperty(value = "二审_判决日期")
    private String espjrq;

    @ApiModelProperty(value = "一审_判决内容")
    private String espjnr;

    @ApiModelProperty(value = "执行情况")
    private String zxqk;
}