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
@ApiModel(description = "违规处理")
@Data
public class Wgcl {
    @ApiModelProperty(value = "公告日期")
    private String ggrq;

    @ApiModelProperty(value = "类型")
    private String lx;

    @ApiModelProperty(value = "处罚对象")
    private String cfdx;

    @ApiModelProperty(value = "违规行为")
    private String wgxw;

    @ApiModelProperty(value = "处分类型")
    private String cflx;

    @ApiModelProperty(value = "处分措施")
    private String cfcs;

    @ApiModelProperty(value = "处理人")
    private String clr;

    @ApiModelProperty(value = "处罚金额(万元)")
    private String cfje;
}