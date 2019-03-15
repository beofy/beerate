package cn.beerate.model.entity.eastmoney.f10.bonusfinancing;

import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@ApiModel(description = "历年分红融资")
@Setter
@Getter
@Entity
public class t_eastmoney_lnfhrz extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "时间")
    private String sj;

    @ApiModelProperty(value = "分红总额(万元)")
    private String fhze;

    @ApiModelProperty(value = "增发(万股)")
    private String zf;

    @ApiModelProperty(value = "配股(万股)")
    private String pg;

    @ApiModelProperty(value = "新股发行(万股)")
    private String xgfx;
}