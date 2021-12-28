import java.util.Arrays;

public class TestString {
    static final String str1="123";
    static final String str2;
    static {
        str2="456";
        s=str1+str2;
    }
    static String s;
    public static void main3(String[] args) {
        System.out.println(s=="123456");
        {
            String s=str1+"456";
            System.out.println(s=="123456");
        }
        {
            String s="123"+str2;
            System.out.println(s=="123456");
        }
    }

    public static void main(String[] args) {
        char[] chars={'a','b','c','d'};
        String str=new String(chars);
        System.out.println(str);
        char[] chars1=str.toCharArray();
        System.out.println(Arrays.toString(chars1));
    }
    /**
     * 测试：compareTo函数
     * s1.compareTo(s2)
     * s1-s2每个字符向后减
     */
    public static void main1(String[] args) {
        String s1="abcdefg";
        String s2="bcdefg";
        System.out.println(s1.compareTo(s2));
        System.out.println(s2.compareTo(s1));
    }
}
