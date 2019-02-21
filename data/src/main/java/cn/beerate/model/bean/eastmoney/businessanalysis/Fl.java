package cn.beerate.model.bean.eastmoney.businessanalysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "分类")
@NoArgsConstructor
@Data
public class Fl {
    @ApiModelProperty("日期")
    private String rq;

    @ApiModelProperty("主营构成")
    private String zygc;

    @ApiModelProperty("主营收入(元)")
    private String zysr;

    @ApiModelProperty("收入比例")
    private String srbl;

    @ApiModelProperty("主营成本(元)")
    private String zycb;

    @ApiModelProperty("成本比例")
    private String cbbl;

    @ApiModelProperty("主营利润(元)")
    private String zylr;

    @ApiModelProperty("利润比例")
    private String lrbl;

    @ApiModelProperty("毛利率(%)")
    private String mll;

    @ApiModelProperty("单位")
    private String dw;

    @ApiModelProperty("")
    private String orderby;
}
