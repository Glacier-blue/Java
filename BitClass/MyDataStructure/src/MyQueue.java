
class Node{
    public int val;
    public Node next;
    public Node(){}
    public Node(int val){
        this.val=val;
    }
}
public class MyQueue {
    private Node head;
    private Node tail;
    public void offer(int val){
        if(empty()){
            head=new Node(val);
            tail=head;
        }else {
            tail.next=new Node(val);
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

    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.empty());
        System.out.println(myQueue.peek());
        myQueue.offer(3);
        System.out.println(myQueue.poll());


    }
}
