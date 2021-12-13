import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    private int getTop;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(queue2.isEmpty()){
            queue2.offer(x);
        }else{
            queue1.offer(x);
        }
        this.getTop=x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()){
            return -1;
        }
        int ret;
        if(!queue1.isEmpty()){
            transfer(queue1,queue2);
            ret=queue1.poll();
        }else{
            transfer(queue2,queue1);
            ret=queue2.poll();
        }
        return ret;
    }
    private void transfer(Queue<Integer> qu1,Queue<Integer> qu2){
        int size=qu1.size();
        for(int i=0;i<size-1;i++){
            int tmp=qu1.poll();
            qu2.offer(tmp);
            this.getTop=tmp;
        }
    }

    /** Get the top element. */
    public int top() {
        return getTop;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
    }
}
