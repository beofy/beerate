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
@ApiModel(description = "诉讼仲裁")
public class Sszc {
    @ApiModelProperty(value = "公告日期")
    private Date ggrq;

    @ApiModelProperty(value = "案件名称")
    private String ajmc;

    @ApiModelProperty(value = "案件简介")
    private String ajjj;

    @ApiModelProperty(value = "原告方")
    private String ygf;

    @ApiModelProperty(value = "被告方")
    private String bgf;

    @ApiModelProperty(value = "诉讼类型")
    private String sslx;

    @ApiModelProperty(value = "涉案金额(万元)")
    private String saje;

    @ApiModelProperty(value = "币种")
    private String bz;

    @ApiModelProperty(value = "一审_起诉日期")
    private String ysqsrq;

    @ApiModelProperty(value = "一审_受理法院")
    private String ysslfy;

    @ApiModelProperty(value = "一审_判决日期")
    private String yspjrq;

    @ApiModelProperty(value = "一审_判决内容")
    private String yspjnr;

    @ApiModelProperty(value = "一审_是否上诉")
    private String yssfss;

    @ApiModelProperty(value = "二审_上诉方")
    private String esssf;

    @ApiModelProperty(value = "二审_受理法院")
    private String esslfy;

    @ApiModelProperty(value = "二审_判决日期")
    private String espjrq;

    @ApiModelProperty(value = "一审_判决内容")
    private String espjnr;

    @ApiModelProperty(value = "执行情况")
    private String zxqk;

    public void setGgrq(Date ggrq) {
         this.ggrq = ggrq;
     }
     public Date getGgrq() {
         return ggrq;
     }

    public void setAjmc(String ajmc) {
         this.ajmc = ajmc;
     }
     public String getAjmc() {
         return ajmc;
     }

    public void setAjjj(String ajjj) {
         this.ajjj = ajjj;
     }
     public String getAjjj() {
         return ajjj;
     }

    public void setYgf(String ygf) {
         this.ygf = ygf;
     }
     public String getYgf() {
         return ygf;
     }

    public void setBgf(String bgf) {
         this.bgf = bgf;
     }
     public String getBgf() {
         return bgf;
     }

    public void setSslx(String sslx) {
         this.sslx = sslx;
     }
     public String getSslx() {
         return sslx;
     }

    public void setSaje(String saje) {
         this.saje = saje;
     }
     public String getSaje() {
         return saje;
     }

    public void setBz(String bz) {
         this.bz = bz;
     }
     public String getBz() {
         return bz;
     }

    public void setYsqsrq(String ysqsrq) {
         this.ysqsrq = ysqsrq;
     }
     public String getYsqsrq() {
         return ysqsrq;
     }

    public void setYsslfy(String ysslfy) {
         this.ysslfy = ysslfy;
     }
     public String getYsslfy() {
         return ysslfy;
     }

    public void setYspjrq(String yspjrq) {
         this.yspjrq = yspjrq;
     }
     public String getYspjrq() {
         return yspjrq;
     }

    public void setYspjnr(String yspjnr) {
         this.yspjnr = yspjnr;
     }
     public String getYspjnr() {
         return yspjnr;
     }

    public void setYssfss(String yssfss) {
         this.yssfss = yssfss;
     }
     public String getYssfss() {
         return yssfss;
     }

    public void setEsssf(String esssf) {
         this.esssf = esssf;
     }
     public String getEsssf() {
         return esssf;
     }

    public void setEsslfy(String esslfy) {
         this.esslfy = esslfy;
     }
     public String getEsslfy() {
         return esslfy;
     }

    public void setEspjrq(String espjrq) {
         this.espjrq = espjrq;
     }
     public String getEspjrq() {
         return espjrq;
     }

    public void setEspjnr(String espjnr) {
         this.espjnr = espjnr;
     }
     public String getEspjnr() {
         return espjnr;
     }

    public void setZxqk(String zxqk) {
         this.zxqk = zxqk;
     }
     public String getZxqk() {
         return zxqk;
     }

}