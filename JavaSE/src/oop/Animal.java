package oop;

public class Animal {
    public String name;
    public static int a=10;
    public Animal(String name) {
        this.name = name;
    }
    public void eat(String food) {
        System.out.println(this.name + "正在吃" + food);
    }
    public static void testfun(){
        System.out.println("测试函数");
    }
    //表示final修饰的函数无法被重写
    public final void testfun2(){
        System.out.println("测试函数2");
    }

}
