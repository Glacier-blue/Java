public class Main {


    public static void main(String[] args) {
        StackOfPlates stackOfPlates=new StackOfPlates(1);
        stackOfPlates.push(1);
        stackOfPlates.push(2);
        stackOfPlates.push(1);
        System.out.println(stackOfPlates.popAt(0));
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
    }
    public static void main1(String[] args) {
        MinStack minStack=new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}



