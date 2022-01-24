package basedata;

import java.util.Arrays;

public class TestString {
    //字符串查找
    public static void main(String[] args) {
        String str="abcdefghj";
        System.out.println(str.contains("def"));
        System.out.println(str.indexOf("abcd"));
        System.out.println(str.indexOf("abcd", 1));
    }

    //测试hashCode和equals和==
    public static void main3(String[] args) {
        String s1=new String("123456");
        String s2=new String("123456");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
    //字符串和字符数组转换问题
    public static void main2(String[] args) {
        char[] chars={'a','b','c','d'};
        String str1=new String(chars);
        System.out.println(str1);
        char[] chars1=str1.toCharArray();
        String str2=new String(chars,0,3);
        System.out.println(str2);
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
