package cn.beerate.model.entity.eastmoney.f10.shareholderresearch;

import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@ApiModel(description = "实际控制人")
@Setter
@Getter
@Entity
public class t_eastmoney_kggx  extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "实际控制人")
    private String sjkzr;

    @ApiModelProperty(value = "持股比例")
    private String cgbl;
}