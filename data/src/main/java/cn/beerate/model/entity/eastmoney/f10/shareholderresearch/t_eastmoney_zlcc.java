package cn.beerate.model.entity.eastmoney.f10.shareholderresearch;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@ApiModel(description = "机构持仓")
@Setter
@Getter
@Entity
public class t_eastmoney_zlcc  extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "日期")
    private String rq;

    @ApiModelProperty(value = "机构类型")
    private String jglx;

    @ApiModelProperty(value = "持仓家数")
    private String ccjs;

    @ApiModelProperty(value = "持仓股数(股)")
    private String ccgs;

    @ApiModelProperty(value = "占流通股比例")
    private String zltgbl;

    @ApiModelProperty(value = "占总股本比例")
    private String zltgbbl;
}