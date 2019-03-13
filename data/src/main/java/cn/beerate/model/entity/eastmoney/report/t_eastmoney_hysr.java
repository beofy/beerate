package cn.beerate.model.entity.eastmoney.report;

import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@ApiModel(description = "行业研报")
@NoArgsConstructor
@Setter
@Getter
@Entity
public class t_eastmoney_hysr extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty("报告日期")
    private String  bgrq;

    @ApiModelProperty("行业名称")
    private String hymc;

    @ApiModelProperty("涨跌幅")
    private String zdf;

    @ApiModelProperty("标题")
    private String bt;

    @ApiModelProperty("评级类别")
    private String pjlb;

    @ApiModelProperty("评级变动")
    private String pjbd;

    @ApiModelProperty("机构名称")
    private String  jgmc;

    @ApiModelProperty("研报地址标识")
    private String infoCode;

}
