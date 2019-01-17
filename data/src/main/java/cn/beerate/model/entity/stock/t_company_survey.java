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
    private String Code;

    @Column(columnDefinition = " varchar(255) COMMENT '代码类型' ")
    private String  CodeType;

    @Column(columnDefinition = " varchar(255) COMMENT '过期时间' ")
    private String  ExpireTime;

    @Column(columnDefinition = " varchar(255) ")
    private String  Market;

    @Column(columnDefinition = " varchar(255) ")
    private String  MarketCode;

    @Column(columnDefinition = " varchar(255) ")
    private String  SecuCode;

    @Column(columnDefinition = " varchar(255) COMMENT '股票代码' ")
    private String  SecurityCode;

    @Column(columnDefinition = " varchar(255) COMMENT '股票代码' ")
    private String  SecurityShortName;

    @Column(columnDefinition = " TEXT COMMENT '发行相关'")
    private String  fxxg;

    @Column(columnDefinition = " TEXT COMMENT '基本资料'")
    private String  jbzl;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getCodeType() {
        return CodeType;
    }

    public void setCodeType(String codeType) {
        CodeType = codeType;
    }

    public String getExpireTime() {
        return ExpireTime;
    }

    public void setExpireTime(String expireTime) {
        ExpireTime = expireTime;
    }

    public String getMarket() {
        return Market;
    }

    public void setMarket(String market) {
        Market = market;
    }

    public String getMarketCode() {
        return MarketCode;
    }

    public void setMarketCode(String marketCode) {
        MarketCode = marketCode;
    }

    public String getSecuCode() {
        return SecuCode;
    }

    public void setSecuCode(String secuCode) {
        SecuCode = secuCode;
    }

    public String getSecurityCode() {
        return SecurityCode;
    }

    public void setSecurityCode(String securityCode) {
        SecurityCode = securityCode;
    }

    public String getSecurityShortName() {
        return SecurityShortName;
    }

    public void setSecurityShortName(String securityShortName) {
        SecurityShortName = securityShortName;
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
