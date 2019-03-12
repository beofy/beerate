package cn.beerate.model.entity.eastmoney.f10.capitalstockstructure;

import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@ApiModel(description = "股本构成")
@Setter
@Getter
@Entity
@NoArgsConstructor
public class t_eastmoney_unlisted_share extends Model {

    public t_eastmoney_unlisted_share(String code, String rq, String gfzs, String yssltAg, String sxltgf) {
        this.code = code;
        this.rq = rq;
        this.gfzs = gfzs;
        this.yssltAg = yssltAg;
        this.sxltgf = sxltgf;
    }

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "日期")
    private String rq;

    @ApiModelProperty(value = "股份总数")
    private String gfzs;

    @ApiModelProperty(value = "已上市流通A股")
    private String yssltAg;

    @ApiModelProperty(value = "受限流通股份")
    private String sxltgf;

}
