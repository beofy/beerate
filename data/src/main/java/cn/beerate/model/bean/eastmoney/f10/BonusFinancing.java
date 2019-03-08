/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.f10;
import cn.beerate.model.bean.eastmoney.f10.bonusfinancing.Fhyx;
import cn.beerate.model.bean.eastmoney.f10.bonusfinancing.Lnfhrz;
import cn.beerate.model.bean.eastmoney.f10.bonusfinancing.Pgmx;
import cn.beerate.model.bean.eastmoney.f10.bonusfinancing.Zfmx;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2019-01-23 13:57:36
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "分红融资")
@Data
public class BonusFinancing {
    private List<Fhyx> fhyx;
    private List<Lnfhrz> lnfhrz;
    private List<Zfmx> zfmx;
    private List<Pgmx> pgmx;
}