package oop;

public class Cat extends Animal{
    public Cat(String name) {
        // 使用 super 调用父类的构造方法.
        super(name);
    }
    @Override
    public void eat(String food) {
        System.out.println("eat Mouse");
    }

    public void findMouse(){
        System.out.println("FindMouse");
    }
}
