package day1207;

public class Main {

    public static void main(String[] args) {
        String str1="123456";
        String str2="123456";
        System.out.println("str1==str2:"+(str1==str2));
        String str3="123"+"456";
        System.out.println("str1==str3:"+(str1==str3));
        String str4="123"+new String("456");
        System.out.println("str1==str4:"+(str1==str4));
        String str5=str4.intern();
        System.out.println("str1==str5:"+(str1==str5));
        String str6="1";
        String str7="23456";
        String str8=str6+str7;
        System.out.println("str1==str8:"+(str1==str8));
    }
    public static void main2(String[] args) {
        String str1="123456";
        String str2=new String("123456");
        System.out.println(str1==str2);
    }
    public static void main1(String[] args) {
        int i=5;
        int a=i+i++;
        System.out.println(i);
        System.out.println(a);
    }
}
