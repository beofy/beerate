package cn.beerate.model.entity.eastmoney.f10.capitaloperation;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@ApiModel(description = "项目进度")
@Setter
@Getter
@Entity
public class t_eastmoney_project_progress extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "项目名称")
    private String xmmc;

    @ApiModelProperty(value = "截止日期")
    private Date jzrq;

    @ApiModelProperty(value = "计划投资(万元)")
    private String jhtz;

    @ApiModelProperty(value = "已投入募集资金(万元)")
    private String ytrmjzj;

    @ApiModelProperty(value = "建设期(年)")
    private String jsq;

    @ApiModelProperty(value = "收益率(税后)")
    private String syl;

    @ApiModelProperty(value = "投资回收期(年)")
    private String tzhsq;
}