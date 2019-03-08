package cn.beerate.model.bean.eastmoney.f10.newfinanceanalysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "占比详细信息")
@NoArgsConstructor
@Data
public class ZbDetail {
    
    @ApiModelProperty("日期")
    private String date;

    @ApiModelProperty("总资产")
    private String zzc;

    @ApiModelProperty("流动资产")
    private String ldzc;

    @ApiModelProperty("流动资产百分比")
    private String ldzcbfb;

    @ApiModelProperty("货币资金")
    private String hbzj;

    @ApiModelProperty("货币资金百分比")
    private String hbzjbfb;

    @ApiModelProperty("应收账款")
    private String yszk;

    @ApiModelProperty("应收账款百分比")
    private String yszkbfb;

    @ApiModelProperty("存货")
    private String ch;

    @ApiModelProperty("存货百分比")
    private String chbfb;

    @ApiModelProperty("预付账款")
    private String yfzk;

    @ApiModelProperty("预付账款百分比")
    private String yfzkbfb;

    @ApiModelProperty("非流动资产")
    private String fldzc;

    @ApiModelProperty("非流动资产百分比")
    private String fldzcbfb;

    @ApiModelProperty("固定资产")
    private String gdzc;

    @ApiModelProperty("固定资产百分比")
    private String gdzcbfb;

    @ApiModelProperty("无形资产")
    private String wxzc;

    @ApiModelProperty("无形资产百分比")
    private String wxzcbfb;

    @ApiModelProperty("长期待摊费用")
    private String cqdtfy;

    @ApiModelProperty("长期待摊费用百分比")
    private String cqdtfybfb;

    @ApiModelProperty("金融资产")
    private String jrzc;

    @ApiModelProperty("金融资产百分比")
    private String jrzcbfb;

    @ApiModelProperty("总负债金额")
    private String zfzje;

    @ApiModelProperty("流动负债")
    private String ldfz;

    @ApiModelProperty("流动负债百分比")
    private String ldfzbfb;

    @ApiModelProperty("非流动负债")
    private String fldfz;

    @ApiModelProperty("非流动负债百分比")
    private String fldfzbfb;

}
