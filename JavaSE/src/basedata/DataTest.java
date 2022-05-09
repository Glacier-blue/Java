package basedata;

public class DataTest {
    public static void main(String[] args) {
        System.out.println(Float.MAX_VALUE);
    }
    //Integer的缓存区在[-128,127]
    public static void main3(String[] args) {
        Integer a = 127;
        Integer b = 127;
        Integer c = 180;
        Integer d = 180;
        System.out.println("a==b:" + (a == b));//true
        System.out.println("c==d:" + (c == d));//false
    }
    public static void main2(String[] args) {
        long a=20;
        float b=20.1F;
//        a=b;
        //虽然long占有8个字节，float占有4个字节
        //但是float表示的数据范围大于long
        //float转换为long需要强制类型转换，并且丢失精度
        a=(long)b;
        System.out.println(a);
    }
    //八大基本数据类型
    public static void main1(String[] args) {
        int a=10;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        short b=10;
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
        byte c=20;
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        long d=10;
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        float e=10.0F;
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        double f=30.1;
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);

        char chares1='a';
        boolean bool1=true;
//        boolean bool2=1;
    }
}
