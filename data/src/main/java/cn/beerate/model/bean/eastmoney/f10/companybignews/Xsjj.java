/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.f10.companybignews;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Auto-generated: 2019-01-22 17:37:49
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "限售解禁")
@Data
public class Xsjj {

    @ApiModelProperty(value = "解禁时间")
    private String jjsj;

    @ApiModelProperty(value = "解禁数量(股)")
    private String jjsl;

    @ApiModelProperty(value = "解禁股占总股本比例")
    private String jjgzzgbbl;

    @ApiModelProperty(value = "解禁股占流通股本比例")
    private String jjgzltgbbl;

    @ApiModelProperty(value = "股票类型")
    private String gplx;
}