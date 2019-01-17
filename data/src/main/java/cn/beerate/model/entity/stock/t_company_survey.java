package cn.beerate.model.entity.stock;

import cn.beerate.model.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

@org.hibernate.annotations.Table(appliesTo = "t_stock_info",comment="公司概况")
@Entity
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


}
