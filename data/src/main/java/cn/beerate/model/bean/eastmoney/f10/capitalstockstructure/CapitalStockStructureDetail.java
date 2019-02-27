/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.f10.capitalstockstructure;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Auto-generated: 2019-01-23 17:32:21
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "股本结构详情")
@Data
public class CapitalStockStructureDetail {
    @ApiModelProperty(value = "未流通股份")
    private String wltgf;

    @ApiModelProperty(value = "未流通股份占比")
    private String wltgfzb;

    @ApiModelProperty(value = "流通受限股份")
    private String ltsxgf;

    @ApiModelProperty(value = "流通受限股份占比")
    private String ltsxgfzb;

    @ApiModelProperty(value = "已流通股份")
    private String yltgf;

    @ApiModelProperty(value = "已流通股份占比")
    private String yltgfzb;

    @ApiModelProperty(value = "总股本")
    private String zgb;

    @ApiModelProperty(value = "总股本占比")
    private String zgbzb;

    @ApiModelProperty(value = "已上市流通A股")
    private String yssltag;

    @ApiModelProperty(value = "已上市流通A股占比")
    private String yssltagzb;

    @ApiModelProperty(value = "已上市流通B股")
    private String yssltbg;

    @ApiModelProperty(value = "已上市流通B股占比")
    private String yssltbgzb;

    @ApiModelProperty(value = "境外上市流通股")
    private String jwssltg;

    @ApiModelProperty(value = "境外上市流通股占比")
    private String jwssltgzb;

    @ApiModelProperty(value = "其他已流通股份")
    private String qtyltgf;

    @ApiModelProperty(value = "其他已流通股份占比")
    private String qtyltgfzb;

    @ApiModelProperty(value = "流通股份合计")
    private String ltgfhf;

    @ApiModelProperty(value = "流通股份合计占比")
    private String ltgfhfzb;
}