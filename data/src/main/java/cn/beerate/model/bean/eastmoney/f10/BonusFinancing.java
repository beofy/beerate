package cn.beerate.model.bean.eastmoney.f10;
import cn.beerate.model.entity.eastmoney.f10.bonusfinancing.t_eastmoney_fhyx;
import cn.beerate.model.entity.eastmoney.f10.bonusfinancing.t_eastmoney_lnfhrz;
import cn.beerate.model.entity.eastmoney.f10.bonusfinancing.t_eastmoney_pgmx;
import cn.beerate.model.entity.eastmoney.f10.bonusfinancing.t_eastmoney_zfmx;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@ApiModel(description = "分红融资")
@Data
public class BonusFinancing {
    private List<t_eastmoney_fhyx> fhyx;
    private List<t_eastmoney_lnfhrz> lnfhrz;
    private List<t_eastmoney_zfmx> zfmx;
    private List<t_eastmoney_pgmx> pgmx;
}