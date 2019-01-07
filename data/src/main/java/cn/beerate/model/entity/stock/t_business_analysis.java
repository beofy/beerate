package cn.beerate.model.entity.stock;

import cn.beerate.model.Model;
import cn.beerate.model.entity.stock.companysurvey.t_stock_info;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 经营分析
 */
@Entity
public class t_business_analysis extends Model {

    @Column(columnDefinition = " TEXT COMMENT '经营范围' ")
    private String zyfw;

    @Column(columnDefinition = " TEXT COMMENT '主营构成分析' ")
    private String zygcfx;

    @Column(columnDefinition = " TEXT COMMENT '经营评述' ")
    private String jyps;

    @OneToOne(optional = false)
    @JoinColumn(name="stock_info_id",unique = true)
    private t_stock_info stock_info;

    public t_stock_info getStock_info() {
        return stock_info;
    }

    public void setStock_info(t_stock_info stock_info) {
        this.stock_info = stock_info;
    }

    public String getZyfw() {
        return zyfw;
    }

    public void setZyfw(String zyfw) {
        this.zyfw = zyfw;
    }

    public String getZygcfx() {
        return zygcfx;
    }

    public void setZygcfx(String zygcfx) {
        this.zygcfx = zygcfx;
    }

    public String getJyps() {
        return jyps;
    }

    public void setJyps(String jyps) {
        this.jyps = jyps;
    }
}
