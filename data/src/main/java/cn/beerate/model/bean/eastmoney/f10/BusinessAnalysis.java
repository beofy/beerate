package cn.beerate.model.bean.eastmoney.f10;

import cn.beerate.model.bean.eastmoney.f10.businessanalysis.Jyps;
import cn.beerate.model.bean.eastmoney.f10.businessanalysis.Zyfw;
import cn.beerate.model.bean.eastmoney.f10.businessanalysis.Zygcfx;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class BusinessAnalysis {
    private List<Zyfw> zyfw;
    private List<Jyps> jyps;
    private List<Zygcfx> zygcfx;
}
