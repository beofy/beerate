package cn.beerate.model.entity.stock;

import cn.beerate.model.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 同行比较
 */
@Entity
@org.hibernate.annotations.Table(appliesTo = "t_industry_analysis",comment="同行比较")
public class t_industry_analysis extends Model {

    @Column(columnDefinition = " varchar(8) DEFAULT NULL COMMENT '股票代码'")
    private String stockCode;

    @Column(columnDefinition = " TEXT COMMENT '成长性比较'")
    private String  czxbj;

    @Column(columnDefinition = " TEXT COMMENT '市场表现'")
    private String  dbfxbj;

    @Column(columnDefinition = " TEXT COMMENT '公司规模净利润'")
    private String   gsgmjlr;

    @Column(columnDefinition = " TEXT COMMENT '公司规模流通市值'")
    private String   gsgmltsz;

    @Column(columnDefinition = " TEXT COMMENT '公司规模营业收入'")
    private String  gsgmyysr;

    @Column(columnDefinition = " TEXT COMMENT '公司规模总收入'")
    private String  gsgmzsz;

    @Column(columnDefinition = " TEXT COMMENT '估值比较'")
    private String  gzbj;

    @Column(columnDefinition = " TEXT COMMENT '行业资讯'")
    private String hyzx;

    @Column(columnDefinition = " TEXT COMMENT '市场表现'")
    private String   scbx;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getCzxbj() {
        return czxbj;
    }

    public void setCzxbj(String czxbj) {
        this.czxbj = czxbj;
    }

    public String getDbfxbj() {
        return dbfxbj;
    }

    public void setDbfxbj(String dbfxbj) {
        this.dbfxbj = dbfxbj;
    }

    public String getGsgmjlr() {
        return gsgmjlr;
    }

    public void setGsgmjlr(String gsgmjlr) {
        this.gsgmjlr = gsgmjlr;
    }

    public String getGsgmltsz() {
        return gsgmltsz;
    }

    public void setGsgmltsz(String gsgmltsz) {
        this.gsgmltsz = gsgmltsz;
    }

    public String getGsgmyysr() {
        return gsgmyysr;
    }

    public void setGsgmyysr(String gsgmyysr) {
        this.gsgmyysr = gsgmyysr;
    }

    public String getGsgmzsz() {
        return gsgmzsz;
    }

    public void setGsgmzsz(String gsgmzsz) {
        this.gsgmzsz = gsgmzsz;
    }

    public String getGzbj() {
        return gzbj;
    }

    public void setGzbj(String gzbj) {
        this.gzbj = gzbj;
    }

    public String getHyzx() {
        return hyzx;
    }

    public void setHyzx(String hyzx) {
        this.hyzx = hyzx;
    }

    public String getScbx() {
        return scbx;
    }

    public void setScbx(String scbx) {
        this.scbx = scbx;
    }
}
