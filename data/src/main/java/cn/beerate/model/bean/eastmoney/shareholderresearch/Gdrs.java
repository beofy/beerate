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
@ApiModel(description = "股东人数")
@Data
public class Gdrs {
    @ApiModelProperty("日期")
    private String rq;

    @ApiModelProperty("股东人数(户)")
    private String gdrs;

    @ApiModelProperty("股东人数_较上期变化(%)")
    private String gdrs_jsqbh;

    @ApiModelProperty("人均流通股(股)")
    private String rjltg;

    @ApiModelProperty("人均流通股(股)_较上期变化(%)")
    private String rjltg_jsqbh;

    @ApiModelProperty("筹码集中度")
    private String cmjzd;

    @ApiModelProperty("股价(元)")
    private String gj;

    @ApiModelProperty("人均持股金额(元)")
    private String rjcgje;

    @ApiModelProperty("前十大股东持股合计(%)")
    private String qsdgdcghj;

    @ApiModelProperty("前十大流通股东持股合计(%)")
    private String qsdltgdcghj;
}