/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.capitaloperation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Auto-generated: 2019-01-24 11:48:31
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "项目进度")
@Data
public class ProjectProgress {
    @ApiModelProperty(value = "项目名称")
    private String xmmc;

    @ApiModelProperty(value = "截止日期")
    private Date jzrq;

    @ApiModelProperty(value = "计划投资(万元)")
    private String jhtz;

    @ApiModelProperty(value = "已投入募集资金(万元)")
    private String ytrmjzj;

    @ApiModelProperty(value = "建设期(年)")
    private String jsq;

    @ApiModelProperty(value = "收益率(税后)")
    private String syl;

    @ApiModelProperty(value = "投资回收期(年)")
    private String tzhsq;
}