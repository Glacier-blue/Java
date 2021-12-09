import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        int[] nums={9,8,7,6,5,4,3,2,1};
        MySort mySort=new MySort();
        //mySort.insertSort(nums);
        //mySort.shellSort(nums);
        mySort.halfInsertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void main1(String[] args) {
        MyStack myStack=new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
