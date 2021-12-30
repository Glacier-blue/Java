
interface Fly{
     abstract public void fly();
}
abstract class Biology{
    public int age;
    abstract public void grow();
}
class Animal extends Biology{
    public String name;
    public void eat(){
        System.out.println("已经进食");
    }

    @Override
    public void grow() {
        System.out.println("成长");
    }

    public Animal(String name){
        this.name=name;
    }
}
class Bird extends Animal implements Fly{
    public int flyAble;
    public Bird(String name,int flyAble){
        super(name);
        this.flyAble=flyAble;
    }

    @Override
    public void eat() {
        System.out.println("用喙进食");
    }

    @Override
    public void fly() {
        System.out.println("飞起来了哦");
    }
}
public class TestClass {
    public static void main(String[] args) {
        Animal huihui=new Bird("huihui",3);
        huihui.eat();
        Bird dingding=new Bird("dingding",5);
        dingding.fly();
    }
}
