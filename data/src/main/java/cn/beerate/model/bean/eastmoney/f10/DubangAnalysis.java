package cn.beerate.model.bean.eastmoney.f10;

import cn.beerate.model.entity.eastmoney.f10.newfinanceanalysis.t_eastmoney_dubang;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel(description = "杜邦分析")
@NoArgsConstructor
@Data
public class DubangAnalysis {

    @ApiModelProperty("报告期")
    private List<t_eastmoney_dubang> bgq;

    @ApiModelProperty("年度")
    private List<t_eastmoney_dubang> nd;

}
