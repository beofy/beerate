package cn.beerate.model.bean.eastmoney.newfinanceanalysis;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "占比")
@NoArgsConstructor
@Data
public class Zb {
    private ZbDetail zb;
}
