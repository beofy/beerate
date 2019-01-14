package cn.beerate.model.entity.stock.companysurvey;

import cn.beerate.model.Model;
import cn.beerate.model.entity.stock.operationsrequired.t_operations_required;
import cn.beerate.model.entity.stock.t_business_analysis;
import cn.beerate.model.entity.stock.t_shareholder_research;

import javax.persistence.*;

@Entity
@org.hibernate.annotations.Table(appliesTo = "t_stock_info",comment="公司概况")
public class t_stock_info  extends Model {

    //"Code": "SZ000001",
    private String code;

    //"CodeType": "ABStock",
    private String codeType;

    //"SecuCode": "000001.SZ",
    private String  secuCode;

    //"SecurityCode": "000001",
    private String   securityCode;

    //"SecurityShortName": "平安银行",
    private String securityShortName;

    //"MarketCode": "02",
    private String marketCode;

    //"Market": "SZ",
    private String market;

    //"ExpireTime": "\/Date(-62135596800000)\/"
    private String expireTime;

    @OneToOne(mappedBy = "stock_info",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private t_stock_fxxg stock_fxxg;

    @OneToOne(mappedBy = "stock_info",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private t_stock_jbzl stock_jbzl;

    @OneToOne(mappedBy = "stock_info",fetch =FetchType.LAZY,cascade = CascadeType.PERSIST)
    private t_operations_required operations_required;

    @OneToOne(mappedBy = "stock_info",fetch =FetchType.LAZY,cascade = CascadeType.PERSIST)
    private t_shareholder_research shareholder_research;

    @OneToOne(mappedBy = "stock_info",fetch =FetchType.LAZY,cascade = CascadeType.PERSIST)
    private t_business_analysis business_analysis;

    public t_business_analysis getBusiness_analysis() {
        return business_analysis;
    }

    public void setBusiness_analysis(t_business_analysis business_analysis) {
        this.business_analysis = business_analysis;
    }

    public t_shareholder_research getShareholder_research() {
        return shareholder_research;
    }

    public void setShareholder_research(t_shareholder_research shareholder_research) {
        this.shareholder_research = shareholder_research;
    }

    public t_operations_required getOperations_required() {
        return operations_required;
    }

    public void setOperations_required(t_operations_required operations_required) {
        this.operations_required = operations_required;
    }

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

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
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
}
