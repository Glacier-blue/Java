import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** initialize your data structure here. */
    public MinStack() {
        stack1=new Stack<Integer>();
        stack2=new Stack<Integer>();
    }

    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty()||stack2.peek()>=x){
            stack2.push(x);
        }
    }

    public void pop() {
        if(stack1.peek()==stack2.peek()){
            stack1.pop();
            stack2.pop();
        }else{
            stack1.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}

class StackOfPlates {
    List<Stack<Integer>> list=new ArrayList<>();
    int cap;
    int lastCap=0;
    Stack<Integer> stack;
    public StackOfPlates(int cap) {
        this.cap=cap;
        stack=new Stack<Integer>();
    }

    public void push(int val) {
        if(lastCap==cap){
            lastCap=0;
            list.add(stack);
            stack=new Stack<Integer>();
        }
        stack.push(val);
        lastCap++;
    }

    public int pop() {
        int size=list.size();
        if(stack.isEmpty()){
            stack=list.get(size-1);
            this.lastCap=cap;
        }
        this.lastCap--;
        return stack.pop();
    }

    public int popAt(int index) {
        int size=list.size();
        int res;
        if(index==size){
            res=stack.pop();
            lastCap--;
        }else{
            res=list.get(index).pop();
            if(list.get(index).isEmpty()){
                list.remove(list.get(index));
            }
        }
        return res;
    }
}
