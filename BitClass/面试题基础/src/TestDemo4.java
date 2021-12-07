public class TestDemo4 {
    /**
     * 函数的传值调用还是传址调用
     * 两个都拿到引用
     * 第一个改变拷贝引用指向对象，未改变原引用指向对象
     * 第二个改变字符内容
     */
    String str=new String("java");
    char[] arr={'x','d','u'};
    public static void main(String[] args) {
        TestDemo4 testDemo4=new TestDemo4();
        change(testDemo4.str, testDemo4.arr);
        System.out.println(testDemo4.str);
        System.out.println(testDemo4.arr);
    }
    public static void change(String str,char[] arr){
        str="00000";
        arr[0]='0';
    }
}
