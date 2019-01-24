/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.shareholderresearch;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2019-01-24 14:51:13
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "基金持股")
@Data
public class Jjcg {

    @ApiModelProperty("日期")
    private String rq;

    private List<JjcgDetail> jjcg;

}