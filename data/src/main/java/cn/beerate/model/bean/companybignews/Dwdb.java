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
@ApiModel(description = "对外担保")
public class Dwdb {

    @ApiModelProperty(value = "公告日期")
    private Date ggrq;

    @ApiModelProperty(value = "担保方")
    private String dbf;

    @ApiModelProperty(value = "被担保方")
    private String bdbf;

    @ApiModelProperty(value = "担保方式")
    private String dbfs;

    @ApiModelProperty(value = "担保金额(万元)")
    private String dbje;

    @ApiModelProperty(value = "币种")
    private String bz;

    @ApiModelProperty(value = "担保期限(年)")
    private String dbqx;

    @ApiModelProperty(value = "担保起始日")
    private String dbqsr;

    @ApiModelProperty(value = "担保终止日")
    private String dbzzr;

    @ApiModelProperty(value = "是否履行完毕")
    private String sflxwb;

    @ApiModelProperty(value = "是否关联交易")
    private String sfgljy;

    @ApiModelProperty(value = "交易日期")
    private String jyrq;

    @ApiModelProperty(value = "担保事件说明")
    private String dbsjsm;

    @ApiModelProperty(value = "报告期")
    private String bgq;

    @ApiModelProperty(value = "报告期类别")
    private String bgqlb;

    public void setGgrq(Date ggrq) {
         this.ggrq = ggrq;
     }
     public Date getGgrq() {
         return ggrq;
     }

    public void setDbf(String dbf) {
         this.dbf = dbf;
     }
     public String getDbf() {
         return dbf;
     }

    public void setBdbf(String bdbf) {
         this.bdbf = bdbf;
     }
     public String getBdbf() {
         return bdbf;
     }

    public void setDbfs(String dbfs) {
         this.dbfs = dbfs;
     }
     public String getDbfs() {
         return dbfs;
     }

    public void setDbje(String dbje) {
         this.dbje = dbje;
     }
     public String getDbje() {
         return dbje;
     }

    public void setBz(String bz) {
         this.bz = bz;
     }
     public String getBz() {
         return bz;
     }

    public void setDbqx(String dbqx) {
         this.dbqx = dbqx;
     }
     public String getDbqx() {
         return dbqx;
     }

    public void setDbqsr(String dbqsr) {
         this.dbqsr = dbqsr;
     }
     public String getDbqsr() {
         return dbqsr;
     }

    public void setDbzzr(String dbzzr) {
         this.dbzzr = dbzzr;
     }
     public String getDbzzr() {
         return dbzzr;
     }

    public void setSflxwb(String sflxwb) {
         this.sflxwb = sflxwb;
     }
     public String getSflxwb() {
         return sflxwb;
     }

    public void setSfgljy(String sfgljy) {
         this.sfgljy = sfgljy;
     }
     public String getSfgljy() {
         return sfgljy;
     }

    public void setJyrq(String jyrq) {
         this.jyrq = jyrq;
     }
     public String getJyrq() {
         return jyrq;
     }

    public void setDbsjsm(String dbsjsm) {
         this.dbsjsm = dbsjsm;
     }
     public String getDbsjsm() {
         return dbsjsm;
     }

    public void setBgq(String bgq) {
         this.bgq = bgq;
     }
     public String getBgq() {
         return bgq;
     }

    public void setBgqlb(String bgqlb) {
         this.bgqlb = bgqlb;
     }
     public String getBgqlb() {
         return bgqlb;
     }

}