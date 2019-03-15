package cn.beerate.model.entity.eastmoney.f10.shareholderresearch;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@ApiModel(description = "基金持股")
@Setter
@Getter
@Entity
public class t_eastmoney_jjcg  extends Model {

    @ApiModelProperty(value = "股票代码")
    private String code;

    @ApiModelProperty("日期")
    private String rq;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "jjcg_id")
    private List<t_eastmoney_jjcg_detail> jjcg;

}