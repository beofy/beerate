package cn.beerate.model.entity.eastmoney.report;

import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;


@ApiModel(description = "个股研报")
@NoArgsConstructor
@Setter
@Getter
@Entity
public class t_eastmoney_ggsr extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("评级变动")
    @Column(name = "_change")
    private String change;

    @ApiModelProperty("公司代码")
    private String companyCode;

    @ApiModelProperty("时间")
    @Column(name = "bgrq")
    private String datetime;

    @ApiModelProperty("详情代码")
    private String infoCode;

    @ApiModelProperty("机构代码")
    private String insCode;

    @ApiModelProperty("机构名称")
    private String insName;

    private String insStar;

    @ApiModelProperty("原文评级")
    private String rate;

    @ApiModelProperty("股票代码")
    private String secuFullCode;

    @ApiModelProperty("股票名称")
    private String secuName;

    @ApiModelProperty("评级类别")
    private String sratingName;

    @ApiModelProperty("收益")
    private String sy;

    @ApiModelProperty("标题")
    private String title;

    private String profitYear;

    private String type;

    @ApiModelProperty("收益 ")
    private String newPrice;

    @Transient
    private List<String> jlrs;

    @Transient
    private List<String> syls;

    @Transient
    private List<String> sys;
}
