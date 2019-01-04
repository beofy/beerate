package cn.beerate.model.entity.stock.companysurvey;

import cn.beerate.model.Model;

import javax.persistence.*;

@Entity
public class t_stock_info  extends Model {

    //"Code": "SZ000001",
    private String Code;

    //"CodeType": "ABStock",
    private String CodeType;

    //"SecuCode": "000001.SZ",
    private String  SecuCode;

    //"SecurityCode": "000001",
    private String   SecurityCode;

    //"SecurityShortName": "平安银行",
    private String SecurityShortName;

    //"MarketCode": "02",
    private String MarketCode;

    //"Market": "SZ",
    private String Market;

    //"ExpireTime": "\/Date(-62135596800000)\/"
    private String ExpireTime;

    @OneToOne(mappedBy = "stock_info",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private t_stock_fxxg stock_fxxg;

    @OneToOne(mappedBy = "stock_info",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private t_stock_jbzl stock_jbzl;

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

    public String getMarketCode() {
        return MarketCode;
    }

    public void setMarketCode(String marketCode) {
        MarketCode = marketCode;
    }

    public String getMarket() {
        return Market;
    }

    public void setMarket(String market) {
        Market = market;
    }

    public String getExpireTime() {
        return ExpireTime;
    }

    public void setExpireTime(String expireTime) {
        ExpireTime = expireTime;
    }

    public t_stock_fxxg getStock_fxxg() {
        return stock_fxxg;
    }

    public void setStock_fxxg(t_stock_fxxg stock_fxxg) {
        this.stock_fxxg = stock_fxxg;
    }

    public t_stock_jbzl getStock_jbzl() {
        return stock_jbzl;
    }

    public void setStock_jbzl(t_stock_jbzl stock_jbzl) {
        this.stock_jbzl = stock_jbzl;
    }

    @Override
    public String toString() {
        return "t_stock_info{" +
                "Code='" + Code + '\'' +
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
