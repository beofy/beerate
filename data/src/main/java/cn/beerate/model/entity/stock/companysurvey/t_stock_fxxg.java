package cn.beerate.model.entity.stock.companysurvey;


import cn.beerate.model.Model;

import javax.persistence.*;

@Entity
@org.hibernate.annotations.Table(appliesTo = "t_stock_fxxg",comment="公司概况")
public class t_stock_fxxg extends Model {
    //"clrq": "1987-12-22",
    private String clrq;

    //"ssrq": "1991-04-03",
    private String ssrq;

    //"fxsyl": "--",
    private String fxsyl;

    //"wsfxrq": "1989-03-10",
    private String wsfxrq;

    //"fxfs": "其他发行方式",
    private String fxfs;

    //"mgmz": "20.00",
    private String mgmz;

    //"fxl": "67.5万",
    private String fxl;

    //"mgfxj": "40.00",
    private String mgfxj;

    //"fxfy": "--",
    private String fxfy;

    //"fxzsz": "2700万",
    private String fxzsz;

    //"mjzjje": "0",
    private String mjzjje;

    //"srkpj": "49.00",
    private String srkpj;

    //"srspj": "49.00",
    private String srspj;

    //"srhsl": "0.00%",
    private String srhsl;

    //"srzgj": "49.00",;
    private String srzgj;

    //"wxpszql": "--",
    private String wxpszql;

    //"djzql": "--"
    private String djzql;

    @OneToOne(optional = false)
    @JoinColumn(name="stock_info_id",unique = true)
    private t_stock_info stock_info;

    public String getClrq() {
        return clrq;
    }

    public void setClrq(String clrq) {
        this.clrq = clrq;
    }

    public String getSsrq() {
        return ssrq;
    }

    public void setSsrq(String ssrq) {
        this.ssrq = ssrq;
    }

    public String getFxsyl() {
        return fxsyl;
    }

    public void setFxsyl(String fxsyl) {
        this.fxsyl = fxsyl;
    }

    public String getWsfxrq() {
        return wsfxrq;
    }

    public void setWsfxrq(String wsfxrq) {
        this.wsfxrq = wsfxrq;
    }

    public String getFxfs() {
        return fxfs;
    }

    public void setFxfs(String fxfs) {
        this.fxfs = fxfs;
    }

    public String getMgmz() {
        return mgmz;
    }

    public void setMgmz(String mgmz) {
        this.mgmz = mgmz;
    }

    public String getFxl() {
        return fxl;
    }

    public void setFxl(String fxl) {
        this.fxl = fxl;
    }

    public String getMgfxj() {
        return mgfxj;
    }

    public void setMgfxj(String mgfxj) {
        this.mgfxj = mgfxj;
    }

    public String getFxfy() {
        return fxfy;
    }

    public void setFxfy(String fxfy) {
        this.fxfy = fxfy;
    }

    public String getFxzsz() {
        return fxzsz;
    }

    public void setFxzsz(String fxzsz) {
        this.fxzsz = fxzsz;
    }

    public String getMjzjje() {
        return mjzjje;
    }

    public void setMjzjje(String mjzjje) {
        this.mjzjje = mjzjje;
    }

    public String getSrkpj() {
        return srkpj;
    }

    public void setSrkpj(String srkpj) {
        this.srkpj = srkpj;
    }

    public String getSrspj() {
        return srspj;
    }

    public void setSrspj(String srspj) {
        this.srspj = srspj;
    }

    public String getSrhsl() {
        return srhsl;
    }

    public void setSrhsl(String srhsl) {
        this.srhsl = srhsl;
    }

    public String getSrzgj() {
        return srzgj;
    }

    public void setSrzgj(String srzgj) {
        this.srzgj = srzgj;
    }

    public String getWxpszql() {
        return wxpszql;
    }

    public void setWxpszql(String wxpszql) {
        this.wxpszql = wxpszql;
    }

    public String getDjzql() {
        return djzql;
    }

    public void setDjzql(String djzql) {
        this.djzql = djzql;
    }

    public t_stock_info getStock_info() {
        return stock_info;
    }

    public void setStock_info(t_stock_info stock_info) {
        this.stock_info = stock_info;
    }

    @Override
    public String toString() {
        return "t_stock_fxxg{" +
                "clrq='" + clrq + '\'' +
                ", ssrq='" + ssrq + '\'' +
                ", fxsyl='" + fxsyl + '\'' +
                ", wsfxrq='" + wsfxrq + '\'' +
                ", fxfs='" + fxfs + '\'' +
                ", mgmz='" + mgmz + '\'' +
                ", fxl='" + fxl + '\'' +
                ", mgfxj='" + mgfxj + '\'' +
                ", fxfy='" + fxfy + '\'' +
                ", fxzsz='" + fxzsz + '\'' +
                ", mjzjje='" + mjzjje + '\'' +
                ", srkpj='" + srkpj + '\'' +
                ", srspj='" + srspj + '\'' +
                ", srhsl='" + srhsl + '\'' +
                ", srzgj='" + srzgj + '\'' +
                ", wxpszql='" + wxpszql + '\'' +
                ", djzql='" + djzql + '\'' +
                '}';
    }
}
