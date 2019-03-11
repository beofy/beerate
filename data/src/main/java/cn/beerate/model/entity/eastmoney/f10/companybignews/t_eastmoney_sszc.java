package cn.beerate.model.entity.eastmoney.f10.companybignews;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(description = "诉讼仲裁")
@Setter
@Getter
@Entity
public class t_eastmoney_sszc  extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "公告日期")
    private String ggrq;

    @ApiModelProperty(value = "案件名称")
    private String ajmc;

    @ApiModelProperty(value = "案件简介")
    @Column(columnDefinition = "TEXT")
    private String ajjj;

    @ApiModelProperty(value = "原告方")
    private String ygf;

    @ApiModelProperty(value = "被告方")
    private String bgf;

    @ApiModelProperty(value = "诉讼类型")
    private String sslx;

    @ApiModelProperty(value = "涉案金额(万元)")
    private String saje;

    @ApiModelProperty(value = "币种")
    private String bz;

    @ApiModelProperty(value = "一审_起诉日期")
    private String ysqsrq;

    @ApiModelProperty(value = "一审_受理法院")
    private String ysslfy;

    @ApiModelProperty(value = "一审_判决日期")
    private String yspjrq;

    @ApiModelProperty(value = "一审_判决内容")
    @Column(columnDefinition = "TEXT")
    private String yspjnr;

    @ApiModelProperty(value = "一审_是否上诉")
    private String yssfss;

    @ApiModelProperty(value = "二审_上诉方")
    private String esssf;

    @ApiModelProperty(value = "二审_受理法院")
    private String esslfy;

    @ApiModelProperty(value = "二审_判决日期")
    private String espjrq;

    @ApiModelProperty(value = "二审_判决内容")
    @Column(columnDefinition = "TEXT")
    private String espjnr;

    @ApiModelProperty(value = "执行情况")
    @Column(columnDefinition = "TEXT")
    private String zxqk;

}