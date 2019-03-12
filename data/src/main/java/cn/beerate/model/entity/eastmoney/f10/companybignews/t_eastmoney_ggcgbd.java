package cn.beerate.model.entity.eastmoney.f10.companybignews;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@ApiModel(description = "高管持股变动")
@Setter
@Getter
@Entity
public class t_eastmoney_ggcgbd  extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "日期")
    private String rq;

    @ApiModelProperty(value = "变动人")
    private String bdr;

    @ApiModelProperty(value = "变动数量(股)")
    private String bdsl;

    @ApiModelProperty(value = "结存股票(股)")
    private String jcgp;

    @ApiModelProperty(value = "交易均价(元)")
    private String jyjj;

    @ApiModelProperty(value = "董监高管")
    private String djgg;

    @ApiModelProperty(value = "与高管关系")
    private String ygggx;

    @ApiModelProperty(value = "股份变动途径")
    private String gfbdtj;

}