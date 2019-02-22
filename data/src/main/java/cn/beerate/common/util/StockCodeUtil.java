package cn.beerate.common.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 股票代码工具类
 */
public class StockCodeUtil {

    /**
     * 校验股票是否正确(<b style="color:red;">兼容证券交易所简称开头<b/>(例如:SZ SH)
     * @return
     */
    public static Boolean isStockCode(String code){
        if (null == code) {
            return false;
        }

        return code.matches("((sz|Sz|SZ|sZ|sh|SH|Sh|sH)[\\d]{6}$)|(^[\\d]{6}$)");
    }

    /**
     * 返回一个6位数股票
     * @param code
     * @return
     */
    public static String getNumberStockCode(String code){
        if(!isStockCode(code)) return null;
        if(code.length()==6) return code;

        return code.substring(2);
    }

    /**
     * 返回股票代码(<b style="color:red;">证券简称开头<b/>)
     * @param code
     * @return
     */
    public static String getABStock(String code){
        if(code.matches("(sz|Sz|SZ|sZ|sh|SH|Sh|sH)[\\d]{6}$")) return code;

        if(!code.matches("^[\\d]{6}$")) return null;

        //深交所
        if(code.matches("^(000|002|300)[\\d]{3}$")) return "sz"+code;

        //上交所
        if(code.matches("^(600|601|603)[\\d]{3}$")) return "sh"+code;

        return null;
    }

    /**
     * 获取所有股票代码(证券交易所简称开头(例如:SZ SH)
     * @return
     */
    public static Set<String> getStockCode(){
        //股票打头
        final String[] CODE_START={"sz000","sz002","sz300","sh600","sh601","sh603"};

        Set<String> stockCodeList = new HashSet<>();
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

    public static void main(String[] args) {
        //System.out.println(isStockCode("sh000021"));
        //System.out.println(getNumberStockCode("000021"));
        //System.out.println(getABStock("600003"));
        //System.out.println(getABStock("600003"));
    }
}
