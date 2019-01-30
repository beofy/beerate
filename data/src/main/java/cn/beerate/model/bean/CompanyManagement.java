/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean;
import cn.beerate.model.bean.companymanagement.RptManagerList;
import cn.beerate.model.bean.companymanagement.RptShareHeldChangeList;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2019-01-24 11:1:15
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "公司高管")
@Data
public class CompanyManagement {
    private List<RptManagerList> RptManagerList;
    private List<RptShareHeldChangeList> RptShareHeldChangeList;
}