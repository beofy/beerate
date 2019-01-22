/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.companybignews;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Auto-generated: 2019-01-22 17:37:49
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "限售解禁")
public class Xsjj {

    @ApiModelProperty(value = "解禁时间")
    private Date jjsj;

    @ApiModelProperty(value = "解禁数量(股)")
    private String jjsl;

    @ApiModelProperty(value = "解禁股占总股本比例")
    private String jjgzzgbbl;

    @ApiModelProperty(value = "解禁股占流通股本比例")
    private String jjgzltgbbl;

    @ApiModelProperty(value = "股票类型")
    private String gplx;

    public void setJjsj(Date jjsj) {
         this.jjsj = jjsj;
     }
     public Date getJjsj() {
         return jjsj;
     }

    public void setJjsl(String jjsl) {
         this.jjsl = jjsl;
     }
     public String getJjsl() {
         return jjsl;
     }

    public void setJjgzzgbbl(String jjgzzgbbl) {
         this.jjgzzgbbl = jjgzzgbbl;
     }
     public String getJjgzzgbbl() {
         return jjgzzgbbl;
     }

    public void setJjgzltgbbl(String jjgzltgbbl) {
         this.jjgzltgbbl = jjgzltgbbl;
     }
     public String getJjgzltgbbl() {
         return jjgzltgbbl;
     }

    public void setGplx(String gplx) {
         this.gplx = gplx;
     }
     public String getGplx() {
         return gplx;
     }

}