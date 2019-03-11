package cn.beerate.model.entity.eastmoney.f10.companybignews;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@ApiModel(description = "大宗交易")
@Setter
@Getter
@Entity
public class t_eastmoney_dzjy  extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "交易日期")
    private String jyrq;

    @ApiModelProperty(value = "成交价(元)")
    private String cjj;

    @ApiModelProperty(value = "成交量(股)")
    private String cjl;

    @ApiModelProperty(value = "成交金额(元)")
    private String cjje;

    @ApiModelProperty(value = "买入营业部")
    private String mryyb;

    @ApiModelProperty(value = "卖出营业部")
    private String mcyyb;

}