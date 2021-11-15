package data1115;
class Cycle extends Shape{
    @Override
    public void draw() {
        System.out.println("这是一个圆>>⚪");
    }
}
class Flower extends Shape{
    @Override
    public void draw() {
        System.out.println("这是一朵花>>❀");
    }
}

public class Main {
    public void draw(Shape a){
        a.draw();
    }
    public static void main(String[] args) {
        Shape a=new Cycle();
        Shape b=new Flower();
        Main main=new Main();
        main.draw(a);
        main.draw(b);
    }
}
