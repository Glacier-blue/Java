package day1125;

public class Main {

    public static void main(String[] args) {
        Main main=new Main();
        main.fun1();

    }
    public void fun1(){
        fun();
    }
    public static void fun(){
        int a=10;
        Main main=new Main();
        int ret=main.fun2();
        System.out.println(a);
    }
    public int fun2(){
        return 1;
    }
}
