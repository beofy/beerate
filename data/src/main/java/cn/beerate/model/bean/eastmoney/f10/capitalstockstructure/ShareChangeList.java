package cn.beerate.model.bean.eastmoney.f10.capitalstockstructure;
import lombok.Data;

import java.util.List;

@Data
public class ShareChangeList {
    private String des;
    private List<String> changeList;
}