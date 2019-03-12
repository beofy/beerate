package cn.beerate.common.util;

public class UnicodeUtils {

    /**
     * 将字符转换为16进制
     */
    public static String[] getHex(String s){
        char[] chars= s.toCharArray();
        int len =chars.length;

        String[] unicode = new String[len];
        for (int i = 0; i < len; i++) {
            unicode[i]=Integer.toHexString(chars[i]);
        }

        return unicode;
    }

    /**
     * 将字符转换为10进制
     */
    public static int[] getDec(String s){
        char[] chars= s.toCharArray();
        int len =chars.length;

        int[] dec = new int[len];
        for (int i = 0; i < len; i++) {
            dec[i]=Integer.parseInt(Integer.toHexString(chars[i]),16);
        }

        return dec;
    }

}
