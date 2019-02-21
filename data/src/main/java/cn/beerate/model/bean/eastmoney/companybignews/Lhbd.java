/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.companybignews;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2019-01-22 17:37:49
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "龙虎榜单")
@Data
public class Lhbd {
    private List<Group_mr> group_mr;

    private List<Group_mc> group_mc;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "日期")
    private String rq;

    @ApiModelProperty(value = "总量")
    private String zl;

    @ApiModelProperty(value = "买入总计")
    private String mrzj;

    @ApiModelProperty(value = "卖入总计占金额比")
    private String mrzjzjeb;

    @ApiModelProperty(value = "卖出总计")
    private String mczj;

    @ApiModelProperty(value = "卖出总计占金额比")
    private String mczjzjeb;
}