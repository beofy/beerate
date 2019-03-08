package cn.beerate.model.bean.eastmoney.f10.newfinanceanalysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "杜邦分析")
@NoArgsConstructor
@Data
public class Dubang {

    @ApiModelProperty("日期")
    private String date;

    @ApiModelProperty("净资产收益率")
    private String jzcsyl;

    @ApiModelProperty("总资产净利率")
    private String zzcjll;

    @ApiModelProperty("归属母公司股东净利润")
    private String gsmgsgddjlr;

    @ApiModelProperty("权益乘数")
    private String qycs;

    @ApiModelProperty("营业净利润率")
    private String yyjlrl;

    @ApiModelProperty("总资产周转率")
    private String zzczzl;

    @ApiModelProperty("资产负债率")
    private String zcfzl;

    @ApiModelProperty("净利润")
    private String jlr;

    @ApiModelProperty("营业收入")
    private String yysr;

    @ApiModelProperty("资产总额")
    private String zcze;

    @ApiModelProperty("负债总额")
    private String fzze;

    @ApiModelProperty("收入总额")
    private String srze;

    @ApiModelProperty("成本总额")
    private String cbze;

    @ApiModelProperty("流动资产")
    private String ldzc;

    @ApiModelProperty("非流动资产")
    private String fldzc;

    @ApiModelProperty("营业成本")
    private String yycb;

    @ApiModelProperty("期间费用")
    private String qjfy;

    @ApiModelProperty("货币资金")
    private String hbzj;

    @ApiModelProperty("可供出售金融资产")
    private String kgcsjrzc;

    @ApiModelProperty("无形资产")
    private String wxzc;

    @ApiModelProperty("公允价值变动收益")
    private String gyjzbdsy;

    @ApiModelProperty("营业税金及附加")
    private String yysjjfj;

    @ApiModelProperty("交易性金融资产")
    private String jyxjrzc;

    @ApiModelProperty("持有至到期投资")
    private String cyzdqtz;

    @ApiModelProperty("开发支出")
    private String kfzc;

    @ApiModelProperty("营业外收入")
    private String yywsr;

    @ApiModelProperty("所得税费用")
    private String sdsfy;

    @ApiModelProperty("财务费用")
    private String cwfy;

    @ApiModelProperty("应收占款")
    private String yszk;

    @ApiModelProperty("长期股权投")
    private String cqgqtz;

    @ApiModelProperty("商誉")
    private String sy;

    @ApiModelProperty("投资收益")
    private String tzsy;

    @ApiModelProperty("资产减值损失")
    private String zcjzss;

    @ApiModelProperty("销售费用")
    private String xsfy;

    @ApiModelProperty("预付账款")
    private String yfzk;

    @ApiModelProperty("投资性房地产")
    private String tzxfdc;

    @ApiModelProperty("长期待摊费用")
    private String cqdtfy;

    @ApiModelProperty("营业外支出")
    private String yywzc;

    @ApiModelProperty("管理费用")
    private String glfy;

    @ApiModelProperty("其他应收款")
    private String qtysk;

    @ApiModelProperty("固定资产")
    private String gdzc;

    @ApiModelProperty("递延所得税资产")
    private String dysdszc;

    @ApiModelProperty("存货")
    private String ch;

    @ApiModelProperty("在建工程")
    private String zjgc;

    @ApiModelProperty("其他非流动性资产")
    private String qtfldzc;

    @ApiModelProperty("其他流行性资产")
    private String qtldzc;

}
