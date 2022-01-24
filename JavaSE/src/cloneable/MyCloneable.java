package cloneable;


public class MyCloneable {
    public static void main(String[] args)throws CloneNotSupportedException {
        TestStu student1=new TestStu("zhangsan","0001",90.78);
        TestStu student2=(TestStu) student1.clone();
        System.out.println(student2);
    }
}
