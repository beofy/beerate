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
@ApiModel(description = "违规处理")
public class Wgcl {
    @ApiModelProperty(value = "公告日期")
    private Date ggrq;

    @ApiModelProperty(value = "类型")
    private String lx;

    @ApiModelProperty(value = "处罚对象")
    private String cfdx;

    @ApiModelProperty(value = "违规行为")
    private String wgxw;

    @ApiModelProperty(value = "处分类型")
    private String cflx;

    @ApiModelProperty(value = "处分措施")
    private String cfcs;

    @ApiModelProperty(value = "处理人")
    private String clr;

    @ApiModelProperty(value = "处罚金额(万元)")
    private String cfje;

    public void setGgrq(Date ggrq) {
         this.ggrq = ggrq;
     }
     public Date getGgrq() {
         return ggrq;
     }

    public void setLx(String lx) {
         this.lx = lx;
     }
     public String getLx() {
         return lx;
     }

    public void setCfdx(String cfdx) {
         this.cfdx = cfdx;
     }
     public String getCfdx() {
         return cfdx;
     }

    public void setWgxw(String wgxw) {
         this.wgxw = wgxw;
     }
     public String getWgxw() {
         return wgxw;
     }

    public void setCflx(String cflx) {
         this.cflx = cflx;
     }
     public String getCflx() {
         return cflx;
     }

    public void setCfcs(String cfcs) {
         this.cfcs = cfcs;
     }
     public String getCfcs() {
         return cfcs;
     }

    public void setClr(String clr) {
         this.clr = clr;
     }
     public String getClr() {
         return clr;
     }

    public void setCfje(String cfje) {
         this.cfje = cfje;
     }
     public String getCfje() {
         return cfje;
     }

}