public class TestString {
    static final String str1="123";
    static final String str2;
    static {
        str2="456";
        s=str1+str2;
    }
    static String s;
    public static void main(String[] args) {
        System.out.println(s=="123456");
        {
            String s=str1+"456";
            System.out.println(s=="123456");
        }
        {
            String s="123"+str2;
            System.out.println(s=="123456");
        }
        {
            String s=str1+str2;
            System.out.println(s=="123456");
        }
    }

    public static void main1(String[] args) {
        final String s1="123";
        final String s2="456";
        String s3=s1+s2;
        System.out.println(s3=="123456");
    }
}
