import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n =5;
        System.out.println(fun2(n));
    }
    public static int fun2(int n){
        if(n==0){
            return 1;
        }else{
            return n*fun2(n-1);
        }
    }
    public static void main6(String[] args) {
        int n = 5;
        System.out.println(sumAdd(n));
    }
    public static int sumAdd(int n){
        if(n==0){
            return 0;
        }else{
            return n+sumAdd(n-1);
        }
    }
    public static void main5(String[] args) {
        print(1234);
    }
    public static void print(int n){
        if(n<10){
            System.out.println(n);
        }else{
            print(n/10);
            System.out.println(n%10);
        }
    }
    public static void main4(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.println(i+"  "+fun1(i));
        }
    }
    public static int fun1(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else{
            return 2*fun1(n-1)+1;
        }
    }


    public static void main3(String[] args) {
        int n = 4;
        System.out.println(fib(5));
    }
    //0-1-1-2-3-5
    public static int fib(int n){
        if(n==0){
            return 0;
        }else if(n==1||n==2){
            return 1;
        }else{
            return fib(n-1)+fib(n-2);
        }
    }
    public static void main2(String[] args) {
        int n = 5;
        System.out.println(howNum(n));
    }
    public static int howNum(int n){
        if(n<=0){
            return 0;
        }else if(n<=2){
            return n;
        }else{
            return howNum(n-1)+howNum(n-2);
        }
    }
    //0----------->0
    //1---->1----->1
    //2----->1,1||2---->2
    //3----->1+2---->1+2=3
    //4----->2+2||3+1---->3+2=5



    public static void main1(String[] args) {
        int n=1729;
        System.out.println(sumEveAdd(n));
    }
    public static int sumEveAdd(int n){
        if(n<10){
            return n;
        }else{
            return n%10+sumEveAdd(n/10);
        }
    }
}
