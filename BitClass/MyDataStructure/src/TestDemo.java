import java.util.Stack;

public class TestDemo {

    public static void main(String[] args) {
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        stack1.push(1);
        stack1.push(13);
        stack2.push(1);
        stack2.push(13);
        System.out.println(stack1.peek()==stack2.peek());
    }
}
