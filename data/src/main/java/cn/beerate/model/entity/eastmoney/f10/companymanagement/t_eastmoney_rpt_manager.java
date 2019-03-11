package cn.beerate.model.entity.eastmoney.f10.companymanagement;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;


@ApiModel(description = "高管列表")
@Setter
@Getter
@Entity
public class t_eastmoney_rpt_manager extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "姓名")
    private String xm;

    @ApiModelProperty(value = "性别")
    private String xb;

    @ApiModelProperty(value = "年龄")
    private String nl;

    @ApiModelProperty(value = "学历")
    private String xl;

    @ApiModelProperty(value = "职务")
    private String zw;

    @ApiModelProperty(value = "任职时间")
    private String rzsj;

    @ApiModelProperty(value = "简介")
    @Column(columnDefinition = "TEXT")
    private String jj;
}