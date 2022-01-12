import java.io.*;

public class IODemo6 {
    static class Student implements Serializable {
        int age;
        String name;

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student=new Student();
        student.age=18;
        student.name="张三";
        serialize(student);

        Student student1=deSerialize();
        System.out.println(student1);
    }
    public static  void serialize(Student student) throws IOException {
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("D:\\汪福明\\Desktop\\1.txt"));
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
    }
    public static Student deSerialize() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("D:\\汪福明\\Desktop\\1.txt"));
        Student student=(Student)objectInputStream.readObject();
        objectInputStream.close();
        return student;
    }
}
