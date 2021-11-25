package day1125;

public class Work {
    static boolean Paddy;
    public static void main(String args[]){
        System.out.println(Paddy);
    }
    public static void mai2(String[] args) {
        int a=3;
        byte b=(byte)a;
    }
    public static void main1(String[] args) {
        short a =128;

        byte b =(byte) a;
        System.out.println(a);
        System.out.println(b);
    }
}
/**
 * short a   128=0000000010000000B
 * byte b  10000000(补码)
 * 11111111->10000000->10000001
 */