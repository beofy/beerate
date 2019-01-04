package cn.beerate.model.entity.stock.CompanySurvey;

import javax.persistence.*;
import java.util.Date;

@Entity
public class t_stock_info  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    /**
     * 生成时间
     */
    public Date createTime = new Date();

    //"Code": "SZ000001",
    public String Code;

    //"CodeType": "ABStock",
    public String CodeType;

    //"SecuCode": "000001.SZ",
    public String  SecuCode;

    //"SecurityCode": "000001",
    public String   SecurityCode;

    //"SecurityShortName": "平安银行",
    public String SecurityShortName;

    //"MarketCode": "02",
    public String MarketCode;

    //"Market": "SZ",
    public String Market;

    //"ExpireTime": "\/Date(-62135596800000)\/"
    public String ExpireTime;

    @OneToOne(mappedBy = "stock_info",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    public t_stock_fxxg stock_fxxg;

    @OneToOne(mappedBy = "stock_info",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    public t_stock_jbzl stock_jbzl;

    @Override
    public String toString() {
        return "t_stock_info{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", Code='" + Code + '\'' +
                ", CodeType='" + CodeType + '\'' +
                ", SecuCode='" + SecuCode + '\'' +
                ", SecurityCode='" + SecurityCode + '\'' +
                ", SecurityShortName='" + SecurityShortName + '\'' +
                ", MarketCode='" + MarketCode + '\'' +
                ", Market='" + Market + '\'' +
                ", ExpireTime='" + ExpireTime + '\'' +
                '}';
    }
}
