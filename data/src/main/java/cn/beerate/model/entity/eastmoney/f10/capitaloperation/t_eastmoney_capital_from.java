package cn.beerate.model.entity.eastmoney.f10.capitaloperation;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@ApiModel(description = "募集资金来源")
@Setter
@Getter
@Entity
public class t_eastmoney_capital_from extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "公告日期")
    private String ggrq;

    @ApiModelProperty(value = "发行类别")
    private String fxlb;

    @ApiModelProperty(value = "实际募集资金净额(万元)")
    private String sjmjzjje;

    @ApiModelProperty(value = "发行起始日")
    private String fxqsr;

    @ApiModelProperty(value = "证券名称")
    private String zqmc;

    @ApiModelProperty(value = "证券类别")
    private String zqlb;
}