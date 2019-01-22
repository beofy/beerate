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
@ApiModel(description = "股票质押")
public class Gqzy {

    @ApiModelProperty(value = "公告日期")
    private Date ggrq;

    @ApiModelProperty(value = "公告名称")
    private String gdmc;

    @ApiModelProperty(value = "质押方")
    private String zyf;

    @ApiModelProperty(value = "是否质押式回购 1-是 2-否")
    private String zyshg;

    @ApiModelProperty(value = " 质押股数(万股)")
    private String zygs;

    @ApiModelProperty(value = " 占总股本比例(%))")
    private Date zzgbbl;

    @ApiModelProperty(value = " 占股东持股比例(%)")
    private String zgdcgbl;

    @ApiModelProperty(value = "质押起始日")
    private Date zyqsr;

    @ApiModelProperty(value = "质押截止日")
    private Date zyjzr;

    @ApiModelProperty(value = " 解押日期")
    private Date jyrq;

    public void setGgrq(Date ggrq) {
         this.ggrq = ggrq;
     }
     public Date getGgrq() {
         return ggrq;
     }

    public void setGdmc(String gdmc) {
         this.gdmc = gdmc;
     }
     public String getGdmc() {
         return gdmc;
     }

    public void setZyf(String zyf) {
         this.zyf = zyf;
     }
     public String getZyf() {
         return zyf;
     }

    public void setZyshg(String zyshg) {
         this.zyshg = zyshg;
     }
     public String getZyshg() {
         return zyshg;
     }

    public void setZygs(String zygs) {
         this.zygs = zygs;
     }
     public String getZygs() {
         return zygs;
     }

    public void setZzgbbl(Date zzgbbl) {
         this.zzgbbl = zzgbbl;
     }
     public Date getZzgbbl() {
         return zzgbbl;
     }

    public void setZgdcgbl(String zgdcgbl) {
         this.zgdcgbl = zgdcgbl;
     }
     public String getZgdcgbl() {
         return zgdcgbl;
     }

    public void setZyqsr(Date zyqsr) {
         this.zyqsr = zyqsr;
     }
     public Date getZyqsr() {
         return zyqsr;
     }

    public void setZyjzr(Date zyjzr) {
         this.zyjzr = zyjzr;
     }
     public Date getZyjzr() {
         return zyjzr;
     }

    public void setJyrq(Date jyrq) {
         this.jyrq = jyrq;
     }
     public Date getJyrq() {
         return jyrq;
     }

}