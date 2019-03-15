package cn.beerate.model.entity.eastmoney.f10.shareholderresearch;

import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@ApiModel(description = "十大股东列表")
@Setter
@Getter
@Entity
public class t_eastmoney_sdgd_detail  extends Model {

    @ApiModelProperty("变动比例")
    private String bdbl;

    @ApiModelProperty("持股数(股)")
    private String  cgs;

    @ApiModelProperty("股东名称")
    private String gdmc;

    @ApiModelProperty("股份类型")
    private String  gflx;

    @ApiModelProperty("名次")
    private String  mc;

    @ApiModelProperty("日期")
    private String   rq;

    @ApiModelProperty("持股数(股)")
    private String  zj;

    @ApiModelProperty("占总股本持股比例")
    private String   zltgbcgbl;

}
