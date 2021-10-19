import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        Random random = new Random();
        int rand = random.nextInt(100);
        int n = 0;
        while(true){
            n=scanner.nextInt();
            if(n<rand){
                System.out.println("猜小了");
            }
            else if(n==rand){
                System.out.println("猜对了");
                break;
            }else{
                System.out.println("猜大了");
            }
        }
    }
//    public static void main(String[] args) {
//        int a = 10;
//        char b = 'a';
//        System.out.println();
//    }



//    public static void main(String[] args) {
////        String s="MCMXCIV";
////        System.out.println(romanToInt(s));
//    }
//    public static int romanToInt(String s) {
//        int i=0,len=s.length();
//        int sum=0;
//        while(i<len&&s.substring(i,i+1).equals("M")){
//            sum+=1000;
//            i++;
//        }
//        if(i<len-1&&s.substring(i,i+2).equals("CM")){
//            sum+=900;
//            i+=2;
//        }
//        if(i<len&&s.substring(i,i+1).equals("D")){
//            sum+=500;
//            ++i;
//        }
//        if(i<len&&s.substring(i,i+2).equals("CD")){
//            sum+=400;
//            i+=2;
//        }
//        while(i<len&&s.substring(i,i+1).equals("C")){
//            sum+=100;
//            ++i;
//        }
//        if(i<len&&s.substring(i,i+2).equals("XC")){
//            sum+=90;
//            i+=2;
//        }
//        if(i<len&&s.substring(i,i+1).equals("L")){
//            sum+=50;
//        }
//        if(i<len&&s.substring(i,i+2).equals("XL")){
//            sum+=40;
//            i+=2;
//        }
//        while(i<len&&s.substring(i,i+1).equals("X")){
//            sum+=10;
//            i++;
//        }
//        if(i<len&&s.substring(i,i+2).equals("XL")){
//            sum+=9;
//            i+=2;
//        }
//        if(i<len&&s.substring(i,i+1).equals("V")){
//            sum+=5;
//            ++i;
//        }
//        if(i<len&&s.substring(i,i+2).equals("IV")){
//            sum+=4;
//            i+=2;
//        }
//        while(i<len&&s.substring(i,i+1).equals("I")){
//            sum++;
//            i++;
//        }
//        return sum;
//    }
}
