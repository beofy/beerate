package cn.beerate.model.bean.tenjqka;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "行业详情")
@Data
public class DetailThshy {

    @ApiModelProperty("序号")
    private String xh;

    @ApiModelProperty("代码")
    private String dm;

    @ApiModelProperty("名称")
    private String mc;

    @ApiModelProperty("现价")
    private String xj;

    @ApiModelProperty("涨跌幅(%)")
    private String zdf;

    @ApiModelProperty("涨跌")
    private String zd;

    @ApiModelProperty("涨速(%)")
    private String zs;

    @ApiModelProperty("换手(%)")
    private String hs;

    @ApiModelProperty("量比")
    private String lb;

    @ApiModelProperty("振幅(%)")
    private String zf;

    @ApiModelProperty("成交额")
    private String cje;

    @ApiModelProperty("流通股")
    private String ltg;

    @ApiModelProperty("流通市值")
    private String ltsz;

    @ApiModelProperty("市盈率")
    private String syl;
}
