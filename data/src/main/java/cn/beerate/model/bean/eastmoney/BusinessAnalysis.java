package cn.beerate.model.bean.eastmoney;

import cn.beerate.model.bean.eastmoney.businessanalysis.Jyps;
import cn.beerate.model.bean.eastmoney.businessanalysis.Zyfw;
import cn.beerate.model.bean.eastmoney.businessanalysis.Zygcfx;
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
