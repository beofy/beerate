package cn.beerate.model.bean.eastmoney.newfinanceanalysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

@ApiModel(description = "现金流量表")
@NoArgsConstructor
public class Xjllb {

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

    @ApiModelProperty("客户存款和同业及其他金融机构存放款项净增加额")
    public String NIDEPOSIT;

    @ApiModelProperty("其中:客户存款净增加额")
    public String NICLIENTDEPOSIT;

    @ApiModelProperty("同业及其他金融机构存放款项净增加额")
    public String NIFIDEPOSIT;

    @ApiModelProperty("向中央银行借款净增加额")
    public String NIBORROWFROMCBANK;

    @ApiModelProperty("存放中央银行和同业款项及其他金融机构净减少额")
    public String NDDEPOSITINCBANKFI;

    @ApiModelProperty("其中:存放中央银行款项净减少额")
    public String NDDEPOSITINCBANK;

    @ApiModelProperty("存放同业及其他金融机构款项净减少额")
    public String NDDEPOSITINFI;

    @ApiModelProperty("拆入资金及卖出回购金融资产款净增加额")
    public String NIBORROWSELLBUYBACK;

    @ApiModelProperty("其中:拆入资金净增加额")
    public String NIBORROWFUND;

    @ApiModelProperty("卖出回购金融资产款净增加额")
    public String NISELLBUYBACKFASSET;

    @ApiModelProperty("拆出资金及买入返售金融资产净减少额")
    public String NDLENDBUYSELLBACK;

    @ApiModelProperty("其中:拆出资金净减少额")
    public String NDLENDFUND;

    @ApiModelProperty("买入返售金融资产净减少额")
    public String NDBUYSELLBACKFASSET;

    @ApiModelProperty("存款证净额")
    public String NETCD;

    @ApiModelProperty("交易性金融负债净增加额")
    public String NITRADEFLIAB;

    @ApiModelProperty("交易性金融资产净减少额")
    public String NDTRADEFASSET;

    @ApiModelProperty("收取的利息、手续费及佣金的现金")
    public String INTANDCOMMREC;

    @ApiModelProperty("其中:收取利息的现金")
    public String INTREC;

    @ApiModelProperty("收取手续费及佣金的现金")
    public String COMMREC;

    @ApiModelProperty("处置抵债资产收到的现金")
    public String DISPMASSETREC;

    @ApiModelProperty("收回的已于以前年度核销的贷款")
    public String CANCELLOANREC;

    @ApiModelProperty("收到的其他与经营活动有关的现金")
    public String OTHEROPERATEREC;

    @ApiModelProperty("经营活动现金流入小计")
    public String SUMOPERATEFLOWIN;

    @ApiModelProperty("客户贷款及垫款净增加额")
    public String NILOANADVANCES;

    @ApiModelProperty("向中央银行借款净减少额")
    public String NDBORROWFROMCBANK;

    @ApiModelProperty("存放中央银行和同业及其他金融机构款项净增加额")
    public String NIDEPOSITINCBANKFI;

    @ApiModelProperty("其中:存放中央银行款项净增加额")
    public String NIDEPOSITINCBANK;

    @ApiModelProperty("存放同业及其他金融机构款项净增加额")
    public String NIDEPOSITINFI;

    @ApiModelProperty("同业及其他机构存放款减少净额")
    public String NDFIDEPOSIT;

    @ApiModelProperty("已发行存款证净减少额")
    public String NDISSUECD;

    @ApiModelProperty("拆出资金及买入返售金融资产净增加额")
    public String NILENDSELLBUYBACK;

    @ApiModelProperty("其中:拆出资金净增加额")
    public String NILENDFUND;

    @ApiModelProperty("买入返售金融资产净增加额")
    public String NIBUYSELLBACKFASSET;

    @ApiModelProperty("拆入资金及卖出回购金融资产款净减少额")
    public String NDBORROWSELLBUYBACK;

    @ApiModelProperty("其中:拆入资金净减少额")
    public String NDBORROWFUND;

    @ApiModelProperty("卖出回购金融资产净减少额")
    public String NDSELLBUYBACKFASSET;

    @ApiModelProperty("交易性金融资产净增加额")
    public String NITRADEFASSET;

    @ApiModelProperty("交易性金融负债净减少额")
    public String NDTRADEFLIAB;

    @ApiModelProperty("支付利息、手续费及佣金的现金")
    public String INTANDCOMMPAY;

    @ApiModelProperty("其中:支付利息的现金")
    public String INTPAY;

    @ApiModelProperty("支付手续费及佣金的现金")
    public String COMMPAY;

    @ApiModelProperty("支付给职工以及为职工支付的现金")
    public String EMPLOYEEPAY;

    @ApiModelProperty("支付的各项税费")
    public String TAXPAY;

    @ApiModelProperty("购买融资租赁资产支付的现金")
    public String BUYFINALEASEASSETPAY;

    @ApiModelProperty("应收账款净增加额")
    public String NIACCOUNTREC;

    @ApiModelProperty("支付其他与经营活动有关的现金")
    public String OTHEROPERATEPAY;

    @ApiModelProperty("经营活动现金流出小计")
    public String SUMOPERATEFLOWOUT;

    @ApiModelProperty("经营活动产生的现金流量净额")
    public String NETOPERATECASHFLOW;

    @ApiModelProperty("收回投资收到的现金")
    public String DISPOSALINVREC;

    @ApiModelProperty("取得投资收益收到的现金")
    public String INVINCOMEREC;

    @ApiModelProperty("其中:分得股利或利润所收到的现金")
    public String DIVIORPROFITREC;

    @ApiModelProperty("处置固定资产、无形资产和其他长期资产收回的现金")
    public String DISPFILASSETREC;

    @ApiModelProperty("处置子公司、联营企业及合营企业投资及其他企业收到的现金")
    public String DISPSUBSIDIARYREC;

    @ApiModelProperty("收到其他与投资活动有关的现金")
    public String OTHERINVREC;

    @ApiModelProperty("投资活动现金流入小计")
    public String SUMINVFLOWIN;

    @ApiModelProperty("投资支付的现金")
    public String INVPAY;

    @ApiModelProperty("购建固定资产、无形资产和其他长期资产支付的现金")
    public String BUYFILASSETPAY;

    @ApiModelProperty("取得子公司及其他营业单位支付的现金")
    public String GETSUBSIDIARYPAY;

    @ApiModelProperty("支付的其他与投资活动有关的现金")
    public String OTHERINVPAY;

    @ApiModelProperty("投资活动现金流出小计")
    public String SUMINVFLOWOUT;

    @ApiModelProperty("投资活动产生的现金流量净额")
    public String NETINVCASHFLOW;

    @ApiModelProperty("发行债券收到的现金")
    public String ISSUEBONDREC;

    @ApiModelProperty("其中:发行次级债券所收到的现金")
    public String ISSUEJUNIORBONDREC;

    @ApiModelProperty("发行其他债券所收到的现金")
    public String ISSUEOTHERBONDREC;

    @ApiModelProperty("收到其他与筹资活动有关的现金")
    public String OTHERFINAREC;

    @ApiModelProperty("吸收投资所收到的现金")
    public String ACCEPTINVREC;

    @ApiModelProperty("其中:子公司吸收少数股东投资收到的现金")
    public String SUBSIDIARYACCEPT;

    @ApiModelProperty("发行存款证")
    public String ISSUECD;

    @ApiModelProperty("增加股本所收到的现金")
    public String ADDSHARECAPITALREC;

    @ApiModelProperty("筹资活动现金流入小计")
    public String SUMFINAFLOWIN;

    @ApiModelProperty("偿还债务支付的现金")
    public String REPAYDEBTPAY;

    @ApiModelProperty("偿付债券利息支付的现金")
    public String BONDINTPAY;

    @ApiModelProperty("股份发行支付的费用")
    public String ISSUESHAREREC;

    @ApiModelProperty("支付其他与筹资活动有关的现金")
    public String OTHERFINAPAY;

    @ApiModelProperty("分配股利、利润或偿付利息支付的现金")
    public String DIVIPROFITORINTPAY;

    @ApiModelProperty("筹资活动现金流出小计")
    public String SUMFINAFLOWOUT;

    @ApiModelProperty("筹资活动产生的现金流量净额")
    public String NETFINACASHFLOW;

    @ApiModelProperty("汇率变动对现金及现金等价物的影响")
    public String EFFECTEXCHANGERATE;

    @ApiModelProperty("现金及现金等价物净增加额")
    public String NICASHEQUI;

    @ApiModelProperty("加:期初现金及现金等价物余额")
    public String CASHEQUIBEGINNING;

    @ApiModelProperty("期末现金及现金等价物余额")
    public String CASHEQUIENDING;



    @ApiModelProperty("客户存款和同业及其他金融机构存放款项净增加额")
    public String NIDEPOSIT_YOY;

    @ApiModelProperty("其中:客户存款净增加额")
    public String NICLIENTDEPOSIT_YOY;

    @ApiModelProperty("同业及其他金融机构存放款项净增加额")
    public String NIFIDEPOSIT_YOY;

    @ApiModelProperty("向中央银行借款净增加额")
    public String NIBORROWFROMCBANK_YOY;

    @ApiModelProperty("存放中央银行和同业款项及其他金融机构净减少额")
    public String NDDEPOSITINCBANKFI_YOY;

    @ApiModelProperty("其中:存放中央银行款项净减少额")
    public String NDDEPOSITINCBANK_YOY;

    @ApiModelProperty("存放同业及其他金融机构款项净减少额")
    public String NDDEPOSITINFI_YOY;

    @ApiModelProperty("拆入资金及卖出回购金融资产款净增加额")
    public String NIBORROWSELLBUYBACK_YOY;

    @ApiModelProperty("其中:拆入资金净增加额")
    public String NIBORROWFUND_YOY;

    @ApiModelProperty("卖出回购金融资产款净增加额")
    public String NISELLBUYBACKFASSET_YOY;

    @ApiModelProperty("拆出资金及买入返售金融资产净减少额")
    public String NDLENDBUYSELLBACK_YOY;

    @ApiModelProperty("其中:拆出资金净减少额")
    public String NDLENDFUND_YOY;

    @ApiModelProperty("买入返售金融资产净减少额")
    public String NDBUYSELLBACKFASSET_YOY;

    @ApiModelProperty("存款证净额")
    public String NETCD_YOY;

    @ApiModelProperty("交易性金融负债净增加额")
    public String NITRADEFLIAB_YOY;

    @ApiModelProperty("交易性金融资产净减少额")
    public String NDTRADEFASSET_YOY;

    @ApiModelProperty("收取的利息、手续费及佣金的现金")
    public String INTANDCOMMREC_YOY;

    @ApiModelProperty("其中:收取利息的现金")
    public String INTREC_YOY;

    @ApiModelProperty("收取手续费及佣金的现金")
    public String COMMREC_YOY;

    @ApiModelProperty("处置抵债资产收到的现金")
    public String DISPMASSETREC_YOY;

    @ApiModelProperty("收回的已于以前年度核销的贷款")
    public String CANCELLOANREC_YOY;

    @ApiModelProperty("收到的其他与经营活动有关的现金")
    public String OTHEROPERATEREC_YOY;

    @ApiModelProperty("经营活动现金流入小计")
    public String SUMOPERATEFLOWIN_YOY;

    @ApiModelProperty("客户贷款及垫款净增加额")
    public String NILOANADVANCES_YOY;

    @ApiModelProperty("向中央银行借款净减少额")
    public String NDBORROWFROMCBANK_YOY;

    @ApiModelProperty("存放中央银行和同业及其他金融机构款项净增加额")
    public String NIDEPOSITINCBANKFI_YOY;

    @ApiModelProperty("其中:存放中央银行款项净增加额")
    public String NIDEPOSITINCBANK_YOY;

    @ApiModelProperty("存放同业及其他金融机构款项净增加额")
    public String NIDEPOSITINFI_YOY;

    @ApiModelProperty("同业及其他机构存放款减少净额")
    public String NDFIDEPOSIT_YOY;

    @ApiModelProperty("已发行存款证净减少额")
    public String NDISSUECD_YOY;

    @ApiModelProperty("拆出资金及买入返售金融资产净增加额")
    public String NILENDSELLBUYBACK_YOY;

    @ApiModelProperty("其中:拆出资金净增加额")
    public String NILENDFUND_YOY;

    @ApiModelProperty("买入返售金融资产净增加额")
    public String NIBUYSELLBACKFASSET_YOY;

    @ApiModelProperty("拆入资金及卖出回购金融资产款净减少额")
    public String NDBORROWSELLBUYBACK_YOY;

    @ApiModelProperty("其中:拆入资金净减少额")
    public String NDBORROWFUND_YOY;

    @ApiModelProperty("卖出回购金融资产净减少额")
    public String NDSELLBUYBACKFASSET_YOY;

    @ApiModelProperty("交易性金融资产净增加额")
    public String NITRADEFASSET_YOY;

    @ApiModelProperty("交易性金融负债净减少额")
    public String NDTRADEFLIAB_YOY;

    @ApiModelProperty("支付利息、手续费及佣金的现金")
    public String INTANDCOMMPAY_YOY;

    @ApiModelProperty("其中:支付利息的现金")
    public String INTPAY_YOY;

    @ApiModelProperty("支付手续费及佣金的现金")
    public String COMMPAY_YOY;

    @ApiModelProperty("支付给职工以及为职工支付的现金")
    public String EMPLOYEEPAY_YOY;

    @ApiModelProperty("支付的各项税费")
    public String TAXPAY_YOY;

    @ApiModelProperty("购买融资租赁资产支付的现金")
    public String BUYFINALEASEASSETPAY_YOY;

    @ApiModelProperty("应收账款净增加额")
    public String NIACCOUNTREC_YOY;

    @ApiModelProperty("支付其他与经营活动有关的现金")
    public String OTHEROPERATEPAY_YOY;

    @ApiModelProperty("经营活动现金流出小计")
    public String SUMOPERATEFLOWOUT_YOY;

    @ApiModelProperty("经营活动产生的现金流量净额")
    public String NETOPERATECASHFLOW_YOY;

    @ApiModelProperty("收回投资收到的现金")
    public String DISPOSALINVREC_YOY;

    @ApiModelProperty("取得投资收益收到的现金")
    public String INVINCOMEREC_YOY;

    @ApiModelProperty("其中:分得股利或利润所收到的现金")
    public String DIVIORPROFITREC_YOY;

    @ApiModelProperty("处置固定资产、无形资产和其他长期资产收回的现金")
    public String DISPFILASSETREC_YOY;

    @ApiModelProperty("处置子公司、联营企业及合营企业投资及其他企业收到的现金")
    public String DISPSUBSIDIARYREC_YOY;

    @ApiModelProperty("收到其他与投资活动有关的现金")
    public String OTHERINVREC_YOY;

    @ApiModelProperty("投资活动现金流入小计")
    public String SUMINVFLOWIN_YOY;

    @ApiModelProperty("投资支付的现金")
    public String INVPAY_YOY;

    @ApiModelProperty("购建固定资产、无形资产和其他长期资产支付的现金")
    public String BUYFILASSETPAY_YOY;

    @ApiModelProperty("取得子公司及其他营业单位支付的现金")
    public String GETSUBSIDIARYPAY_YOY;

    @ApiModelProperty("支付的其他与投资活动有关的现金")
    public String OTHERINVPAY_YOY;

    @ApiModelProperty("投资活动现金流出小计")
    public String SUMINVFLOWOUT_YOY;

    @ApiModelProperty("投资活动产生的现金流量净额")
    public String NETINVCASHFLOW_YOY;

    @ApiModelProperty("发行债券收到的现金")
    public String ISSUEBONDREC_YOY;

    @ApiModelProperty("其中:发行次级债券所收到的现金")
    public String ISSUEJUNIORBONDREC_YOY;

    @ApiModelProperty("发行其他债券所收到的现金")
    public String ISSUEOTHERBONDREC_YOY;

    @ApiModelProperty("收到其他与筹资活动有关的现金")
    public String OTHERFINAREC_YOY;

    @ApiModelProperty("吸收投资所收到的现金")
    public String ACCEPTINVREC_YOY;

    @ApiModelProperty("其中:子公司吸收少数股东投资收到的现金")
    public String SUBSIDIARYACCEPT_YOY;

    @ApiModelProperty("发行存款证")
    public String ISSUECD_YOY;

    @ApiModelProperty("增加股本所收到的现金")
    public String ADDSHARECAPITALREC_YOY;

    @ApiModelProperty("筹资活动现金流入小计")
    public String SUMFINAFLOWIN_YOY;

    @ApiModelProperty("偿还债务支付的现金")
    public String REPAYDEBTPAY_YOY;

    @ApiModelProperty("偿付债券利息支付的现金")
    public String BONDINTPAY_YOY;

    @ApiModelProperty("股份发行支付的费用")
    public String ISSUESHAREREC_YOY;

    @ApiModelProperty("支付其他与筹资活动有关的现金")
    public String OTHERFINAPAY_YOY;

    @ApiModelProperty("分配股利、利润或偿付利息支付的现金")
    public String DIVIPROFITORINTPAY_YOY;

    @ApiModelProperty("筹资活动现金流出小计")
    public String SUMFINAFLOWOUT_YOY;

    @ApiModelProperty("筹资活动产生的现金流量净额")
    public String NETFINACASHFLOW_YOY;

    @ApiModelProperty("汇率变动对现金及现金等价物的影响")
    public String EFFECTEXCHANGERATE_YOY;

    @ApiModelProperty("现金及现金等价物净增加额")
    public String NICASHEQUI_YOY;

    @ApiModelProperty("加:期初现金及现金等价物余额")
    public String CASHEQUIBEGINNING_YOY;

    @ApiModelProperty("期末现金及现金等价物余额")
    public String CASHEQUIENDING_YOY;

}
