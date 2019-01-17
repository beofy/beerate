package cn.beerate.model.entity.stock;

import cn.beerate.model.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class t_shareholder_research extends Model {

    @Column(columnDefinition = " TEXT COMMENT '股东人数' ")
    private String gdrs;

    @Column(columnDefinition = " TEXT COMMENT '十大流通股东' ")
    private String sdltgd;

    @Column(columnDefinition = " TEXT COMMENT '十大股东' ")
    private String sdgd;

    @Column(columnDefinition = " TEXT COMMENT '基金持股' ")
    private String jjcg;

    @Column(columnDefinition = " TEXT COMMENT '十大股东持股变动' ")
    private String sdgdcgbd;

    @Column(columnDefinition = " TEXT COMMENT '限售解禁' ")
    private String xsjj;

    /**
     * ltsxgf 流通限售股份 <br>
     * qyltgf 其余流通股份 <br>
     * rq 日期 <br>
     * sdltgdcg 十大流通股东持股
     */
    @Column(columnDefinition = " TEXT COMMENT '十大股东持股东-占比数据' ")
    private String sdltgd_chart;

    @Column(columnDefinition = " TEXT COMMENT '机构持仓' ")
    private String zlcc;

    @Column(columnDefinition = " TEXT COMMENT '机构持仓期日' ")
    private String zlcc_rz;

    public String getGdrs() {
        return gdrs;
    }

    public void setGdrs(String gdrs) {
        this.gdrs = gdrs;
    }

    public String getSdltgd() {
        return sdltgd;
    }

    public void setSdltgd(String sdltgd) {
        this.sdltgd = sdltgd;
    }

    public String getSdgd() {
        return sdgd;
    }

    public void setSdgd(String sdgd) {
        this.sdgd = sdgd;
    }

    public String getJjcg() {
        return jjcg;
    }

    public void setJjcg(String jjcg) {
        this.jjcg = jjcg;
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

    public String getSdltgd_chart() {
        return sdltgd_chart;
    }

    public void setSdltgd_chart(String sdltgd_chart) {
        this.sdltgd_chart = sdltgd_chart;
    }

    public String getZlcc() {
        return zlcc;
    }

    public void setZlcc(String zlcc) {
        this.zlcc = zlcc;
    }

    public String getZlcc_rz() {
        return zlcc_rz;
    }

    public void setZlcc_rz(String zlcc_rz) {
        this.zlcc_rz = zlcc_rz;
    }
}
