package list;

import node.ListNode;

//链式队列
public class MyQueue {
    private ListNode head;
    private ListNode tail;
    private int size;
    public int size(){
        return size;
    }
    public void offer(int val){
        if(empty()){
            head=new ListNode(val);
            tail=head;
        }else {
            tail.next=new ListNode(val);
            tail=tail.next;
        }
        size++;
    }
    public int poll(){
        if(empty()){
            throw new UnsupportedOperationException("队列空");
        }else{
            int ret= head.val;
            head=head.next;
            size--;
            return ret;
        }
    }
    public int peek(){
        if (empty()){
            throw new UnsupportedOperationException("队列空");
        }else{
            return head.val;
        }
    }
    public boolean empty(){
        return this.head==null;
    }

}

