/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.entity.eastmoney.f10.companysurvey;

import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Auto-generated: 2019-01-24 11:17:10
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "公司概况")
@Data
@Entity
public class t_eastmoney_companysurvey extends Model {
    @ApiModelProperty(value = "股票代码(交易所简称开头)")
    private String code;

    @ApiModelProperty(value = "代码类型")
    private String codeType;

    @ApiModelProperty(value = "股票代码(交易所简称结尾)")
    private String secuCode;

    @ApiModelProperty(value = "股票代码")
    private String securityCode;

    @ApiModelProperty(value = "简称")
    private String securityShortName;

    @ApiModelProperty(value = "证券所代码")
    private String marketCode;

    @ApiModelProperty(value = "证券所")
    private String market;

    @ApiModelProperty(value = "到期日")
    private String expireTime;

    @OneToOne(optional = false)
    @JoinColumn(name = "jbzl_id",unique = true)
    private t_eastmoney_jbzl jbzl;

    @OneToOne(optional = false)
    @JoinColumn(name = "fxxg_id",unique = true)
    private t_eastmoney_fxxg fxxg;
}