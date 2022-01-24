package exception;

public class TestException {
    public static void main(String[] args) {
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
    public static void main1(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println("before");
        System.out.println(arr[100]);
        System.out.println("after");
    }
}
