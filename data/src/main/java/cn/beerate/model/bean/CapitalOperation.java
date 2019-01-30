/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean;
import cn.beerate.model.bean.capitaloperation.CapitalFrom;
import cn.beerate.model.bean.capitaloperation.ProjectProgress;
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
    private List<CapitalFrom> CapitalFrom;
    private List<ProjectProgress> ProjectProgress;
}