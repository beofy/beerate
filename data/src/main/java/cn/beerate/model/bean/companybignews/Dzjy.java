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
@ApiModel(description = "大宗交易")
public class Dzjy {

    @ApiModelProperty(value = "交易日期")
    private Date jyrq;

    @ApiModelProperty(value = "成交价(元)")
    private String cjj;

    @ApiModelProperty(value = "成交量(股)")
    private String cjl;

    @ApiModelProperty(value = "成交金额(元)")
    private String cjje;

    @ApiModelProperty(value = "买入营业部")
    private String mryyb;

    @ApiModelProperty(value = "卖出营业部")
    private String mcyyb;

    public void setJyrq(Date jyrq) {
         this.jyrq = jyrq;
     }
     public Date getJyrq() {
         return jyrq;
     }

    public void setCjj(String cjj) {
         this.cjj = cjj;
     }
     public String getCjj() {
         return cjj;
     }

    public void setCjl(String cjl) {
         this.cjl = cjl;
     }
     public String getCjl() {
         return cjl;
     }

    public void setCjje(String cjje) {
         this.cjje = cjje;
     }
     public String getCjje() {
         return cjje;
     }

    public void setMryyb(String mryyb) {
         this.mryyb = mryyb;
     }
     public String getMryyb() {
         return mryyb;
     }

    public void setMcyyb(String mcyyb) {
         this.mcyyb = mcyyb;
     }
     public String getMcyyb() {
         return mcyyb;
     }

}