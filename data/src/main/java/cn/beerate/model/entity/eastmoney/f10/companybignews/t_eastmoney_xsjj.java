package cn.beerate.model.entity.eastmoney.f10.companybignews;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@ApiModel(description = "限售解禁")
@Setter
@Getter
@Entity
public class t_eastmoney_xsjj  extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "解禁时间")
    private String jjsj;

    @ApiModelProperty(value = "解禁数量(股)")
    private String jjsl;

    @ApiModelProperty(value = "解禁股占总股本比例")
    private String jjgzzgbbl;

    @ApiModelProperty(value = "解禁股占流通股本比例")
    private String jjgzltgbbl;

    @ApiModelProperty(value = "股票类型")
    private String gplx;

}