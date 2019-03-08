package cn.beerate.model.bean.tenjqka;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "同花顺行业一览表")
@Data
public class Thshy {

    @ApiModelProperty("序号")
    private String xh;

    @ApiModelProperty("板块")
    private String bk;

    @ApiModelProperty("板块代码")
    private String bk_code;

    @ApiModelProperty("行业涨跌幅")
    private String hyzdf_bfb;

    @ApiModelProperty("总成交量(万手)")
    private String zcjl;

    @ApiModelProperty("总成交额(亿元)")
    private String zcje;

    @ApiModelProperty("净流入(亿元)")
    private String jlr;

    @ApiModelProperty("上涨家数")
    private String szjs;

    @ApiModelProperty("下跌家数")
    private String xdjs;

    @ApiModelProperty("均价")
    private String jj;

    @ApiModelProperty("领涨股名称")
    private String lzg_name;

    @ApiModelProperty("领涨股代码")
    private String lzg_code;

    @ApiModelProperty("最新价")
    private String lzg_zxj;

    @ApiModelProperty("领涨股涨跌幅")
    private String lzg_zdf;

}
