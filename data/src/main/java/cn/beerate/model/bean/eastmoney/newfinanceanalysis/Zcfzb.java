package cn.beerate.model.bean.eastmoney.newfinanceanalysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

@ApiModel(description = "资产负债表")
@NoArgsConstructor
public class Zcfzb {

    @ApiModelProperty("股票代码")
    public String SECURITYCODE;

    @ApiModelProperty("报告类型")
    public String REPORTTYPE;

    @ApiModelProperty("报告类型日期类型")
    public String REPORTDATETYPE;

    @ApiModelProperty("类型")
    public String TYPE;

    @ApiModelProperty("报告日期")
    public String REPORTDATE;

    @ApiModelProperty("币种")
    public String CURRENCY;

    @ApiModelProperty("现金及存放中央银行款项")
    public String CASHANDDEPOSITCBANK;

    @ApiModelProperty("存放同业款项")
    public String DEPOSITINFI;

    @ApiModelProperty("贵金属")
    public String PRECIOUSMETAL;

    @ApiModelProperty("拆出资金")
    public String LENDFUND;

    @ApiModelProperty("以公允价值计量且其变动计入当期损益的金融资产")
    public String FVALUEFASSET;

    @ApiModelProperty("其中:交易性金融资产")
    public String TRADEFASSET;

    @ApiModelProperty("指定为以公允价值计量且其变动计入当期损益的金融资产")
    public String DEFINEFVALUEFASSET;

    @ApiModelProperty("衍生金融资产")
    public String DERIVEFASSET;

    @ApiModelProperty("买入返售金融资产")
    public String BUYSELLBACKFASSET;

    @ApiModelProperty("应收账款")
    public String ACCOUNTREC;

    @ApiModelProperty("应收利息")
    public String INTERESTREC;

    @ApiModelProperty("发放贷款及垫款")
    public String LOANADVANCES;

    @ApiModelProperty("可供出售金融资产")
    public String SALEABLEFASSET;

    @ApiModelProperty("持有至到期投资")
    public String HELDMATURITYINV;

    @ApiModelProperty("应收款项类投资")
    public String INVESTREC;

    @ApiModelProperty("长期股权投资")
    public String LTEQUITYINV;

    @ApiModelProperty("对子公司的投资")
    public String INVSUBSIDIARY;

    @ApiModelProperty("对联营和合营企业的投资")
    public String INVJOINT;

    @ApiModelProperty("投资性房地产")
    public String ESTATEINVEST;

    @ApiModelProperty("固定资产")
    public String FIXEDASSET;

    @ApiModelProperty("在建工程")
    public String CONSTRUCTIONPROGRESS;

    @ApiModelProperty("无形资产")
    public String INTANGIBLEASSET;

    @ApiModelProperty("商誉")
    public String GOODWILL;

    @ApiModelProperty("待处理抵债资产")
    public String MASSET;

    @ApiModelProperty("减:抵债资产减值准备")
    public String MASSETDEVALUE;

    @ApiModelProperty("待处理抵债资产净额")
    public String NETMASSET;

    @ApiModelProperty("递延所得税资产")
    public String DEFERINCOMETAXASSET;

    @ApiModelProperty("其他资产")
    public String OTHERASSET;

    @ApiModelProperty("资产总计")
    public String SUMASSET;

    @ApiModelProperty("向中央银行借款")
    public String BORROWFROMCBANK;

    @ApiModelProperty("同业和其他金融机构存放款项")
    public String FIDEPOSIT;

    @ApiModelProperty("拆入资金")
    public String BORROWFUND;

    @ApiModelProperty("以公允价值计量且其变动计入当期损益的金融负债")
    public String FVALUEFLIAB;

    @ApiModelProperty("其中:交易性金融负债")
    public String TRADEFLIAB;

    @ApiModelProperty("指定以公允价值计量且其变动计入当期损益的金融负债")
    public String DEFINEFVALUEFLIAB;

    @ApiModelProperty("衍生金融负债")
    public String DERIVEFLIAB;

    @ApiModelProperty("卖出回购金融资产款")
    public String SELLBUYBACKFASSET;

    @ApiModelProperty("吸收存款")
    public String ACCEPTDEPOSIT;

    @ApiModelProperty("汇出汇款")
    public String OUTWARDREMITTANCE;

    @ApiModelProperty("存款证及应付票据")
    public String CDANDBILLREC;

    @ApiModelProperty("其中:存款证")
    public String CD;

    @ApiModelProperty("应付职工薪酬")
    public String SALARYPAY;

    @ApiModelProperty("应交税费")
    public String TAXPAY;

    @ApiModelProperty("应付利息")
    public String INTERESTPAY;

    @ApiModelProperty("应付股利")
    public String DIVIDENDPAY;

    @ApiModelProperty("预计负债")
    public String ANTICIPATELIAB;

    @ApiModelProperty("递延所得税负债")
    public String DEFERINCOMETAXLIAB;

    @ApiModelProperty("应付债券")
    public String BONDPAY;

    @ApiModelProperty("其中:优先股")
    public String PREFERSTOCBOND;

    @ApiModelProperty("永续债")
    public String SUSTAINBOND;

    @ApiModelProperty("应付次级债券")
    public String JUNIORBONDPAY;

    @ApiModelProperty("其他负债")
    public String OTHERLIAB;

    @ApiModelProperty("负债合计")
    public String SUMLIAB;

    @ApiModelProperty("股本")
    public String SHEQUITY;

    @ApiModelProperty("其他权益工具")
    public String OTHEREQUITY;

    @ApiModelProperty("其中:优先股")
    public String PREFERREDSTOCK;

    @ApiModelProperty("永续债")
    public String SUSTAINABLEDEBT;

    @ApiModelProperty("其他权益工具")
    public String OTHEREQUITYOTHER;

    @ApiModelProperty("资本公积")
    public String CAPITALRESERVE;

    @ApiModelProperty("投资重估储备")
    public String INVREVALUERESERVE;

    @ApiModelProperty("库存股")
    public String INVENTORYSHARE;

    @ApiModelProperty("套期储备")
    public String HEDGERESERVE;

    @ApiModelProperty("盈余公积")
    public String SURPLUSRESERVE;

    @ApiModelProperty("一般风险准备")
    public String GENERALRISKPREPARE;

    @ApiModelProperty("未分配利润")
    public String RETAINEDEARNING;

    @ApiModelProperty("建议分派股利")
    public String SUGGESTASSIGNDIVI;

    @ApiModelProperty("外币报表折算差额")
    public String DIFFCONVERSIONFC;

    @ApiModelProperty("归属于母公司股东权益合计")
    public String SUMPARENTEQUITY;

    @ApiModelProperty("少数股东权益")
    public String MINORITYEQUITY;

    @ApiModelProperty("股东权益合计")
    public String SUMSHEQUITY;

    @ApiModelProperty("负债及股东权益总计")
    public String SUMLIABSHEQUITY;

    @ApiModelProperty("现金及存放中央银行款项")
    public String CASHANDDEPOSITCBANK_YOY;

    @ApiModelProperty("存放同业款项")
    public String DEPOSITINFI_YOY;

    @ApiModelProperty("贵金属")
    public String PRECIOUSMETAL_YOY;

    @ApiModelProperty("拆出资金")
    public String LENDFUND_YOY;

    @ApiModelProperty("以公允价值计量且其变动计入当期损益的金融资产")
    public String FVALUEFASSET_YOY;

    @ApiModelProperty("其中:交易性金融资产")
    public String TRADEFASSET_YOY;

    @ApiModelProperty("指定为以公允价值计量且其变动计入当期损益的金融资产")
    public String DEFINEFVALUEFASSET_YOY;

    @ApiModelProperty("衍生金融资产")
    public String DERIVEFASSET_YOY;

    @ApiModelProperty("买入返售金融资产")
    public String BUYSELLBACKFASSET_YOY;

    @ApiModelProperty("应收账款")
    public String ACCOUNTREC_YOY;

    @ApiModelProperty("应收利息")
    public String INTERESTREC_YOY;

    @ApiModelProperty("发放贷款及垫款")
    public String LOANADVANCES_YOY;

    @ApiModelProperty("可供出售金融资产")
    public String SALEABLEFASSET_YOY;

    @ApiModelProperty("持有至到期投资")
    public String HELDMATURITYINV_YOY;

    @ApiModelProperty("应收款项类投资")
    public String INVESTREC_YOY;

    @ApiModelProperty("长期股权投资")
    public String LTEQUITYINV_YOY;

    @ApiModelProperty("对子公司的投资")
    public String INVSUBSIDIARY_YOY;

    @ApiModelProperty("对联营和合营企业的投资")
    public String INVJOINT_YOY;

    @ApiModelProperty("投资性房地产")
    public String ESTATEINVEST_YOY;

    @ApiModelProperty("固定资产")
    public String FIXEDASSET_YOY;

    @ApiModelProperty("在建工程")
    public String CONSTRUCTIONPROGRESS_YOY;

    @ApiModelProperty("无形资产")
    public String INTANGIBLEASSET_YOY;

    @ApiModelProperty("商誉")
    public String GOODWILL_YOY;

    @ApiModelProperty("待处理抵债资产")
    public String MASSET_YOY;

    @ApiModelProperty("减:抵债资产减值准备")
    public String MASSETDEVALUE_YOY;

    @ApiModelProperty("待处理抵债资产净额")
    public String NETMASSET_YOY;

    @ApiModelProperty("递延所得税资产")
    public String DEFERINCOMETAXASSET_YOY;

    @ApiModelProperty("其他资产")
    public String OTHERASSET_YOY;

    @ApiModelProperty("资产总计")
    public String SUMASSET_YOY;

    @ApiModelProperty("向中央银行借款")
    public String BORROWFROMCBANK_YOY;

    @ApiModelProperty("同业和其他金融机构存放款项")
    public String FIDEPOSIT_YOY;

    @ApiModelProperty("拆入资金")
    public String BORROWFUND_YOY;

    @ApiModelProperty("以公允价值计量且其变动计入当期损益的金融负债")
    public String FVALUEFLIAB_YOY;

    @ApiModelProperty("其中:交易性金融负债")
    public String TRADEFLIAB_YOY;

    @ApiModelProperty("指定以公允价值计量且其变动计入当期损益的金融负债")
    public String DEFINEFVALUEFLIAB_YOY;

    @ApiModelProperty("衍生金融负债")
    public String DERIVEFLIAB_YOY;

    @ApiModelProperty("卖出回购金融资产款")
    public String SELLBUYBACKFASSET_YOY;

    @ApiModelProperty("吸收存款")
    public String ACCEPTDEPOSIT_YOY;

    @ApiModelProperty("汇出汇款")
    public String OUTWARDREMITTANCE_YOY;

    @ApiModelProperty("存款证及应付票据")
    public String CDANDBILLREC_YOY;

    @ApiModelProperty("其中:存款证")
    public String CD_YOY;

    @ApiModelProperty("应付职工薪酬")
    public String SALARYPAY_YOY;

    @ApiModelProperty("应交税费")
    public String TAXPAY_YOY;

    @ApiModelProperty("应付利息")
    public String INTERESTPAY_YOY;

    @ApiModelProperty("应付股利")
    public String DIVIDENDPAY_YOY;

    @ApiModelProperty("预计负债")
    public String ANTICIPATELIAB_YOY;

    @ApiModelProperty("递延所得税负债")
    public String DEFERINCOMETAXLIAB_YOY;

    @ApiModelProperty("应付债券")
    public String BONDPAY_YOY;

    @ApiModelProperty("其中:优先股")
    public String PREFERSTOCBOND_YOY;

    @ApiModelProperty("永续债")
    public String SUSTAINBOND_YOY;

    @ApiModelProperty("应付次级债券")
    public String JUNIORBONDPAY_YOY;

    @ApiModelProperty("其他负债")
    public String OTHERLIAB_YOY;

    @ApiModelProperty("负债合计")
    public String SUMLIAB_YOY;

    @ApiModelProperty("股本")
    public String SHEQUITY_YOY;

    @ApiModelProperty("其他权益工具")
    public String OTHEREQUITY_YOY;

    @ApiModelProperty("其中:优先股")
    public String PREFERREDSTOCK_YOY;

    @ApiModelProperty("永续债")
    public String SUSTAINABLEDEBT_YOY;

    @ApiModelProperty("其他权益工具")
    public String OTHEREQUITYOTHER_YOY;

    @ApiModelProperty("资本公积")
    public String CAPITALRESERVE_YOY;

    @ApiModelProperty("投资重估储备")
    public String INVREVALUERESERVE_YOY;

    @ApiModelProperty("库存股")
    public String INVENTORYSHARE_YOY;

    @ApiModelProperty("套期储备")
    public String HEDGERESERVE_YOY;

    @ApiModelProperty("盈余公积")
    public String SURPLUSRESERVE_YOY;

    @ApiModelProperty("一般风险准备")
    public String GENERALRISKPREPARE_YOY;

    @ApiModelProperty("未分配利润")
    public String RETAINEDEARNING_YOY;

    @ApiModelProperty("建议分派股利")
    public String SUGGESTASSIGNDIVI_YOY;

    @ApiModelProperty("外币报表折算差额")
    public String DIFFCONVERSIONFC_YOY;

    @ApiModelProperty("归属于母公司股东权益合计")
    public String SUMPARENTEQUITY_YOY;

    @ApiModelProperty("少数股东权益")
    public String MINORITYEQUITY_YOY;

    @ApiModelProperty("股东权益合计")
    public String SUMSHEQUITY_YOY;

    @ApiModelProperty("负债及股东权益总计")
    public String SUMLIABSHEQUITY_YOY;

}
