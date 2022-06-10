package oop;

public class Bird extends Animal{
    public Bird(String name) {
        super(name);
    }
    public void fly() {
        System.out.println(this.name + "正在飞 ︿(￣︶￣)︿");
    }
    int i = 0;
    Bird eat(){
        i++;
        return this;
    }

    public static void main(String[] args) {
        Bird bird = new Bird("donkey");
        bird.eat().eat();
        System.out.println(bird.i);
    }
}
