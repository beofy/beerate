package cn.beerate.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    /**
     * @param regx 正则表达式
     * @param target 目标字符
     */
    public static List<String> getStrByRegx(String regx,String target){
        Pattern pattern =  Pattern.compile(regx);
        Matcher matcher = pattern.matcher(target);
        List<String> stringList =new ArrayList<>();
        while (matcher.find()){
            String s= matcher.group();
            stringList.add(s);
        }
        return stringList;
    }

}
