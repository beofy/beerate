package cn.beerate.model.entity.eastmoney.f10.companybignews;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(description = "违规处理")
@Setter
@Getter
@Entity
public class t_eastmoney_wgcl  extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "公告日期")
    private String ggrq;

    @ApiModelProperty(value = "类型")
    private String lx;

    @ApiModelProperty(value = "处罚对象")
    private String cfdx;

    @ApiModelProperty(value = "违规行为")
    @Column(columnDefinition = "TEXT")
    private String wgxw;

    @ApiModelProperty(value = "处分类型")
    private String cflx;

    @ApiModelProperty(value = "处分措施")
    @Column(columnDefinition = "TEXT")
    private String cfcs;

    @ApiModelProperty(value = "处理人")
    private String clr;

    @ApiModelProperty(value = "处罚金额(万元)")
    private String cfje;

}