package cn.beerate.model.entity.stock;

import cn.beerate.model.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@org.hibernate.annotations.Table(appliesTo = "t_core_conception",comment="核心题材")
public class t_core_conception extends Model {

    @Column(columnDefinition = " varchar(8) DEFAULT NULL COMMENT '股票代码'")
    private String stockCode;

    @Column(columnDefinition = " TEXT COMMENT '核心题材'")
    private String hxtc;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getHxtc() {
        return hxtc;
    }

    public void setHxtc(String hxtc) {
        this.hxtc = hxtc;
    }
}
