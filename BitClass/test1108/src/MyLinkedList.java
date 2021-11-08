class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class MyLinkedList {

    public ListNode head;//指向双向链表的头节点
    public ListNode last;//指向的是尾巴节点

    public void display() {
        //和单链表的打印方式是一样的
        ListNode cur=head;
        if(cur==null){
            System.out.println("空链表");
            return;
        }
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    //得到单链表的长度
    public int size() {
        int n=0;
        ListNode cur=this.head;
        while(cur!=null){
            ++n;
            cur=cur.next;
        }
        return n;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode prev=this.head;
        while(prev!=null){
            if(prev.val==key){
                return true;
            }
            prev=prev.next;
        }
        return false;
    }

    //头插法
    public void addFirst(int data) {
        if(this.head==null){
            this.head=new ListNode(data);
            this.last=this.head;
            return;
        }
        ListNode cur=new ListNode(data);
        cur.next=this.head;
        this.head.prev=cur;
        this.head=cur;
    }
    //尾插法
    public void addLast(int data){
        if(this.head==null){
            this.head=new ListNode(data);
            this.last=this.head;
            return;
        }
        ListNode cur=new ListNode(data);
        this.last.next=cur;
        cur.prev=this.last;
        this.last=cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if (index<0||index>size()){
            System.out.println("位置不合法");
            return;
        }
        if(index==0){
            addFirst(data);
        }else if(index==size()){
            addLast(data);
        }else{
            ListNode cur=head;
            for(int i=0;i<index;i++){
                cur=cur.next;
            }
            ListNode node=new ListNode(data);
            cur.prev.next=node;
            node.prev=cur.prev;
            node.next=cur;
            cur.prev=node;
        }
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur=this.head;
        while(cur!=null) {
            if (cur.val == key) {
                if (cur == this.head) {
                    this.head = cur.next;
                    this.head.prev = null;
                } else if (cur == this.last) {
                    this.last = cur.prev;
                    this.last.next = null;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                return;
            }
            cur=cur.next;
        }
        System.out.println("删除未成功");
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur=this.head;
        while(cur!=null) {
            if (cur.val == key) {
                if (cur == this.head) {
                    this.head = cur.next;
                    this.head.prev = null;
                } else if (cur == this.last) {
                    this.last = cur.prev;
                    this.last.next = null;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }
            cur=cur.next;
        }
    }


    public void clear() {
        while(this.head!=null){
            ListNode cur=this.head.next;
            this.head.prev=null;
            this.head.next=null;
            this.head=cur;
        }
        this.last=null;
    }

}