package cn.beerate.model.entity.stock.companysurvey;

import cn.beerate.model.Model;

import javax.persistence.*;

@Entity
@org.hibernate.annotations.Table(appliesTo = "t_stock_jbzl",comment="公司概况")
public class t_stock_jbzl extends Model {

    //"gsmc": "平安银行股份有限公司",
    private String gsmc ;

    //"ywmc": "Ping An Bank Co., Ltd.",
    private String ywmc;

    //"cym": "深发展A->S深发展A->深发展A",
    private String cym;

    //"agdm": "000001",
    private String agdm;

    //"agjc": "平安银行",
    private String agjc;

    //"bgdm": "--",
    private String bgdm;

    //"bgjc": "--",
    private String bgjc;

    //"hgdm": "--",
    private String hgdm;

    //"hgjc": "--",
    private String hgjc;

    //"zqlb": "深交所主板A股",
    private String zqlb;

    //"sshy": "银行",
    private String sshy;

    //"ssjys": "深圳证券交易所",
    private String ssjys;

    //"sszjhhy": "金融业-货币金融服务",
    private String sszjhhy;

    //"zjl": "胡跃飞",
    private String zjl;

    //"frdb": "谢永林",
    private String frdb;

    //"dm": "周强",
    private String dm;

    //"dsz": "谢永林",
    private String dsz;

    //"zqswdb": "吕旭光",
    private String zqswdb;

    //"dlds": "王春汉,王松奇,韩小京,郭田勇,杨如生",
    private String dlds;

    //"lxdh": "0755-82080387",
    private String lxdh;

    //"dzxx": "pabdsh@pingan.com.cn",
    private String dzxx;

    //"cz": "0755-82080386",
    private String cz;

    //"gswz": "www.bank.pingan.com",
    private String gswz;

    //"bgdz": "广东省深圳市罗湖区深南东路5047号",
    private String bgdz;

    //"zcdz": "中华人民共和国广东省深圳市罗湖区深南东路5047号",
    private String zcdz;

    //"qy": "广东",
    private String qy;

    //"yzbm": "518001",
    private String yzbm;

    //"zczb": "172亿",
    private String zczb;

    //"gsdj": "91440300192185379H",
    private String gsdj;

    //"gyrs": "32744",
    private String gyrs;

    //"glryrs": "32",
    private String glryrs;

    //"lssws": "广东信达律师事务所",
    private String lssws;

    //"kjssws": "普华永道中天会计师事务所(特殊普通合伙)",
    private String kjssws;

    //"gsjj": " 平安银行股份有限公司是一家总部设在深圳的全国性股份制商业银行。
    @Column(columnDefinition = "text")
    private String gsjj;

    // "jyfw": "办理人民币存、贷、结算、汇兑业务;人民币票据承兑和贴现;
    @Column(columnDefinition = "text")
    private String jyfw;

    @OneToOne(optional = false)
    @JoinColumn(name="stock_info_id",unique = true)
    private t_stock_info stock_info;

    public String getGsmc() {
        return gsmc;
    }

    public void setGsmc(String gsmc) {
        this.gsmc = gsmc;
    }

    public String getYwmc() {
        return ywmc;
    }

    public void setYwmc(String ywmc) {
        this.ywmc = ywmc;
    }

    public String getCym() {
        return cym;
    }

    public void setCym(String cym) {
        this.cym = cym;
    }

    public String getAgdm() {
        return agdm;
    }

    public void setAgdm(String agdm) {
        this.agdm = agdm;
    }

    public String getAgjc() {
        return agjc;
    }

    public void setAgjc(String agjc) {
        this.agjc = agjc;
    }

    public String getBgdm() {
        return bgdm;
    }

    public void setBgdm(String bgdm) {
        this.bgdm = bgdm;
    }

    public String getBgjc() {
        return bgjc;
    }

    public void setBgjc(String bgjc) {
        this.bgjc = bgjc;
    }

    public String getHgdm() {
        return hgdm;
    }

    public void setHgdm(String hgdm) {
        this.hgdm = hgdm;
    }

    public String getHgjc() {
        return hgjc;
    }

    public void setHgjc(String hgjc) {
        this.hgjc = hgjc;
    }

    public String getZqlb() {
        return zqlb;
    }

    public void setZqlb(String zqlb) {
        this.zqlb = zqlb;
    }

    public String getSshy() {
        return sshy;
    }

    public void setSshy(String sshy) {
        this.sshy = sshy;
    }

    public String getSsjys() {
        return ssjys;
    }

    public void setSsjys(String ssjys) {
        this.ssjys = ssjys;
    }

    public String getSszjhhy() {
        return sszjhhy;
    }

    public void setSszjhhy(String sszjhhy) {
        this.sszjhhy = sszjhhy;
    }

    public String getZjl() {
        return zjl;
    }

    public void setZjl(String zjl) {
        this.zjl = zjl;
    }

    public String getFrdb() {
        return frdb;
    }

    public void setFrdb(String frdb) {
        this.frdb = frdb;
    }

    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    public String getDsz() {
        return dsz;
    }

    public void setDsz(String dsz) {
        this.dsz = dsz;
    }

    public String getZqswdb() {
        return zqswdb;
    }

    public void setZqswdb(String zqswdb) {
        this.zqswdb = zqswdb;
    }

    public String getDlds() {
        return dlds;
    }

    public void setDlds(String dlds) {
        this.dlds = dlds;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getDzxx() {
        return dzxx;
    }

    public void setDzxx(String dzxx) {
        this.dzxx = dzxx;
    }

    public String getCz() {
        return cz;
    }

    public void setCz(String cz) {
        this.cz = cz;
    }

    public String getGswz() {
        return gswz;
    }

    public void setGswz(String gswz) {
        this.gswz = gswz;
    }

    public String getBgdz() {
        return bgdz;
    }

    public void setBgdz(String bgdz) {
        this.bgdz = bgdz;
    }

    public String getZcdz() {
        return zcdz;
    }

    public void setZcdz(String zcdz) {
        this.zcdz = zcdz;
    }

    public String getQy() {
        return qy;
    }

    public void setQy(String qy) {
        this.qy = qy;
    }

    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    public String getZczb() {
        return zczb;
    }

    public void setZczb(String zczb) {
        this.zczb = zczb;
    }

    public String getGsdj() {
        return gsdj;
    }

    public void setGsdj(String gsdj) {
        this.gsdj = gsdj;
    }

    public String getGyrs() {
        return gyrs;
    }

    public void setGyrs(String gyrs) {
        this.gyrs = gyrs;
    }

    public String getGlryrs() {
        return glryrs;
    }

    public void setGlryrs(String glryrs) {
        this.glryrs = glryrs;
    }

    public String getLssws() {
        return lssws;
    }

    public void setLssws(String lssws) {
        this.lssws = lssws;
    }

    public String getKjssws() {
        return kjssws;
    }

    public void setKjssws(String kjssws) {
        this.kjssws = kjssws;
    }

    public String getGsjj() {
        return gsjj;
    }

    public void setGsjj(String gsjj) {
        this.gsjj = gsjj;
    }

    public String getJyfw() {
        return jyfw;
    }

    public void setJyfw(String jyfw) {
        this.jyfw = jyfw;
    }

    public t_stock_info getStock_info() {
        return stock_info;
    }

    public void setStock_info(t_stock_info stock_info) {
        this.stock_info = stock_info;
    }

    @Override
    public String toString() {
        return "t_stock_jbzl{" +
                "gsmc='" + gsmc + '\'' +
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
