package cn.beerate.model.bean.eastmoney.f10.shareholderresearch;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "基金持股列表")
@Data
public class JjcgDetail {
    @ApiModelProperty("持股数(股)")
    private String cgs;

    @ApiModelProperty("持仓市值(元)")
    private String cgsz;

    @ApiModelProperty("")
    private String id;

    @ApiModelProperty("基金代码")
    private String jjdm;

    @ApiModelProperty("基金名称")
    private String jjmc;

    @ApiModelProperty("")
    private String order;

    @ApiModelProperty("占净值比")
    private String zjzb;

    @ApiModelProperty("占流通比")
    private String zltb;

    @ApiModelProperty("占总股本比")
    private String zzgbb;
}
