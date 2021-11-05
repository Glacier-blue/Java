
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 12629
 * Date: 2021/11/2
 * Time: 19:00
 * Description:
 */
//ListNode代表一个节点
class ListNode {
    public int val;
    public ListNode next;//null

    public ListNode(int val) {
        this.val = val;
    }
}
public class MyLinkedList {

    public ListNode head;//链表的头引用


    public void display() {
        //this.head.next != null
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //得到单链表的长度
    public int size() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }


    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data) {
        if (this.head == null) {
            this.head = new ListNode(data);
        } else {
            ListNode p1 = this.head;
            ListNode p2 = new ListNode(data);
            while (p1.next != null) {
                p1 = p1.next;
            }
            p1.next = p2;
        }
    }
    public ListNode findIndex(int index){
        ListNode cur=this.head;
        while(index-1!=0){
            cur=cur.next;
            index--;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        if(index<0||index>size()){
            System.out.println("输入位置不合法");
        }else if(index==0){
            addFirst(data);
        }else if(index==size()){
            addLast(data);
        }else{
            ListNode cur=findIndex(index);
            ListNode tmp=new ListNode(data);
            tmp.next=cur.next;
            cur.next=tmp;
        }
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head == null) {
            System.out.println("单链表为空，不能删除！");
            return;
        }
        if(this.head.val == key) {
            this.head = this.head.next;
            return;
        }
        ListNode cur=head;
        while(cur.next!=null&&cur.next.val!=key) {
            cur = cur.next;
        }
        if(cur.next==null){
            System.out.println("关键字不存在");
        }else{
            cur.next = cur.next.next;
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode dump=new ListNode(0);
        ListNode p1=dump,p2=this.head;
        while(p2!=null){
            if(p2.val!=key){
                p1.next=p2;
                p1=p2;
            }
            p2=p2.next;
        }
        p1.next=null;
        this.head=dump.next;
    }


    public void clear() {
        while(this.head!=null){
            ListNode cur=head.next;
            this.head.next=null;
            this.head=cur;
        }
    }
    public ListNode findKth(int k){
        if(k<=0||head==null) return null;
        ListNode fast=head,slow=head;
        while(k>0&&fast!=null){
            fast=fast.next;
            k--;
        }
        if(fast==null) return null;
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
