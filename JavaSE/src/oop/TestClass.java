package oop;

import java.io.FilterOutputStream;
import java.util.HashSet;

public class TestClass {
    private int val;
    public TestClass(){}
    public TestClass(int val){
        this.val = val;
    }

    public static void main(String[] args) {
    }
    //为什么重写equals要重写hashcode
    public static void main4(String[] args) {
        TestClass testClass = new TestClass(1);
        TestClass testClass1 = new TestClass(1);
        System.out.println(testClass1.hashCode());
        System.out.println(testClass.hashCode());
        HashSet<TestClass> set = new HashSet<>();
        set.add(testClass1);
        set.add(testClass);
        System.out.println(set.size());
        System.out.println(testClass1.equals(testClass));
    }

    public static void main3(String[] args) {
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

    @Override
    public boolean equals(Object obj) {
        if(this==obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        TestClass t = (TestClass)obj;
        return this.val == t.val;
    }
}
