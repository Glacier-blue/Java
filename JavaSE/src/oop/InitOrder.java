package oop;

public class InitOrder {

    private static String staticField = getStaticField();
    static {
        System.out.println(staticField);
        System.out.println("静态方法块");
    }

    private String field = getField();{
        System.out.println(field);
    }
    public InitOrder() {
        System.out.println("构造方法启动");
    }
    public static String getStaticField() {
        String statiFiled = "Static Field Initial";
        return statiFiled;
    }
    public static String getField() {
        String filed = "Field Initial";
        return filed;
    }

    public static void main(String[] argc) {
        new InitOrder();
    }
}
