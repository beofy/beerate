/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.f10.capitaloperation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Auto-generated: 2019-01-24 11:48:31
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "募集资金来源")
@Data
public class CapitalFrom {
    @ApiModelProperty(value = "公告日期")
    private String ggrq;

    @ApiModelProperty(value = "发行类别")
    private String fxlb;

    @ApiModelProperty(value = "实际募集资金净额(万元)")
    private String sjmjzjje;

    @ApiModelProperty(value = "发行起始日")
    private String fxqsr;

    @ApiModelProperty(value = "证券名称")
    private String zqmc;

    @ApiModelProperty(value = "证券类别")
    private String zqlb;
}