package cn.beerate.model.entity.eastmoney.f10.businessanalysis;

import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@ApiModel(description = "主营构成分析")
@NoArgsConstructor
@Setter
@Getter
@Entity
public class t_eastmoney_zygcfx extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty("日期")
    private String rq;

    @ApiModelProperty("行业")
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "zygcfx_hy_id")
    private List<t_eastmoney_fl> hy;

    @ApiModelProperty("地区")
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "zygcfx_qy_id")
    private List<t_eastmoney_fl> qy;

    @ApiModelProperty("产品")
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "zygcfx_cp_id")
    private List<t_eastmoney_fl> cp;

}
