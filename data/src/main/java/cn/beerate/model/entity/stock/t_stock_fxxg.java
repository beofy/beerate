package cn.beerate.model.entity.stock;


import javax.persistence.*;
import java.util.Date;

@Entity
public class t_stock_fxxg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    /**
     * 生成时间
     */
    public Date createTime = new Date();

    //"clrq": "1987-12-22",
    public String clrq;

    //"ssrq": "1991-04-03",
    public String ssrq;

    //"fxsyl": "--",
    public String fxsyl;

    //"wsfxrq": "1989-03-10",
    public String wsfxrq;

    //"fxfs": "其他发行方式",
    public String fxfs;

    //"mgmz": "20.00",
    public String mgmz;

    //"fxl": "67.5万",
    public String fxl;

    //"mgfxj": "40.00",
    public String mgfxj;

    //"fxfy": "--",
    public String fxfy;

    //"fxzsz": "2700万",
    public String fxzsz;

    //"mjzjje": "0",
    public String mjzjje;

    //"srkpj": "49.00",
    public String srkpj;

    //"srspj": "49.00",
    public String srspj;

    //"srhsl": "0.00%",
    public String srhsl;

    //"srzgj": "49.00",;
    public String srzgj;

    //"wxpszql": "--",
    public String wxpszql;

    //"djzql": "--"
    public String djzql;


    @OneToOne(optional = false)
    @JoinColumn(name="stock_info_id",unique = true)
    public t_stock_info stock_info;

    @Override
    public String toString() {
        return "t_stock_fxxg{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", clrq='" + clrq + '\'' +
                ", ssrq='" + ssrq + '\'' +
                ", fxsyl='" + fxsyl + '\'' +
                ", wsfxrq='" + wsfxrq + '\'' +
                ", fxfs='" + fxfs + '\'' +
                ", mgmz='" + mgmz + '\'' +
                ", fxl='" + fxl + '\'' +
                ", mgfxj='" + mgfxj + '\'' +
                ", fxfy='" + fxfy + '\'' +
                ", fxzsz='" + fxzsz + '\'' +
                ", mjzjje='" + mjzjje + '\'' +
                ", srkpj='" + srkpj + '\'' +
                ", srspj='" + srspj + '\'' +
                ", srhsl='" + srhsl + '\'' +
                ", srzgj='" + srzgj + '\'' +
                ", wxpszql='" + wxpszql + '\'' +
                ", djzql='" + djzql + '\'' +
                '}';
    }
}
