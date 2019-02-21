/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.companysurvey;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Auto-generated: 2019-01-24 11:17:10
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "发行相关")
@Data
public class Fxxg {
    @ApiModelProperty(value = "成立日期")
    private String clrq;

    @ApiModelProperty(value = "上市日期")
    private String ssrq;
    
    @ApiModelProperty(value = "发行市盈率(倍)")
    private String fxsyl;
    
    @ApiModelProperty(value = "网上发行日期")
    private String wsfxrq;
    
    @ApiModelProperty(value = "发行方式")
    private String fxfs;
    
    @ApiModelProperty(value = "每股面值(元)")
    private String mgmz;
    
    @ApiModelProperty(value = "发行量(股)")
    private String fxl;
    
    @ApiModelProperty(value = "每股发行价(元)")
    private String mgfxj;
    
    @ApiModelProperty(value = "发行费用(元)")
    private String fxfy;
    
    @ApiModelProperty(value = "发行总市值(元)")
    private String fxzsz;
    
    @ApiModelProperty(value = "募集资金净额(元)")
    private String mjzjje;
    
    @ApiModelProperty(value = "首日开盘价(元)")
    private String srkpj;
    
    @ApiModelProperty(value = "首日收盘价(元)")
    private String srspj;
    
    @ApiModelProperty(value = "首日换手率")
    private String srhsl;
    
    @ApiModelProperty(value = "首日最高价(元)")
    private String srzgj;
    
    @ApiModelProperty(value = "网下配售中签率")
    private String wxpszql;
    
    @ApiModelProperty(value = "定价中签率")
    private String djzql;
}