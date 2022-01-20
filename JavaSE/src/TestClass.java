
public class TestClass {
    static class Person{
        public String name;
        public int age;
        public void eat(){
            System.out.println(name+" is eat");
        }//方法
        public static int count;//静态变量--属于类
    }
    static class Animal {
        public String name;
        public Animal(String name) {
            this.name = name;
        }
        public void eat(String food) {
            System.out.println(this.name + "正在吃" + food);
        }
        public static void testfun(){
            System.out.println("测试函数");
        }
        public static int a=10;
    }

    static class Cat extends Animal {
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
    static class Bird extends Animal {
        public Bird(String name) {
            super(name);
        }
        public void fly() {
            System.out.println(this.name + "正在飞 ︿(￣︶￣)︿");
        }
    }

    public static void main(String[] args) {
        Animal cat=new Cat("小黑");
        cat.eat("mouse");
        Cat cat1=new Cat("圆圆");
        cat1.eat("mouse1");
        Animal cat2=new Cat("小辉");
        cat2.testfun();
    }
    public static void main5(String[] args) {
        System.out.println(Animal.a);
        Animal.a++;
        System.out.println(Cat.a);
        Cat.a++;
        System.out.println(Bird.a);
    }
    public static void main6(String[] args) {
        Cat cat = new Cat("小黑");
        System.out.println("name->"+cat.name);
        cat.eat("猫粮");
        Bird bird = new Bird("圆圆");
        bird.fly();
    }
    public static void main3(String[] args) {
        Person play1=new Person();
        Person play2=new Person();
        play1.count=1;
        play2.count=2;
        System.out.println(play1.count);
        System.out.println(play2.count);
    }
    public static void main2(String[] args) {
        Person play1=new Person();
        play1.name="number1";
        play1.age=18;
        Person play2=new Person();
        play2.name="number2";
        play2.age=19;
        System.out.println("名字:"+play1.name+" 年龄:"+play1.age);
        System.out.println("名字:"+play2.name+" 年龄:"+play2.age);
    }
    public static void main1(String[] args) {
        Person play1=new Person();//类实例化为对象
        System.out.println(play1.name);
        System.out.println(play1.age);
        play1.eat();
    }
}
