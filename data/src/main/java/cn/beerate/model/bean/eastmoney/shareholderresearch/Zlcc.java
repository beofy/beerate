/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.shareholderresearch;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Auto-generated: 2019-01-24 14:51:13
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "机构持仓")
@Data
public class Zlcc {
    @ApiModelProperty(value = "日期")
    private String rq;

    @ApiModelProperty(value = "机构类型")
    private String jglx;

    @ApiModelProperty(value = "持仓家数")
    private String ccjs;

    @ApiModelProperty(value = "持仓股数(股)")
    private String ccgs;

    @ApiModelProperty(value = "占流通股比例")
    private String zltgbl;

    @ApiModelProperty(value = "占总股本比例")
    private String zltgbbl;
}