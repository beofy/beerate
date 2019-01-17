package cn.beerate.model.entity.stock;

import cn.beerate.model.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 经营分析
 */
@Entity
@org.hibernate.annotations.Table(appliesTo = "t_business_analysis",comment="经营分析")
public class t_business_analysis extends Model {

    @Column(columnDefinition = " TEXT COMMENT '经营范围' ")
    private String zyfw;

    @Column(columnDefinition = " TEXT COMMENT '主营构成分析' ")
    private String zygcfx;

    @Column(columnDefinition = " TEXT COMMENT '经营评述' ")
    private String jyps;

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
