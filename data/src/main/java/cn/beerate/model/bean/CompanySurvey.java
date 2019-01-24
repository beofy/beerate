/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean;

import cn.beerate.model.bean.companysurvey.Fxxg;
import cn.beerate.model.bean.companysurvey.Jbzl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Auto-generated: 2019-01-24 11:17:10
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "公司概况")
@Data
public class CompanySurvey {

    private Jbzl jbzl;

    private Fxxg fxxg;

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

}