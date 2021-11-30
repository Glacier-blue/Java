import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        stack.push("abcdef");
        stack.push("asda");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
