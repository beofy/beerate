package cn.beerate.model.entity.stock;

import cn.beerate.model.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 新闻公告
 */
@Entity
public class t_news_bulletin extends Model {
    @Column(columnDefinition = " varchar(8) DEFAULT NULL COMMENT '股票代码'")
    private String stockCode;

    @Column(columnDefinition = " TEXT COMMENT '公司公告' ")
    private String gggg;

    @Column(columnDefinition = " TEXT COMMENT '公司新闻' ")
    private String ggxx;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getGggg() {
        return gggg;
    }

    public void setGggg(String gggg) {
        this.gggg = gggg;
    }

    public String getGgxx() {
        return ggxx;
    }

    public void setGgxx(String ggxx) {
        this.ggxx = ggxx;
    }
}
