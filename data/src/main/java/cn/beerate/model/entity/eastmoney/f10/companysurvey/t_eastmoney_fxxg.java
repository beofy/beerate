package cn.beerate.model.entity.eastmoney.f10.companysurvey;
import cn.beerate.model.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@ApiModel(description = "发行相关")
@Setter
@Getter
@Entity
public class t_eastmoney_fxxg extends Model {
    @ApiModelProperty(value = "成立日期")
    private String clrq;

    @ApiModelProperty(value = "上市日期")
    private String ssrq;
    
    @ApiModelProperty(value = "发行市盈率(倍)")
    private String fxsyl;
    
    @ApiModelProperty(value = "网上发行日期")
    private String wsfxrq;
    
    @ApiModelProperty(value = "发行方式")
    private String fxfs;
    
    @ApiModelProperty(value = "每股面值(元)")
    private String mgmz;
    
    @ApiModelProperty(value = "发行量(股)")
    private String fxl;
    
    @ApiModelProperty(value = "每股发行价(元)")
    private String mgfxj;
    
    @ApiModelProperty(value = "发行费用(元)")
    private String fxfy;
    
    @ApiModelProperty(value = "发行总市值(元)")
    private String fxzsz;
    
    @ApiModelProperty(value = "募集资金净额(元)")
    private String mjzjje;
    
    @ApiModelProperty(value = "首日开盘价(元)")
    private String srkpj;
    
    @ApiModelProperty(value = "首日收盘价(元)")
    private String srspj;
    
    @ApiModelProperty(value = "首日换手率")
    private String srhsl;
    
    @ApiModelProperty(value = "首日最高价(元)")
    private String srzgj;
    
    @ApiModelProperty(value = "网下配售中签率")
    private String wxpszql;
    
    @ApiModelProperty(value = "定价中签率")
    private String djzql;

    @OneToOne(optional = false)
    @JoinColumn(name = "companysurvey_id",unique = true)
    private t_eastmoney_companysurvey companysurvey;
}