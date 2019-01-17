package cn.beerate.model.entity.stock;

import cn.beerate.model.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@org.hibernate.annotations.Table(appliesTo = "t_operations_required",comment="操盘必读")
public class t_operations_required extends Model {
    @Column(columnDefinition = "TEXT COMMENT '大事提醒' ")
    private String dstx;

    @Column(columnDefinition = " TEXT COMMENT '限售解禁' ")
    private String xsjj;

    @Column(columnDefinition = "TEXT COMMENT '核心题材' ")
    private String hxtc;

    @Column(columnDefinition = "TEXT COMMENT '公司新闻' ")
    private String ggxx;

    @Column(columnDefinition = "TEXT COMMENT '公司公告' ")
    private String gggg;

    @Column(columnDefinition = "TEXT COMMENT '大宗交易' ")
    private String dzjy;

    @Column(columnDefinition = "TEXT COMMENT '融资融券' ")
    private String rzrq;

    @Column(columnDefinition = "TEXT COMMENT '龙虎榜单' ")
    private String lhbd;

    @Column(columnDefinition = "TEXT COMMENT '股东分析' ")
    private String gdrs;

    @Column(columnDefinition = "TEXT COMMENT '主要指标-按报告期' ")
    private String zyzb_abgq;

    @Column(columnDefinition = "TEXT COMMENT '主要指标-按年度' ")
    private String zyzb_and;

    @Column(columnDefinition = "TEXT COMMENT '主要指标-按季度' ")
    private String zyzb_adjd;

    @Column(columnDefinition = "TEXT COMMENT '最新指标1' ")
    private String zxzb1;

    @Column(columnDefinition = "TEXT COMMENT '最新指标2' ")
    private String zxzb2;

    @Column(columnDefinition = "TEXT COMMENT '机构预测' ")
    private String jgyc;

    private String BaseYear;

    /**
     * "2017A", mgsy: "1.35", mgsyzz: "2.61" <br>
     * mgsy 每股收益 <br>
     * mgsyzz 每股收益增长
     */
    @Column(columnDefinition = "TEXT COMMENT '机构预测图' ")
    private String jgyc_pic;

    @Column(columnDefinition = "TEXT COMMENT '曾用名' ")
    private String cym;

    @Column(columnDefinition = "TEXT COMMENT '研报摘要' ")
    private String ggyb;

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
