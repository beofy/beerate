package cn.beerate.common.util;

import java.util.Map;
import java.util.TreeMap;

public class MapUtils {

    public static String getValuesByKeySorted(Map<String,Object> map){
        Map<String,Object> sortedMap = map;
        if(!(map instanceof TreeMap)){
            sortedMap = new TreeMap<>(map);
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Object> ent:sortedMap.entrySet()){
            sb.append(ent.getValue()==null?"":ent.getValue().toString());
        }
        return sb.toString();
    }
}
