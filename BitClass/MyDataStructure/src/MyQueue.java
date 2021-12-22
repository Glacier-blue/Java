
//链式队列
public class MyQueue {
    private ListNode head;
    private ListNode tail;
    public void offer(int val){
        if(empty()){
            head=new ListNode(val);
            tail=head;
        }else {
            tail.next=new ListNode(val);
            tail=tail.next;
        }
    }
    public int poll(){
        if(empty()){
            throw new UnsupportedOperationException("队列空");
        }else{
            int ret= head.val;
            head=head.next;
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

