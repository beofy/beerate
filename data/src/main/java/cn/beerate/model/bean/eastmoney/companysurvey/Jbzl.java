/**
  * Copyright 2019 bejson.com 
  */
package cn.beerate.model.bean.eastmoney.companysurvey;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Auto-generated: 2019-01-24 11:17:10
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@ApiModel(description = "基本资料")
@Data
public class Jbzl {
    @ApiModelProperty(value = "公司名称")
    private String gsmc;

    @ApiModelProperty(value = "英文名称")
    private String ywmc;

    @ApiModelProperty(value = "曾用名")
    private String cym;

    @ApiModelProperty(value = "A股代码")
    private String agdm;

    @ApiModelProperty(value = "A股简称")
    private String agjc;

    @ApiModelProperty(value = "B股代码")
    private String bgdm;

    @ApiModelProperty(value = "B股简称")
    private String bgjc;

    @ApiModelProperty(value = "H股代码")
    private String hgdm;

    @ApiModelProperty(value = "H股简称")
    private String hgjc;

    @ApiModelProperty(value = "证券类别")
    private String zqlb;

    @ApiModelProperty(value = "所属行业")
    private String sshy;

    @ApiModelProperty(value = "上市交易所")
    private String ssjys;

    @ApiModelProperty(value = "所属证监会行业")
    private String sszjhhy;

    @ApiModelProperty(value = "总经理")
    private String zjl;

    @ApiModelProperty(value = "法人代表")
    private String frdb;

    @ApiModelProperty(value = "董秘")
    private String dm;

    @ApiModelProperty(value = "董事长")
    private String dsz;

    @ApiModelProperty(value = "证券事务代表")
    private String zqswdb;

    @ApiModelProperty(value = "独立董事")
    private String dlds;

    @ApiModelProperty(value = "联系电话")
    private String lxdh;

    @ApiModelProperty(value = "电子信箱")
    private String dzxx;

    @ApiModelProperty(value = "传真")
    private String cz;

    @ApiModelProperty(value = "公司网址")
    private String gswz;

    @ApiModelProperty(value = "办公地址")
    private String bgdz;

    @ApiModelProperty(value = "注册地址")
    private String zcdz;

    @ApiModelProperty(value = "区域")
    private String qy;

    @ApiModelProperty(value = "邮政编码")
    private String yzbm;

    @ApiModelProperty(value = "注册资本(元)")
    private String zczb;

    @ApiModelProperty(value = "工商登记")
    private String gsdj;

    @ApiModelProperty(value = "雇员人数")
    private String gyrs;

    @ApiModelProperty(value = "管理人员人数")
    private String glryrs;

    @ApiModelProperty(value = "律师事务所")
    private String lssws;

    @ApiModelProperty(value = "会计师事务所")
    private String kjssws;

    @ApiModelProperty(value = "公司简介")
    private String gsjj;

    @ApiModelProperty(value = "经营范围")
    private String jyfw;
}