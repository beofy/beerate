package cn.beerate.model.entity.eastmoney.f10.companybignews;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@ApiModel(description = "龙虎榜单")
@Setter
@Getter
@Entity
public class t_eastmoney_lhbd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lhbd_id;

    private Date createTime = new Date();

    private Date updateTime;

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "日期")
    private String rq;

    @ApiModelProperty(value = "总量")
    private String zl;

    @ApiModelProperty(value = "买入总计")
    private String mrzj;

    @ApiModelProperty(value = "卖入总计占金额比")
    private String mrzjzjeb;

    @ApiModelProperty(value = "卖出总计")
    private String mczj;

    @ApiModelProperty(value = "卖出总计占金额比")
    private String mczjzjeb;

    @OneToMany(mappedBy = "lhbd",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<t_eastmoney_group_mr> group_mr;

    @OneToMany(mappedBy = "lhbd",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<t_eastmoney_group_mc> group_mc;
}