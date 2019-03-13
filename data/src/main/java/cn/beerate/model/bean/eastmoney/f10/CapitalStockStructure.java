package cn.beerate.model.bean.eastmoney.f10;

import cn.beerate.model.entity.eastmoney.f10.capitalstockstructure.t_eastmoney_capital_stock_structure_detail;
import cn.beerate.model.entity.eastmoney.f10.capitalstockstructure.t_eastmoney_share_change;
import cn.beerate.model.entity.eastmoney.f10.capitalstockstructure.t_eastmoney_unlisted_share;
import cn.beerate.model.entity.eastmoney.f10.companybignews.t_eastmoney_xsjj;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@ApiModel(description = "股本结构")
@Data
public class CapitalStockStructure {

    private List<t_eastmoney_xsjj> RptRestrictedBanList;

    private t_eastmoney_capital_stock_structure_detail CapitalStockStructureDetail;

    private List<ShareChangeList> ShareChangeList;

    private List<UnlistedShareChangeList> UnlistedShareChangeList;

    private List<t_eastmoney_share_change> shareChange;

    private List<t_eastmoney_unlisted_share> unlistedShare;

}