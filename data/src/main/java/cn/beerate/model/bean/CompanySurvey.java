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
    private String Code;

    @ApiModelProperty(value = "代码类型")
    private String CodeType;

    @ApiModelProperty(value = "股票代码(交易所简称结尾)")
    private String SecuCode;

    @ApiModelProperty(value = "股票代码")
    private String SecurityCode;

    @ApiModelProperty(value = "简称")
    private String SecurityShortName;

    @ApiModelProperty(value = "证券所代码")
    private String MarketCode;

    @ApiModelProperty(value = "证券所")
    private String Market;

    @ApiModelProperty(value = "到期日")
    private String ExpireTime;
}