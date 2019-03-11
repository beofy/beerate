package cn.beerate.model.entity.eastmoney.f10.companybignews;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@ApiModel(description = "十大股东持股变动")
@Setter
@Getter
@Entity
public class t_eastmoney_sdgdcgbd  extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "截止时间")
    private String bdsj;

    @ApiModelProperty(value = "名次")
    private String mc;

    @ApiModelProperty(value = "股东名称")
    private String gdmc;

    @ApiModelProperty(value = "股份类型")
    private String gflx;

    @ApiModelProperty(value = "持股数(股)")
    private String cgs;

    @ApiModelProperty(value = "占总股本持股比例")
    private String zzgbcgbl;

    @ApiModelProperty(value = "增减(股")
    private String cj;

    @ApiModelProperty(value = "增减股占原股东持股比例")
    private String cjgzygdcgbl;

    @ApiModelProperty(value = "变动原因")
    private String bdyy;


}