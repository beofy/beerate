/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean;
import cn.beerate.model.bean.companybignews.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Auto-generated: 2019-01-22 17:37:49
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "公司大事")
public class CompanyBigNews {
    @ApiModelProperty(value = "大事提醒")
    private List<String> dstx;
    private List<Gqzy> gqzy;
    private List<Dwdb> dwdb;
    private List<Sszc> sszc;
    private List<Wgcl> wgcl;
    private List<Xsjj> xsjj;
    private List<Sdgdcgbd> sdgdcgbd;
    private List<Ggcgbd> ggcgbd;
    private List<Dzjy> dzjy;
    private List<Rzrq> rzrq;
    private List<Lhbd> lhbd;

    public void setDstx(List<String> dstx) {
         this.dstx = dstx;
     }
     public List<String> getDstx() {
         return dstx;
     }

    public void setGqzy(List<Gqzy> gqzy) {
         this.gqzy = gqzy;
     }
     public List<Gqzy> getGqzy() {
         return gqzy;
     }

    public void setDwdb(List<Dwdb> dwdb) {
         this.dwdb = dwdb;
     }
     public List<Dwdb> getDwdb() {
         return dwdb;
     }

    public void setSszc(List<Sszc> sszc) {
         this.sszc = sszc;
     }
     public List<Sszc> getSszc() {
         return sszc;
     }

    public void setWgcl(List<Wgcl> wgcl) {
         this.wgcl = wgcl;
     }
     public List<Wgcl> getWgcl() {
         return wgcl;
     }

    public void setXsjj(List<Xsjj> xsjj) {
         this.xsjj = xsjj;
     }
     public List<Xsjj> getXsjj() {
         return xsjj;
     }

    public void setSdgdcgbd(List<Sdgdcgbd> sdgdcgbd) {
         this.sdgdcgbd = sdgdcgbd;
     }
     public List<Sdgdcgbd> getSdgdcgbd() {
         return sdgdcgbd;
     }

    public void setGgcgbd(List<Ggcgbd> ggcgbd) {
         this.ggcgbd = ggcgbd;
     }
     public List<Ggcgbd> getGgcgbd() {
         return ggcgbd;
     }

    public void setDzjy(List<Dzjy> dzjy) {
         this.dzjy = dzjy;
     }
     public List<Dzjy> getDzjy() {
         return dzjy;
     }

    public void setRzrq(List<Rzrq> rzrq) {
         this.rzrq = rzrq;
     }
     public List<Rzrq> getRzrq() {
         return rzrq;
     }

    public void setLhbd(List<Lhbd> lhbd) {
         this.lhbd = lhbd;
     }
     public List<Lhbd> getLhbd() {
         return lhbd;
     }

}