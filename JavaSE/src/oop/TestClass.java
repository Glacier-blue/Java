package oop;

public class TestClass {

    public static void main(String[] args) {
        Animal cat=new Cat("小黑");
        cat.eat("mouse");
        Cat cat1=new Cat("圆圆");
        cat1.eat("mouse1");
        Animal cat2=new Cat("小辉");
        cat2.testfun();
    }
    //继承的静态变量共用一份
    public static void main2(String[] args) {
        System.out.println(Animal.a);
        Animal.a++;
        System.out.println(Cat.a);
        Cat.a++;
        System.out.println(Bird.a);
    }
    public static void main1(String[] args) {
        Cat cat = new Cat("小黑");
        System.out.println("name->"+cat.name);
        cat.eat("猫粮");
        Bird bird = new Bird("圆圆");
        bird.fly();
    }
}
