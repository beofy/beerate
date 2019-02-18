/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney;
import cn.beerate.model.bean.eastmoney.companybignews.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2019-01-22 17:37:49
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "公司大事")
@Data
public class CompanyBigNews {
    @ApiModelProperty(value = "大事提醒")
    private List<String> dstx;
    private List<Gqzy> gqzy;
    private List<Dwdb> dwdb;
    private List<Sszc> sszc;
    private List<Wgcl> wgcl;
    private List<Xsjj> xsjj;
    private List<Sdgdcgbd> sdgdcgbd;
    private List<Ggcgbd> ggcgbd;
    private List<Dzjy> dzjy;
    private List<Rzrq> rzrq;
    private List<Lhbd> lhbd;
}