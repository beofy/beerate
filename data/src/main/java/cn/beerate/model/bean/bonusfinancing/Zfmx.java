/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.bonusfinancing;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Auto-generated: 2019-01-23 13:57:36
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "增发明细")
@Data
public class Zfmx {
    @ApiModelProperty(value = "增发时间")
    private String zfsj;

    @ApiModelProperty(value = "实际增发数量(万股)")
    private String sjzfsl;

    @ApiModelProperty(value = "实际募集净额(万元)")
    private String sjmjje;

    @ApiModelProperty(value = "增发价格(元/股)")
    private String zfjg;

    @ApiModelProperty(value = "发行方式")
    private String fxfs;

    @ApiModelProperty(value = "股权登记日")
    private String gqdjr;

    @ApiModelProperty(value = "增发上市日")
    private String zfssr;

    @ApiModelProperty(value = "资金到账日")
    private String zjdzr;
}