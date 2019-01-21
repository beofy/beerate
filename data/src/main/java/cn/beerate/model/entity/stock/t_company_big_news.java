package cn.beerate.model.entity.stock;

import cn.beerate.model.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 公司大事
 */
@Entity
@org.hibernate.annotations.Table(appliesTo = "t_company_big_news",comment="公司大事")
public class t_company_big_news extends Model {

    @Column(columnDefinition = " varchar(8) DEFAULT NULL COMMENT '股票代码'")
    private String stockCode;

    @Column(columnDefinition = " TEXT COMMENT '大事提醒'")
    private String  dstx;

    @Column(columnDefinition = " TEXT COMMENT '对外担保'")
    private String  dwdb;

    @Column(columnDefinition = " TEXT COMMENT '股权质押'")
    private String  gqzy;

    @Column(columnDefinition = " TEXT COMMENT '诉讼仲裁'")
    private String  sszc;

    @Column(columnDefinition = " MEDIUMTEXT COMMENT '违规处理'")
    private String  wgcl;

    @Column(columnDefinition = " TEXT COMMENT '大宗交易'")
    private String dzjy;

    @Column(columnDefinition = " TEXT COMMENT '高管持股变动'")
    private String ggcgbd;

    @Column(columnDefinition = " TEXT COMMENT '龙虎榜单'")
    private String lhbd;

    @Column(columnDefinition = " TEXT COMMENT '融资融券'")
    private String  rzrq;

    @Column(columnDefinition = " TEXT COMMENT '十大股东持股变动'")
    private String  sdgdcgbd;

    @Column(columnDefinition = " TEXT COMMENT '限售解禁'")
    private String  xsjj;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getDstx() {
        return dstx;
    }

    public void setDstx(String dstx) {
        this.dstx = dstx;
    }

    public String getDwdb() {
        return dwdb;
    }

    public void setDwdb(String dwdb) {
        this.dwdb = dwdb;
    }

    public String getGqzy() {
        return gqzy;
    }

    public void setGqzy(String gqzy) {
        this.gqzy = gqzy;
    }

    public String getSszc() {
        return sszc;
    }

    public void setSszc(String sszc) {
        this.sszc = sszc;
    }

    public String getWgcl() {
        return wgcl;
    }

    public void setWgcl(String wgcl) {
        this.wgcl = wgcl;
    }

    public String getDzjy() {
        return dzjy;
    }

    public void setDzjy(String dzjy) {
        this.dzjy = dzjy;
    }

    public String getGgcgbd() {
        return ggcgbd;
    }

    public void setGgcgbd(String ggcgbd) {
        this.ggcgbd = ggcgbd;
    }

    public String getLhbd() {
        return lhbd;
    }

    public void setLhbd(String lhbd) {
        this.lhbd = lhbd;
    }

    public String getRzrq() {
        return rzrq;
    }

    public void setRzrq(String rzrq) {
        this.rzrq = rzrq;
    }

    public String getSdgdcgbd() {
        return sdgdcgbd;
    }

    public void setSdgdcgbd(String sdgdcgbd) {
        this.sdgdcgbd = sdgdcgbd;
    }

    public String getXsjj() {
        return xsjj;
    }

    public void setXsjj(String xsjj) {
        this.xsjj = xsjj;
    }
}
