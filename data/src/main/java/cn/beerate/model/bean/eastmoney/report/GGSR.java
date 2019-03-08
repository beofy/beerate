package cn.beerate.model.bean.eastmoney.report;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@ApiModel(description = "个股研报")
public class GGSR {
    private String author;
    private String change;
    private String companyCode;
    private String datetime;
    private String infoCode;
    private String insCode;
    private String insName;
    private String insStar;
    private String rate;
    private String secuFullCode;
    private String secuName;
    private String sratingName;
    private String sy;
    private String title;
    private String profitYear;
    private String type;
    private String newPrice;
    private List<String> jlrs;
    private List<String> syls;
    private List<String> sys;
}
