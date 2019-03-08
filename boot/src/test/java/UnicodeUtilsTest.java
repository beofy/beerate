import cn.beerate.common.util.SortUtils;


public class UnicodeUtilsTest {

    public static void main(String[] args) {
        String str="银行股份有限公司海口联合农村商业";
        System.out.println(SortUtils.uncodeSort(str));
        str="联合农村商业银行股份有限公司海口";
        System.out.println(SortUtils.uncodeSort(str));
        str="业股有联合银行村商份限农公司海口";
        System.out.println(SortUtils.uncodeSort(str));
    }





}
