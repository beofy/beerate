package cn.beerate.model.bean.eastmoney.f10;

import cn.beerate.model.entity.eastmoney.f10.newfinanceanalysis.t_eastmoney_lr;
import cn.beerate.model.entity.eastmoney.f10.newfinanceanalysis.t_eastmoney_zb_detail;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel(description = "占比")
@NoArgsConstructor
@Data
public class Zb {
    private t_eastmoney_zb_detail zb;
    private String qylx;
    private String type;
    private List<t_eastmoney_lr> lr0;
    private List<t_eastmoney_lr> lr1;
    private List<t_eastmoney_lr> lr2;
    private List<t_eastmoney_lr> lr3;
}
