/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean;
import cn.beerate.model.bean.companybignews.Xsjj;
import cn.beerate.model.bean.shareholderresearch.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2019-01-24 14:51:13
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "股东研究")
@Data
public class ShareholderResearch {

    private List<Gdrs> gdrs;

    private List<Sdltgd> sdltgd;

    private List<Sdgd> sdgd;

    private List<Jjcg> jjcg;

    private List<Sdgdcgbd> sdgdcgbd;

    private List<Xsjj> xsjj;

    private List<Sdltgd_chart> sdltgd_chart;

    private List<Zlcc> zlcc;

    @ApiModelProperty(value = "机构持仓日期")
    private List<String> zlcc_rz;

    private Kggx kggx;
}