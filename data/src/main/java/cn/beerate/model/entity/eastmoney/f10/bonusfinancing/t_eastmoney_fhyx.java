package cn.beerate.model.entity.eastmoney.f10.bonusfinancing;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@ApiModel(description = "分红影响")
@Setter
@Getter
@Entity
public class t_eastmoney_fhyx extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "公告日期")
    private String ggrq;

    @ApiModelProperty(value = "分红方案")
    private String fhfa;

    @ApiModelProperty(value = "股权登记日")
    private String gqdjr;

    @ApiModelProperty(value = "除权除息日")
    private String cqcxr;

    @ApiModelProperty(value = "派息日")
    private String pxr;

    @ApiModelProperty(value = "方案进度")
    private String fajd;
}