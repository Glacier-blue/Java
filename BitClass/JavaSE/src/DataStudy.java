import java.util.Arrays;

public class DataStudy {
    public static void main(String[] args) {
        byte a=127;
        a=(byte) 128;
        System.out.println(a);
        Integer a1=100;
        Integer a2=100;
        Integer a3=180;
        Integer a4=180;
        System.out.println("a1==a2:"+(a1==a2));//true
        System.out.println("a3==a4:"+(a3==a4));//false
        System.out.println("a3.equlas(a4):"+a3.equals(a4));//true
    }
}
