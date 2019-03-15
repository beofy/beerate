package cn.beerate.model.entity.eastmoney.f10.newfinanceanalysis;

import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@ApiModel(description = "主要指标")
@NoArgsConstructor
@Setter
@Getter
@Entity
public class t_eastmoney_main_target extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "报告类型")
    private String type;

    @ApiModelProperty("时间")
    private String date;

    @ApiModelProperty("基本每股收益(元)")
    private String jbmgsy;

    @ApiModelProperty("扣非每股收益(元)")
    private String kfmgsy;

    @ApiModelProperty("稀释每股收益(元)")
    private String xsmgsy;

    @ApiModelProperty("每股净资产(元)")
    private String mgjzc;

    @ApiModelProperty("每股公积金(元)")
    private String mggjj;

    @ApiModelProperty("每股未分配利润(元)")
    private String mgwfply;

    @ApiModelProperty("每股经营现金流(元)")
    private String mgjyxjl;

    @ApiModelProperty("营业总收入(元)")
    private String yyzsr;

    @ApiModelProperty("毛利润(元)")
    private String mlr;

    @ApiModelProperty("归属净利润(元)")
    private String gsjlr;

    @ApiModelProperty("扣非净利润(元)")
    private String kfjlr;

    @ApiModelProperty("营业总收入同比增长(%)")
    private String yyzsrtbzz;

    @ApiModelProperty("归属净利润同比增长(%)")
    private String gsjlrtbzz;

    @ApiModelProperty("扣非净利润同比增长(%)")
    private String kfjlrtbzz;

    @ApiModelProperty("营业总收入滚动环比增长(%)")
    private String yyzsrgdhbzz;

    @ApiModelProperty("归属净利润滚动环比增长(%)")
    private String gsjlrgdhbzz;

    @ApiModelProperty("扣非净利润滚动环比增长(%)")
    private String kfjlrgdhbzz;

    @ApiModelProperty("加权净资产收益率(%)")
    private String jqjzcsyl;

    @ApiModelProperty("摊薄净资产收益率(%)")
    private String tbjzcsyl;

    @ApiModelProperty("摊薄总资产收益率(%)")
    private String tbzzcsyl;

    @ApiModelProperty("毛利率(%)")
    private String mll;

    @ApiModelProperty("净利率(%)")
    private String jll;

    @ApiModelProperty("实际税率(%)")
    private String sjsl;

    @ApiModelProperty("预收款/营业收入")
    private String yskyysr;

    @ApiModelProperty("销售现金流/营业收入")
    private String xsxjlyysr;

    @ApiModelProperty("经营现金流/营业收入")
    private String jyxjlyysr;

    @ApiModelProperty("总资产周转率(次)")
    private String zzczzy;

    @ApiModelProperty("应收账款周转天数(天)")
    private String yszkzzts;

    @ApiModelProperty("存货周转天数(天)")
    private String chzzts;

    @ApiModelProperty("资产负债率(%)")
    private String zcfzl;

    @ApiModelProperty("流动负债/总负债(%)")
    private String ldzczfz;

    @ApiModelProperty("流动比率")
    private String ldbl;

    @ApiModelProperty("速动比率")
    private String sdbl;

}
