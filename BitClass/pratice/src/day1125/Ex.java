package day1125;

/**
 * 异常的练习
 */
public class Ex {

    public void fun2(){
        int[] arr = {1, 2, 3};
        try {
            System.out.println("before");
            System.out.println(arr[100]);
            System.out.println("after");
        } catch (ArrayIndexOutOfBoundsException e) {
// 打印出现异常的调用栈
            e.printStackTrace();
        }
        System.out.println("after try catch");
    }
    public void fun1(){
        int[] arr = {1, 2, 3};
        System.out.println("before");
        System.out.println(arr[100]);
        System.out.println("after");
    }
}
