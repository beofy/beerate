package cn.beerate.model.bean.eastmoney.f10;
import cn.beerate.model.entity.eastmoney.f10.companymanagement.t_eastmoney_rpt_manager;
import cn.beerate.model.entity.eastmoney.f10.companymanagement.t_eastmoney_rpt_shareheld_change;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@ApiModel(description = "公司高管")
@Data
public class CompanyManagement {
    private List<t_eastmoney_rpt_manager> RptManagerList;
    private List<t_eastmoney_rpt_shareheld_change> RptShareHeldChangeList;
}