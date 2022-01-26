import reflection.Student;
import java.lang.reflect.*;
public class Reflection {
    //反射获取学生对象
    public static void reflectNewInstance() {
        try {
            Class<?> classStudent = Class.forName("reflection.Student");
            Object objectStudent = classStudent.newInstance();
            Student student = (Student) objectStudent;
            System.out.println("获得学生对象："+student);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // 反射私有的构造方法 屏蔽内容为获得公有的构造方法
    public static void reflectPrivateConstructor() {
        try {
            Class<?> classStudent = Class.forName("reflection.Student");
            //注意传入对应的参数
            Constructor<?> declaredConstructorStudent =
                    classStudent.getDeclaredConstructor(String.class,int.class);
            //Constructor<?> declaredConstructorStudent = classStudent.getConstructor();
            //设置为true后可修改访问权限
            declaredConstructorStudent.setAccessible(true);
            Object objectStudent = declaredConstructorStudent.newInstance("汪福明",22);
            //Object objectStudent = declaredConstructorStudent.newInstance();
            Student student = (Student) objectStudent;
            System.out.println("获得私有构造函数且修改姓名和年龄："+student);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // 反射私有属性
    public static void reflectPrivateField() {
        try {
            Class<?> classStudent = Class.forName("reflection.Student");
            Field field = classStudent.getDeclaredField("name");
            field.setAccessible(true);
            //可以修改该属性的值
            Object objectStudent = classStudent.newInstance();
            Student student = (Student) objectStudent;
            field.set(student,"小明");
            String name = (String) field.get(student);
            System.out.println("反射私有属性修改了name："+ name);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // 反射私有方法
    public static void reflectPrivateMethod() {
        try {
            Class<?> classStudent = Class.forName("reflection.Student");
            Method methodStudent = classStudent.getDeclaredMethod("function",String.class);
            System.out.println("私有方法的方法名为："+methodStudent.getName());
            //私有的一般都要加
            methodStudent.setAccessible(true);
            Object objectStudent = classStudent.newInstance();
            Student student = (Student) objectStudent;
            methodStudent.invoke(student,"我是给私有的function函数传的参数");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        reflectNewInstance();
        reflectPrivateConstructor();
        reflectPrivateField();
        reflectPrivateMethod();
    }
    //三种获取类对象的操作
    public static void main1(String[] args) {
        //1.通过getClass获取Class对象
        Student s1 = new Student();
        Class c1 = s1.getClass();

        /**
         * 2.直接通过 类名.class 的方式得到,该方法最为安全可靠，程序性能更高
         * 这说明任何一个类都有一个隐含的静态成员变量 class
         */
        Class c2 = Student.class;
        /**
         * 3、通过 Class 对象的 forName() 静态方法来获取，用的最多，
         * 但可能抛出 ClassNotFoundException 异常
         */
        Class c3 = null;
        try {
             //注意这里是类的全路径，如果有包需要加包的路径
            c3 = Class.forName("reflection.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //一个类在 JVM 中只会有一个 Class 实例
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c2.equals(c3));
        //输出都是true，由此可见，类对象只有一个
    }
}
