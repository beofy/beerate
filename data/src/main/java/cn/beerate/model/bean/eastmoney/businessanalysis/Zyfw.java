package cn.beerate.model.bean.eastmoney.businessanalysis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "主营范围 ")
@NoArgsConstructor
@Data
public class Zyfw {

    @ApiModelProperty("日期")
    private String rq;

    @ApiModelProperty("描述")
    private String ms;

}
