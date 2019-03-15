package cn.beerate.model.entity.eastmoney.f10.bonusfinancing;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@ApiModel(description = "配股明细")
@Setter
@Getter
@Entity
public class t_eastmoney_pgmx extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "配股公告日")
    private String pgggr;

    @ApiModelProperty(value = "配股价格(元)")
    private String pgjg;

    @ApiModelProperty(value = "实际配股数量(万元)")
    private String sjpgsl;

    @ApiModelProperty(value = "实际募资总额(万元)")
    private String sjmjze;

    @ApiModelProperty(value = "股权登记日")
    private String gqdjr;

    @ApiModelProperty(value = "除权基准日")
    private String cqjzr;

    @ApiModelProperty(value = "配股方案")
    private String pgfa;
}