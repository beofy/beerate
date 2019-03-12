package cn.beerate.model.entity.eastmoney.f10.capitalstockstructure;

import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;

@ApiModel(description = "历年股本变动")
@Setter
@Getter
@Entity
@NoArgsConstructor
public class t_eastmoney_share_change extends Model {

    public t_eastmoney_share_change(String code, String rq, String zgb, String ltsxgf, String gyfrcg, String qtnzcg, String yltgf, String yssltAg, String bdyy) {
        this.code = code;
        this.rq = rq;
        this.zgb = zgb;
        this.ltsxgf = ltsxgf;
        this.gyfrcg = gyfrcg;
        this.qtnzcg = qtnzcg;
        this.yltgf = yltgf;
        this.yssltAg = yssltAg;
        this.bdyy = bdyy;
    }

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty(value = "日期")
    private String rq;

    @ApiModelProperty(value = "总股本")
    private String zgb;

    @ApiModelProperty(value = "流通受限股份")
    private String ltsxgf;

    @ApiModelProperty(value = "国有法人持股(受限)")
    private String gyfrcg;

    @ApiModelProperty(value = "其他内资持股(受限)")
    private String qtnzcg;

    @ApiModelProperty(value = "已流通股份")
    private String yltgf;

    @ApiModelProperty(value = "已上市流通A股")
    private String yssltAg;

    @ApiModelProperty(value = "变动原因")
    private String bdyy;
}
