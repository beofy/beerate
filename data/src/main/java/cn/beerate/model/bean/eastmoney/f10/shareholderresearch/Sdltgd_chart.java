/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.f10.shareholderresearch;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Auto-generated: 2019-01-24 14:51:13
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "流通股东占比详情")
@Data
public class Sdltgd_chart {

    @ApiModelProperty("日期")
    private String rq;

    @ApiModelProperty("十大流通股东持股")
    private String sdltgdcg;

    @ApiModelProperty("流通受限股份")
    private String ltsxgf;

    @ApiModelProperty("其余流通股份")
    private String qyltgf;

}