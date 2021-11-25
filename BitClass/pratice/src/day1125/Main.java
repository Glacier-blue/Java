package day1125;

class A{
    public static void func1(){
        System.out.println("静态方法不用对象可以调用");
    }
    public static int num=10;
}
public class Main {
    public static void main(String[] args) {
        A.func1();
        System.out.println(A.num);
    }
    public static void main2(String[] args) {
        final int a=10;
    }
    public static void main1(String[] args) {
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
