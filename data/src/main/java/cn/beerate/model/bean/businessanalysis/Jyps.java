package cn.beerate.model.bean.businessanalysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "经营评述")
@NoArgsConstructor
@Data
public class Jyps {

    @ApiModelProperty("股票代码")
    private String gpdm;

    @ApiModelProperty("日期")
    private String rq;

    @ApiModelProperty("描述")
    private String ms;

}
