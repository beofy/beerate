package cn.beerate.model.bean.eastmoney.f10;
import cn.beerate.model.Model;
import cn.beerate.model.entity.eastmoney.f10.companybignews.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@ApiModel(description = "公司大事")
@Setter
@Getter
public class CompanyBigNews{
    @ApiModelProperty(value = "大事提醒")
    private List<String> dstx;

    private List<t_eastmoney_gqzy> gqzy;

    private List<t_eastmoney_dwdb> dwdb;

    private List<t_eastmoney_sszc> sszc;

    private List<t_eastmoney_wgcl> wgcl;

    private List<t_eastmoney_xsjj> xsjj;

    private List<t_eastmoney_sdgdcgbd> sdgdcgbd;

    private List<t_eastmoney_ggcgbd> ggcgbd;

    private List<t_eastmoney_dzjy> dzjy;

    private List<t_eastmoney_rzrq> rzrq;

    private List<t_eastmoney_lhbd> lhbd;
}