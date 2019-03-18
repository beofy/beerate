package cn.beerate.model.bean.eastmoney.f10;

import cn.beerate.model.entity.eastmoney.f10.businessanalysis.t_eastmoney_jyps;
import cn.beerate.model.entity.eastmoney.f10.businessanalysis.t_eastmoney_zyfw;
import cn.beerate.model.entity.eastmoney.f10.businessanalysis.t_eastmoney_zygcfx;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class BusinessAnalysis {
    private List<t_eastmoney_zyfw> zyfw;
    private List<t_eastmoney_jyps> jyps;
    private List<t_eastmoney_zygcfx> zygcfx;
}
