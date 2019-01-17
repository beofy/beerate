package cn.beerate.model.entity.stock;

import cn.beerate.model.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 研究报告
 */
@Entity
@org.hibernate.annotations.Table(appliesTo = "t_research_report",comment="研究报告")
public class t_research_report extends Model {

    @Column(columnDefinition = " varchar(8) DEFAULT NULL COMMENT '股票代码'")
    private String stockCode;

    @Column(columnDefinition = " TEXT COMMENT '公司研报' ")
    private String gsyb;

    @Column(columnDefinition = " TEXT COMMENT '行业研报' ")
    private String hyyb;

    @Column(columnDefinition = " TEXT COMMENT '研报摘要' ")
    private String  ybzy;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getGsyb() {
        return gsyb;
    }

    public void setGsyb(String gsyb) {
        this.gsyb = gsyb;
    }

    public String getHyyb() {
        return hyyb;
    }

    public void setHyyb(String hyyb) {
        this.hyyb = hyyb;
    }

    public String getYbzy() {
        return ybzy;
    }

    public void setYbzy(String ybzy) {
        this.ybzy = ybzy;
    }
}
