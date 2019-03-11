package cn.beerate.model.entity.eastmoney.f10.companybignews;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@ApiModel(description = "对外担保")
@Setter
@Getter
@Entity
public class t_eastmoney_dwdb extends Model{

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "公告日期")
    private String ggrq;

    @ApiModelProperty(value = "担保方")
    private String dbf;

    @ApiModelProperty(value = "被担保方")
    private String bdbf;

    @ApiModelProperty(value = "担保方式")
    private String dbfs;

    @ApiModelProperty(value = "担保金额(万元)")
    private String dbje;

    @ApiModelProperty(value = "币种")
    private String bz;

    @ApiModelProperty(value = "担保期限(年)")
    private String dbqx;

    @ApiModelProperty(value = "担保起始日")
    private String dbqsr;

    @ApiModelProperty(value = "担保终止日")
    private String dbzzr;

    @ApiModelProperty(value = "是否履行完毕")
    private String sflxwb;

    @ApiModelProperty(value = "是否关联交易")
    private String sfgljy;

    @ApiModelProperty(value = "交易日期")
    private String jyrq;

    @ApiModelProperty(value = "担保事件说明")
    @Column(columnDefinition = "TEXT")
    private String dbsjsm;

    @ApiModelProperty(value = "报告期")
    private String bgq;

    @ApiModelProperty(value = "报告期类别")
    private String bgqlb;

}