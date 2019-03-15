
package cn.beerate.model.bean.eastmoney.f10;
import cn.beerate.model.entity.eastmoney.f10.companybignews.t_eastmoney_sdgdcgbd;
import cn.beerate.model.entity.eastmoney.f10.companybignews.t_eastmoney_xsjj;
import cn.beerate.model.entity.eastmoney.f10.shareholderresearch.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@ApiModel(description = "股东研究")
@Data
public class ShareholderResearch {

    private List<t_eastmoney_gdrs> gdrs;

    private List<t_eastmoney_sdltgd> sdltgd;

    private List<t_eastmoney_sdgd> sdgd;

    private List<t_eastmoney_jjcg> jjcg;

    private List<t_eastmoney_sdgdcgbd> sdgdcgbd;

    private List<t_eastmoney_xsjj> xsjj;

    private List<t_eastmoney_sdltgd_chart> sdltgd_chart;

    private List<t_eastmoney_zlcc> zlcc;

    @ApiModelProperty(value = "机构持仓日期")
    private List<String> zlcc_rz;

    private t_eastmoney_kggx kggx;
}