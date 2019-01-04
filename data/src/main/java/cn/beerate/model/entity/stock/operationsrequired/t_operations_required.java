package cn.beerate.model.entity.stock.operationsrequired;

import cn.beerate.model.Model;
import cn.beerate.model.entity.stock.companysurvey.t_stock_info;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class t_operations_required extends Model {

    private String dstx;
    private String xsjj;
    private String hxtc;
    private String ggxx;
    private String gggg;
    private String dzjy;
    private String rzrq;
    private String lhbd;
    private String gdrs;
    private String zyzb_abgq;
    private String zyzb_and;
    private String zyzb_adjd;
    private String zxzb1;
    private String zxzb2;
    private String jgyc;
    private String BaseYear;
    private String jgyc_pic;
    private String cym;
    private String ggyb;

    @OneToOne(optional = false)
    @JoinColumn(name = "stock_info_id",unique = true)
    private t_stock_info stock_info;

    public t_stock_info getStock_info() {
        return stock_info;
    }

    public void setStock_info(t_stock_info stock_info) {
        this.stock_info = stock_info;
    }

    public String getDstx() {
        return dstx;
    }

    public void setDstx(String dstx) {
        this.dstx = dstx;
    }

    public String getXsjj() {
        return xsjj;
    }

    public void setXsjj(String xsjj) {
        this.xsjj = xsjj;
    }

    public String getHxtc() {
        return hxtc;
    }

    public void setHxtc(String hxtc) {
        this.hxtc = hxtc;
    }

    public String getGgxx() {
        return ggxx;
    }

    public void setGgxx(String ggxx) {
        this.ggxx = ggxx;
    }

    public String getGggg() {
        return gggg;
    }

    public void setGggg(String gggg) {
        this.gggg = gggg;
    }

    public String getDzjy() {
        return dzjy;
    }

    public void setDzjy(String dzjy) {
        this.dzjy = dzjy;
    }

    public String getRzrq() {
        return rzrq;
    }

    public void setRzrq(String rzrq) {
        this.rzrq = rzrq;
    }

    public String getLhbd() {
        return lhbd;
    }

    public void setLhbd(String lhbd) {
        this.lhbd = lhbd;
    }

    public String getGdrs() {
        return gdrs;
    }

    public void setGdrs(String gdrs) {
        this.gdrs = gdrs;
    }

    public String getZyzb_abgq() {
        return zyzb_abgq;
    }

    public void setZyzb_abgq(String zyzb_abgq) {
        this.zyzb_abgq = zyzb_abgq;
    }

    public String getZyzb_and() {
        return zyzb_and;
    }

    public void setZyzb_and(String zyzb_and) {
        this.zyzb_and = zyzb_and;
    }

    public String getZyzb_adjd() {
        return zyzb_adjd;
    }

    public void setZyzb_adjd(String zyzb_adjd) {
        this.zyzb_adjd = zyzb_adjd;
    }

    public String getZxzb1() {
        return zxzb1;
    }

    public void setZxzb1(String zxzb1) {
        this.zxzb1 = zxzb1;
    }

    public String getZxzb2() {
        return zxzb2;
    }

    public void setZxzb2(String zxzb2) {
        this.zxzb2 = zxzb2;
    }

    public String getJgyc() {
        return jgyc;
    }

    public void setJgyc(String jgyc) {
        this.jgyc = jgyc;
    }

    public String getBaseYear() {
        return BaseYear;
    }

    public void setBaseYear(String baseYear) {
        BaseYear = baseYear;
    }

    public String getJgyc_pic() {
        return jgyc_pic;
    }

    public void setJgyc_pic(String jgyc_pic) {
        this.jgyc_pic = jgyc_pic;
    }

    public String getCym() {
        return cym;
    }

    public void setCym(String cym) {
        this.cym = cym;
    }

    public String getGgyb() {
        return ggyb;
    }

    public void setGgyb(String ggyb) {
        this.ggyb = ggyb;
    }
}
