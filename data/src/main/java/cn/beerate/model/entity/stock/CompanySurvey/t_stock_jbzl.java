package cn.beerate.model.entity.stock.CompanySurvey;

import javax.persistence.*;
import java.util.Date;

@Entity
public class t_stock_jbzl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    /**
     * 生成时间
     */
    public Date createTime = new Date();

    //"gsmc": "平安银行股份有限公司",
    public String gsmc ;

    //"ywmc": "Ping An Bank Co., Ltd.",
    public String ywmc;

    //"cym": "深发展A->S深发展A->深发展A",
    public String cym;

    //"agdm": "000001",
    public String agdm;

    //"agjc": "平安银行",
    public String agjc;

    //"bgdm": "--",
    public String bgdm;

    //"bgjc": "--",
    public String bgjc;

    //"hgdm": "--",
    public String hgdm;

    //"hgjc": "--",
    public String hgjc;

    //"zqlb": "深交所主板A股",
    public String zqlb;

    //"sshy": "银行",
    public String sshy;

    //"ssjys": "深圳证券交易所",
    public String ssjys;

    //"sszjhhy": "金融业-货币金融服务",
    public String sszjhhy;

    //"zjl": "胡跃飞",
    public String zjl;

    //"frdb": "谢永林",
    public String frdb;

    //"dm": "周强",
    public String dm;

    //"dsz": "谢永林",
    public String dsz;

    //"zqswdb": "吕旭光",
    public String zqswdb;

    //"dlds": "王春汉,王松奇,韩小京,郭田勇,杨如生",
    public String dlds;

    //"lxdh": "0755-82080387",
    public String lxdh;

    //"dzxx": "pabdsh@pingan.com.cn",
    public String dzxx;

    //"cz": "0755-82080386",
    public String cz;

    //"gswz": "www.bank.pingan.com",
    public String gswz;

    //"bgdz": "广东省深圳市罗湖区深南东路5047号",
    public String bgdz;

    //"zcdz": "中华人民共和国广东省深圳市罗湖区深南东路5047号",
    public String zcdz;

    //"qy": "广东",
    public String qy;

    //"yzbm": "518001",
    public String yzbm;

    //"zczb": "172亿",
    public String zczb;

    //"gsdj": "91440300192185379H",
    public String gsdj;

    //"gyrs": "32744",
    public String gyrs;

    //"glryrs": "32",
    public String glryrs;

    //"lssws": "广东信达律师事务所",
    public String lssws;

    //"kjssws": "普华永道中天会计师事务所(特殊普通合伙)",
    public String kjssws;

    //"gsjj": " 平安银行股份有限公司是一家总部设在深圳的全国性股份制商业银行。
    @Column(columnDefinition = "text")
    public String gsjj;

    // "jyfw": "办理人民币存、贷、结算、汇兑业务;人民币票据承兑和贴现;
    @Column(columnDefinition = "text")
    public String jyfw;

    @OneToOne(optional = false)
    @JoinColumn(name="stock_info_id",unique = true)
    public t_stock_info stock_info;

    @Override
    public String toString() {
        return "t_stock_jbzl{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", gsmc='" + gsmc + '\'' +
                ", ywmc='" + ywmc + '\'' +
                ", cym='" + cym + '\'' +
                ", agdm='" + agdm + '\'' +
                ", agjc='" + agjc + '\'' +
                ", bgdm='" + bgdm + '\'' +
                ", bgjc='" + bgjc + '\'' +
                ", hgdm='" + hgdm + '\'' +
                ", hgjc='" + hgjc + '\'' +
                ", zqlb='" + zqlb + '\'' +
                ", sshy='" + sshy + '\'' +
                ", ssjys='" + ssjys + '\'' +
                ", sszjhhy='" + sszjhhy + '\'' +
                ", zjl='" + zjl + '\'' +
                ", frdb='" + frdb + '\'' +
                ", dm='" + dm + '\'' +
                ", dsz='" + dsz + '\'' +
                ", zqswdb='" + zqswdb + '\'' +
                ", dlds='" + dlds + '\'' +
                ", lxdh='" + lxdh + '\'' +
                ", dzxx='" + dzxx + '\'' +
                ", cz='" + cz + '\'' +
                ", gswz='" + gswz + '\'' +
                ", bgdz='" + bgdz + '\'' +
                ", zcdz='" + zcdz + '\'' +
                ", qy='" + qy + '\'' +
                ", yzbm='" + yzbm + '\'' +
                ", zczb='" + zczb + '\'' +
                ", gsdj='" + gsdj + '\'' +
                ", gyrs='" + gyrs + '\'' +
                ", glryrs='" + glryrs + '\'' +
                ", lssws='" + lssws + '\'' +
                ", kjssws='" + kjssws + '\'' +
                ", gsjj='" + gsjj + '\'' +
                ", jyfw='" + jyfw + '\'' +
                '}';
    }
}
