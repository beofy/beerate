package cn.beerate.model.bean.eastmoney.newfinanceanalysis;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel(description = "占比")
@NoArgsConstructor
@Data
public class Zb {
    private ZbDetail zb;
    private String qylx;
    private String type;
    private List<Lr> lr0;
    private List<Lr> lr1;
    private List<Lr> lr2;
    private List<Lr> lr3;
}
