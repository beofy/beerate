package cn.beerate.common.util;

import java.util.ArrayList;
import java.util.List;

public class StockCodeUtil {

    //股票打头
    private static final String[] CODE_START={"sz000","sz002","sz300","sh600","sh601","sh603"};

    //所有股票打头
    public static List<String> getStockCode(){
        List<String> stockCodeList = new ArrayList<String>();
        for(String start: CODE_START){
            //0-999
            for (int i = 0; i <1000 ; i++) {
                String stockCode="";
                if(i<10){
                    stockCode=start+"00"+i;
                }
                if(i>=10&&i<100){
                    stockCode=start+"0"+i;
                }
                if(i>=100&&i<1000){
                    stockCode=start+i;
                }
                stockCodeList.add(stockCode);
            }
        }
        return stockCodeList;
    }
}
