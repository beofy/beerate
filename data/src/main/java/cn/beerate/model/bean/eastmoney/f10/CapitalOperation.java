/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.f10;
import cn.beerate.model.entity.eastmoney.f10.capitaloperation.t_eastmoney_capital_from;
import cn.beerate.model.entity.eastmoney.f10.capitaloperation.t_eastmoney_project_progress;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2019-01-24 11:48:31
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "资本运作")
@Data
public class CapitalOperation {
    private List<t_eastmoney_capital_from> CapitalFrom;
    private List<t_eastmoney_project_progress> ProjectProgress;
}