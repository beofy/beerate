package cn.beerate.model.bean.eastmoney.newfinanceanalysis;

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
    private List<Dubang> bgq;

    @ApiModelProperty("年度")
    private List<Dubang> nd;

}
