package cn.beerate.model.entity.eastmoney.f10.businessanalysis;

import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@ApiModel(description = "经营评述")
@NoArgsConstructor
@Setter
@Getter
@Entity
public class t_eastmoney_jyps extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty("日期")
    private String rq;

    @ApiModelProperty("描述")
    @Column(columnDefinition = "TEXT")
    private String ms;

}
