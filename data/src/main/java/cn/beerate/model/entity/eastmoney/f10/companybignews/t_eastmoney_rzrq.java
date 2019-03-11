package cn.beerate.model.entity.eastmoney.f10.companybignews;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@ApiModel(description = "融资融券")
@Setter
@Getter
@Entity
public class t_eastmoney_rzrq  extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "时间")
    private String sj;

    @ApiModelProperty(value = "融资买入额(元)")
    private String rzmre;

    @ApiModelProperty(value = "融资偿还额(元)")
    private String rzche;

    @ApiModelProperty(value = "融资余额(元)")
    private String rzye;

    @ApiModelProperty(value = "融券卖出量(股)")
    private String rqmcl;

    @ApiModelProperty(value = "融券偿还量(股)")
    private String rqchl;

    @ApiModelProperty(value = "融券余额(元)")
    private String rqye;

}