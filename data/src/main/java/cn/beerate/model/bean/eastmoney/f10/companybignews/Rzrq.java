/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.f10.companybignews;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Auto-generated: 2019-01-22 17:37:49
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "融资融券")
@Data
public class Rzrq {
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