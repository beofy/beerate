package cn.beerate.model.entity.eastmoney.f10.companybignews;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@ApiModel(description = "股票质押")
@Setter
@Getter
@Entity
public class t_eastmoney_gqzy  extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "公告日期")
    private String ggrq;

    @ApiModelProperty(value = "公告名称")
    private String gdmc;

    @ApiModelProperty(value = "质押方")
    private String zyf;

    @ApiModelProperty(value = "是否质押式回购 1-是 2-否")
    private String zyshg;

    @ApiModelProperty(value = " 质押股数(万股)")
    private String zygs;

    @ApiModelProperty(value = " 占总股本比例(%))")
    private String zzgbbl;

    @ApiModelProperty(value = " 占股东持股比例(%)")
    private String zgdcgbl;

    @ApiModelProperty(value = "质押起始日")
    private String zyqsr;

    @ApiModelProperty(value = "质押截止日")
    private String zyjzr;

    @ApiModelProperty(value = " 解押日期")
    private String jyrq;

}