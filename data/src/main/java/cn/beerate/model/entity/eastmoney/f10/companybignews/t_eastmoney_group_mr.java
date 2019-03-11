package cn.beerate.model.entity.eastmoney.f10.companybignews;

import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@ApiModel(description = "买入营业部")
@Setter
@Getter
@Entity
public class t_eastmoney_group_mr  extends Model {

    @ApiModelProperty(value = "营业部名称")
    private String yybmc;

    @ApiModelProperty(value = "买入金额(元)")
    private String mrje;

    @ApiModelProperty(value = "买入占金额比(%)")
    private String zjeb_mr;

    @ApiModelProperty(value = "卖出金额")
    private String mcje;

    @ApiModelProperty(value = "卖出占金额比(%)")
    private String zjeb_mc;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lhbd_id")
    private t_eastmoney_lhbd lhbd;
}