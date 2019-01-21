package cn.beerate.model.entity.stock;

import cn.beerate.model.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 公司概况
 */
@Entity
@org.hibernate.annotations.Table(appliesTo = "t_company_survey",comment="公司概况")
public class t_company_survey extends Model {

    @Column(columnDefinition = " varchar(255) COMMENT '代码' ")
    private String code;

    @Column(columnDefinition = " varchar(255) COMMENT '代码类型' ")
    private String  codeType;

    @Column(columnDefinition = " varchar(255) COMMENT '过期时间' ")
    private String  expireTime;

    @Column(columnDefinition = " varchar(255) ")
    private String  market;

    @Column(columnDefinition = " varchar(255) ")
    private String  marketCode;

    @Column(columnDefinition = " varchar(255) ")

    private String  secuCode;
    @Column(columnDefinition = " varchar(255) COMMENT '股票代码' ")
    private String  securityCode;

    @Column(columnDefinition = " varchar(255) COMMENT '股票代码' ")
    private String  securityShortName;

    @Column(columnDefinition = " TEXT COMMENT '发行相关'")
    private String  fxxg;

    @Column(columnDefinition = " TEXT COMMENT '基本资料'")
    private String  jbzl;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getSecuCode() {
        return secuCode;
    }

    public void setSecuCode(String secuCode) {
        this.secuCode = secuCode;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getSecurityShortName() {
        return securityShortName;
    }

    public void setSecurityShortName(String securityShortName) {
        this.securityShortName = securityShortName;
    }

    public String getFxxg() {
        return fxxg;
    }

    public void setFxxg(String fxxg) {
        this.fxxg = fxxg;
    }

    public String getJbzl() {
        return jbzl;
    }

    public void setJbzl(String jbzl) {
        this.jbzl = jbzl;
    }
}
