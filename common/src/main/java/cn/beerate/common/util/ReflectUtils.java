package cn.beerate.common.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ReflectUtils {

    /**
     * 获取对象所有的属性名，并以map返回
     */
    public static Map<String,Object> getFileds(Object object){
        if (object==null){
            throw new NullPointerException("Object not instantiated");
        }

        Map<String,Object> map = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                map.put(field.getName(),field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }




}
