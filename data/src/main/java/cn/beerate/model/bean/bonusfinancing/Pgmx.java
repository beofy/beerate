/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.bonusfinancing;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Auto-generated: 2019-01-23 13:57:36
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "配股明细")
@Data
public class Pgmx {
    @ApiModelProperty(value = "配股公告日")
    private String pgggr;

    @ApiModelProperty(value = "配股价格(元)")
    private String pgjg;

    @ApiModelProperty(value = "实际配股数量(万元)")
    private String sjpgsl;

    @ApiModelProperty(value = "实际募资总额(万元)")
    private String sjmjze;

    @ApiModelProperty(value = "股权登记日")
    private String gqdjr;

    @ApiModelProperty(value = "除权基准日")
    private String cqjzr;

    @ApiModelProperty(value = "配股方案")
    private String pgfa;
}