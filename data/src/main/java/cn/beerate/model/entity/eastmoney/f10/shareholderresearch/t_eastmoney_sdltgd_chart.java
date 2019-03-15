package cn.beerate.model.entity.eastmoney.f10.shareholderresearch;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@ApiModel(description = "流通股东占比详情")
@Setter
@Getter
@Entity
public class t_eastmoney_sdltgd_chart  extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty("日期")
    private String rq;

    @ApiModelProperty("十大流通股东持股")
    private String sdltgdcg;

    @ApiModelProperty("流通受限股份")
    private String ltsxgf;

    @ApiModelProperty("其余流通股份")
    private String qyltgf;

}