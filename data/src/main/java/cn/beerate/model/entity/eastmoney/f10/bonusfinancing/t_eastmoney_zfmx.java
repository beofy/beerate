package cn.beerate.model.entity.eastmoney.f10.bonusfinancing;

import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@ApiModel(description = "增发明细")
@Setter
@Getter
@Entity
public class t_eastmoney_zfmx extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "增发时间")
    private String zfsj;

    @ApiModelProperty(value = "实际增发数量(万股)")
    private String sjzfsl;

    @ApiModelProperty(value = "实际募集净额(万元)")
    private String sjmjje;

    @ApiModelProperty(value = "增发价格(元/股)")
    private String zfjg;

    @ApiModelProperty(value = "发行方式")
    private String fxfs;

    @ApiModelProperty(value = "股权登记日")
    private String gqdjr;

    @ApiModelProperty(value = "增发上市日")
    private String zfssr;

    @ApiModelProperty(value = "资金到账日")
    private String zjdzr;
}