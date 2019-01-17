package cn.beerate.model.entity.stock;

import cn.beerate.model.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 盈利预测
 */
@Entity
@org.hibernate.annotations.Table(appliesTo = "t_profit_forecast",comment="盈利预测")
public class t_profit_forecast extends Model {

    @Column(columnDefinition = " varchar(8) DEFAULT NULL COMMENT '股票代码'")
    private String stockCode;

    @Column(columnDefinition = " TEXT COMMENT '归属净利润' ")
    private String gsjlr;

    @Column(columnDefinition = " TEXT COMMENT '机构预测' ")
    private String jgyc;

    @Column(columnDefinition = " TEXT COMMENT '净资产收益率' ")
    private String jzcsyl;

    @Column(columnDefinition = " TEXT COMMENT '每股收益' ")
    private String mgsy;

    @Column(columnDefinition = " TEXT COMMENT '评级统计' ")
    private String pjtj;

    @Column(columnDefinition = " TEXT COMMENT '预测明细' ")
    private String ycmx;

    @Column(columnDefinition = " TEXT COMMENT '预测统计' ")
    private String yctj;

    @Column(columnDefinition = " TEXT COMMENT '营业收入' ")
    private String yysr;


    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getGsjlr() {
        return gsjlr;
    }

    public void setGsjlr(String gsjlr) {
        this.gsjlr = gsjlr;
    }

    public String getJgyc() {
        return jgyc;
    }

    public void setJgyc(String jgyc) {
        this.jgyc = jgyc;
    }

    public String getJzcsyl() {
        return jzcsyl;
    }

    public void setJzcsyl(String jzcsyl) {
        this.jzcsyl = jzcsyl;
    }

    public String getMgsy() {
        return mgsy;
    }

    public void setMgsy(String mgsy) {
        this.mgsy = mgsy;
    }

    public String getPjtj() {
        return pjtj;
    }

    public void setPjtj(String pjtj) {
        this.pjtj = pjtj;
    }

    public String getYcmx() {
        return ycmx;
    }

    public void setYcmx(String ycmx) {
        this.ycmx = ycmx;
    }

    public String getYctj() {
        return yctj;
    }

    public void setYctj(String yctj) {
        this.yctj = yctj;
    }

    public String getYysr() {
        return yysr;
    }

    public void setYysr(String yysr) {
        this.yysr = yysr;
    }
}
