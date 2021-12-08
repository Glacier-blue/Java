package day1208;

public class Main {
    public static void main(String[] args) {
        String str3=new String("a")+new String("a");
        str3.intern();
        String str4="aa";
        System.out.println(str3==str4);
    }
    public static void main2(String[] args) {
        String str1=new String("a");
        str1.intern();
        String str2="a";
        System.out.println(str1==str2);

        String str3=new String("a")+new String("a");
        str3.intern();
        String str4="aa";
        System.out.println(str3==str4);
    }
    public static void main1(String[] args) {
        String str1="a";
        String str2=new String("a")+new String("a");
        String str3=new String("a")+"a";
        String str4="a"+"a";
        String str5="aa";
        System.out.println(str2==str3);
        System.out.println(str2==str4);
        System.out.println(str3==str4);
        System.out.println(str4==str5);
    }
}
