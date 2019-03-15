package cn.beerate.model.entity.eastmoney.f10.shareholderresearch;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@ApiModel(description = "基金持股列表")
@Setter
@Getter
@Entity
public class t_eastmoney_jjcg_detail{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jjcg_detail_id;

    @Column(columnDefinition = "timestamp NULL DEFAULT CURRENT_TIMESTAMP")
    private Date createTime=new Date();

    private Date updateTime;

    @ApiModelProperty("持股数(股)")
    private String cgs;

    @ApiModelProperty("持仓市值(元)")
    private String cgsz;

    private String id;

    @ApiModelProperty("基金代码")
    private String jjdm;

    @ApiModelProperty("基金名称")
    private String jjmc;

    @Column(name = "_order")
    private String order;

    @ApiModelProperty("占净值比")
    private String zjzb;

    @ApiModelProperty("占流通比")
    private String zltb;

    @ApiModelProperty("占总股本比")
    private String zzgbb;
}
