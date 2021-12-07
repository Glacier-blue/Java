public class TestDemo2 {
    public static void main(String[] args) {
        /**
         * Java的String字符串不可变（可以通过反射修改），通过拼接就是一个新的对象
         * ==比较两个对象是否相等
         * equals比较字符串的内容是否相等
         */
        String a="123";
        String b="123";
        String c=a+b;
        String d="123"+"123";
        System.out.println(c==d);
        System.out.println(c.equals(d));
    }
}
