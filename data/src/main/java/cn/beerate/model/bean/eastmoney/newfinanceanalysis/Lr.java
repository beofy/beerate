package cn.beerate.model.bean.eastmoney.newfinanceanalysis;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Lr {
    @ApiModelProperty("日期")
    private String yysr;

    @ApiModelProperty("营业成本")
    private String yycb;

    @ApiModelProperty("营业成本占比")
    private String yycbzb;

    @ApiModelProperty("营业税金及附加")
    private String yysjjfj;

    @ApiModelProperty("营业税金及附加占比")
    private String yysjjfjzb;

    @ApiModelProperty("期间费用")
    private String qjfy;

    @ApiModelProperty("期间费用占比")
    private String qjfyzb;

    @ApiModelProperty("销售费用")
    private String xsfy;

    @ApiModelProperty("销售费用占比")
    private String xsfyzb;

    @ApiModelProperty("管理费用")
    private String glfy;

    @ApiModelProperty("管理费用占比")
    private String glfyzb;

    @ApiModelProperty("财务费用")
    private String cwfy;

    @ApiModelProperty("财务费用占比")
    private String cwfyzb;

    @ApiModelProperty("资产减值损失")
    private String zcjzss;

    @ApiModelProperty("资产减值损失占比")
    private String zcjzsszb;

    @ApiModelProperty("其他经营收益")
    private String qtjysy;

    @ApiModelProperty("其他经营收益占比")
    private String qtjysyzb;

    @ApiModelProperty("公允价值变动损益")
    private String gyjzbdsy;

    @ApiModelProperty("公允价值变动损益占比")
    private String gyjzbdsyzb;

    @ApiModelProperty("投资收益")
    private String tzsy;

    @ApiModelProperty("投资收益占比")
    private String tzsyzb;

    @ApiModelProperty("营业利润")
    private String yylr;

    @ApiModelProperty("营业利润占比")
    private String yylrzb;

    @ApiModelProperty("营业外收入")
    private String yywsr;

    @ApiModelProperty("营业外收入占比")
    private String yywsrzb;

    @ApiModelProperty("补贴收入")
    private String btsr;

    @ApiModelProperty("补贴收入占比")
    private String btsrzb;

    @ApiModelProperty("营业外支出")
    private String yywzc;

    @ApiModelProperty("营业外支出占比")
    private String yywzczb;

    @ApiModelProperty("利润总额")
    private String lrze;

    @ApiModelProperty("利润总额占比")
    private String lrzezb;

    @ApiModelProperty("所得税")
    private String sds;

    @ApiModelProperty("所得税占比")
    private String sdszb;

    @ApiModelProperty("净利润")
    private String jlr;

    @ApiModelProperty("净利润占比")
    private String jlrzb;
}
