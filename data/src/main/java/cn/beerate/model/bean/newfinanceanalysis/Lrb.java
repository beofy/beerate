package cn.beerate.model.bean.newfinanceanalysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

@ApiModel(description = "利润表")
@NoArgsConstructor
public class Lrb {

    @ApiModelProperty("股票代码")
    public String SECURITYCODE;

    @ApiModelProperty("报告类型")
    public String REPORTTYPE;

    @ApiModelProperty("类型")
    public String TYPE;

    @ApiModelProperty("报告日期")
    public String REPORTDATE;

    @ApiModelProperty("币种")
    public String CURRENCY;

    @ApiModelProperty("营业收入")
    public String OPERATEREVE;

    @ApiModelProperty("利息净收入")
    public String INTNREVE;

    @ApiModelProperty("其中:利息收入")
    public String INTREVE;

    @ApiModelProperty("利息支出")
    public String INTEXP;

    @ApiModelProperty("手续费及佣金净收入")
    public String COMMNREVE;

    @ApiModelProperty("其中:手续费及佣金收入")
    public String COMMREVE;

    @ApiModelProperty("手续费及佣金支出")
    public String COMMEXP;

    @ApiModelProperty("加:投资收益")
    public String INVESTINCOME;

    @ApiModelProperty("其中:对联营企业和合营企业的投资收益")
    public String INVESTJOINTINCOME;

    @ApiModelProperty("公允价值变动收益")
    public String FVALUEINCOME;

    @ApiModelProperty("汇兑收益")
    public String EXCHANGEINCOME;

    @ApiModelProperty("其他业务收入")
    public String OTHERREVE;

    @ApiModelProperty("营业支出")
    public String OPERATEEXP;

    @ApiModelProperty("营业税金及附加")
    public String OPERATETAX;

    @ApiModelProperty("业务及管理费")
    public String OPERATEMANAGEEXP;

    @ApiModelProperty("资产减值损失")
    public String ASSETDEVALUELOSS;

    @ApiModelProperty("其他业务成本")
    public String OTHEREXP;

    @ApiModelProperty("营业利润")
    public String OPERATEPROFIT;

    @ApiModelProperty("加:营业外收入")
    public String NONOPERATEREVE;

    @ApiModelProperty("减:营业外支出")
    public String NONOPERATEEXP;

    @ApiModelProperty("利润总额")
    public String SUMPROFIT;

    @ApiModelProperty("减:所得税费用")
    public String INCOMETAX;

    @ApiModelProperty("净利润")
    public String NETPROFIT;

    @ApiModelProperty("其中:归属于母公司股东的净利润")
    public String PARENTNETPROFIT;

    @ApiModelProperty("少数股东损益")
    public String MINORITYINCOME;

    @ApiModelProperty("扣除非经常性损益后的净利润")
    public String KCFJCXSYJLR;

    @ApiModelProperty("稀释每股收益")
    public String DILUTEDEPS;

    @ApiModelProperty("基本每股收益")
    public String BASICEPS;

    @ApiModelProperty("其他综合收益")
    public String OTHERCINCOME;

    @ApiModelProperty("归属于母公司股东的其他综合收益")
    public String PARENTOTHERCINCOME;

    @ApiModelProperty("归属于少数股东的其他综合收益")
    public String MINORITYOTHERCINCOME;

    @ApiModelProperty("综合收益总额")
    public String SUMCINCOME;

    @ApiModelProperty("归属于母公司股东的综合收益总额")
    public String PARENTCINCOME;

    @ApiModelProperty("归属于少数股东的综合收益总额")
    public String MINORITYCINCOME;


    @ApiModelProperty("营业收入")
    public String OPERATEREVE_YOY;

    @ApiModelProperty("利息净收入")
    public String INTNREVE_YOY;

    @ApiModelProperty("其中:利息收入")
    public String INTREVE_YOY;

    @ApiModelProperty("利息支出")
    public String INTEXP_YOY;

    @ApiModelProperty("手续费及佣金净收入")
    public String COMMNREVE_YOY;

    @ApiModelProperty("其中:手续费及佣金收入")
    public String COMMREVE_YOY;

    @ApiModelProperty("手续费及佣金支出")
    public String COMMEXP_YOY;

    @ApiModelProperty("加:投资收益")
    public String INVESTINCOME_YOY;

    @ApiModelProperty("其中:对联营企业和合营企业的投资收益")
    public String INVESTJOINTINCOME_YOY;

    @ApiModelProperty("公允价值变动收益")
    public String FVALUEINCOME_YOY;

    @ApiModelProperty("汇兑收益")
    public String EXCHANGEINCOME_YOY;

    @ApiModelProperty("其他业务收入")
    public String OTHERREVE_YOY;

    @ApiModelProperty("营业支出")
    public String OPERATEEXP_YOY;

    @ApiModelProperty("营业税金及附加")
    public String OPERATETAX_YOY;

    @ApiModelProperty("业务及管理费")
    public String OPERATEMANAGEEXP_YOY;

    @ApiModelProperty("资产减值损失")
    public String ASSETDEVALUELOSS_YOY;

    @ApiModelProperty("其他业务成本")
    public String OTHEREXP_YOY;

    @ApiModelProperty("营业利润")
    public String OPERATEPROFIT_YOY;

    @ApiModelProperty("加:营业外收入")
    public String NONOPERATEREVE_YOY;

    @ApiModelProperty("减:营业外支出")
    public String NONOPERATEEXP_YOY;

    @ApiModelProperty("利润总额")
    public String SUMPROFIT_YOY;

    @ApiModelProperty("减:所得税费用")
    public String INCOMETAX_YOY;

    @ApiModelProperty("净利润")
    public String NETPROFIT_YOY;

    @ApiModelProperty("其中:归属于母公司股东的净利润")
    public String PARENTNETPROFIT_YOY;

    @ApiModelProperty("少数股东损益")
    public String MINORITYINCOME_YOY;

    @ApiModelProperty("扣除非经常性损益后的净利润")
    public String KCFJCXSYJLR_YOY;

    @ApiModelProperty("稀释每股收益")
    public String DILUTEDEPS_YOY;

    @ApiModelProperty("基本每股收益")
    public String BASICEPS_YOY;

    @ApiModelProperty("其他综合收益")
    public String OTHERCINCOME_YOY;

    @ApiModelProperty("归属于母公司股东的其他综合收益")
    public String PARENTOTHERCINCOME_YOY;

    @ApiModelProperty("归属于少数股东的其他综合收益")
    public String MINORITYOTHERCINCOME_YOY;

    @ApiModelProperty("综合收益总额")
    public String SUMCINCOME_YOY;

    @ApiModelProperty("归属于母公司股东的综合收益总额")
    public String PARENTCINCOME_YOY;

    @ApiModelProperty("归属于少数股东的综合收益总额")
    public String MINORITYCINCOME_YOY;

}
