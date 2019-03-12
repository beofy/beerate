package cn.beerate.common.util;

public class SortUtils {

    /**
     * 冒泡排序
     */
    public static int[] bubbleSort(int[] arr) {
        for(int i =0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-i-1;j++) {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        return arr;
    }

    /**
     * 字符unicode排序
     */
    public static String uncodeSort(String s){
        StringBuilder sb = new StringBuilder();
        int[] ints= bubbleSort(UnicodeUtils.getDec(s));
        for (int anInt : ints) {
             char c =(char)Integer.parseInt(String.valueOf(anInt));
             sb.append(c);
        }

        return sb.toString();
    }
}
