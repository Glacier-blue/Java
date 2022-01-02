package MyCloneable;
class TestStu implements Cloneable{
    String name;
    String number;
    double score;
    public TestStu(String name, String number, double score) {
        this.name = name;
        this.number = number;
        this.score = score;
    }

    @Override
    public String toString() {
        return "TestStu{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
/*-------------------分割线------------------------------------------------*/

public class MyCloneable {
    public static void main(String[] args)throws CloneNotSupportedException {
        TestStu student1=new TestStu("zhangsan","0001",90.78);
        TestStu student2=(TestStu) student1.clone();
        System.out.println(student2);
    }
}
