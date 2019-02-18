package cn.beerate.model.bean.tenjqka;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "公司概况")
@Data
public class Profile {
    @ApiModelProperty("主营业务")
    private String zyyw;
    @ApiModelProperty("所属行业")
    private String sshy;
     @ApiModelProperty("概念强排名弱")
    private String gnqrpm;

    @ApiModelProperty("市盈率(动态)")
    private String dtsyl;
    @ApiModelProperty("每股收益")
    private String mgsy;
    @ApiModelProperty("每股资本公积金")
    private String mgzbgjj;
    @ApiModelProperty("分类")
    private String fl;

    @ApiModelProperty("市盈率(静态)")
    private String jtsyl;
    @ApiModelProperty("营业收入")
    private String yysr;
    @ApiModelProperty("每股未分配利润")
    private String mgwfplr;
    @ApiModelProperty("总股本")
    private String zgb;

    @ApiModelProperty("市净率")
    private String sjl;
    @ApiModelProperty("净利润")
    private String jlr;
    @ApiModelProperty("每股经营现金流")
    private String xjl;
    @ApiModelProperty("总市值")
    private String zsz;

    @ApiModelProperty("每股净资产")
    private String mgjzc;
    @ApiModelProperty("毛利率")
    private String mlr;
    @ApiModelProperty("净资产收益率")
    private String jzcsyl;
    @ApiModelProperty("流通A股")
    private String ltAg;

    @ApiModelProperty("最新解禁")
    private String zxjj;
    @ApiModelProperty("解禁股份类型")
    private String jjgflx;
    @ApiModelProperty("解禁数量")
    private String jjsl;
    @ApiModelProperty("占总股本比例")
    private String zzgbbl;

    @ApiModelProperty("更新日期")
    private String gxsj;
    @ApiModelProperty("总质押股份数量")
    private String zzygfsl;
    @ApiModelProperty("质押股份占A股总股本比")
    private String zygfzAgzgbz;

}
