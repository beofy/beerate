/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney;
import cn.beerate.model.bean.eastmoney.capitalstockstructure.CapitalStockStructureDetail;
import cn.beerate.model.bean.eastmoney.capitalstockstructure.RptRestrictedBanList;
import cn.beerate.model.bean.eastmoney.capitalstockstructure.ShareChangeList;
import cn.beerate.model.bean.eastmoney.capitalstockstructure.UnlistedShareChangeList;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2019-01-23 17:32:21
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "股本结构")
@Data
public class CapitalStockStructure {
    private List<RptRestrictedBanList> RptRestrictedBanList;
    private CapitalStockStructureDetail CapitalStockStructureDetail;
    private List<ShareChangeList> ShareChangeList;
    private List<UnlistedShareChangeList> UnlistedShareChangeList;

}