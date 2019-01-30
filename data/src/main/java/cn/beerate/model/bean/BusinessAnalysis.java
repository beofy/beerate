package cn.beerate.model.bean;

import cn.beerate.model.bean.businessanalysis.Jyps;
import cn.beerate.model.bean.businessanalysis.Zyfw;
import cn.beerate.model.bean.businessanalysis.Zygcfx;
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
