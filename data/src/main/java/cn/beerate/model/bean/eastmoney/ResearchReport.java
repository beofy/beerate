/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney;
import cn.beerate.model.bean.eastmoney.researchreport.Gsyb;
import cn.beerate.model.bean.eastmoney.researchreport.Hyyb;
import cn.beerate.model.bean.eastmoney.researchreport.Ybzy;
import io.swagger.annotations.ApiModel;
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