/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean;
import cn.beerate.model.bean.researchreport.Gsyb;
import cn.beerate.model.bean.researchreport.Hyyb;
import cn.beerate.model.bean.researchreport.Ybzy;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2019-01-23 17:3:41
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "研究报告")
@Data
public class ResearchReport {
    private List<Ybzy> ybzy;
    private List<Gsyb> gsyb;
    private List<Hyyb> hyyb;
}