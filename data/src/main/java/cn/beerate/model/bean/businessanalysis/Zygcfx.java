package cn.beerate.model.bean.businessanalysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel(description = "主营构成分析")
@NoArgsConstructor
@Data
public class Zygcfx {

    @ApiModelProperty("日期")
    private String rq;

    @ApiModelProperty("行业")
    private List<Fl> hy;

    @ApiModelProperty("地区")
    private List<Fl> qy;

    @ApiModelProperty("产品")
    private List<Fl> cp;

}
