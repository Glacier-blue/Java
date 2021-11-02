
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

    public void createList() {
        ListNode listNode1 = new ListNode(12);
        ListNode listNode2 = new ListNode(23);
        ListNode listNode3 = new ListNode(34);
        ListNode listNode4 = new ListNode(45);
        ListNode listNode5 = new ListNode(56);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        this.head = listNode1;
    }

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
        /*if(this.head == null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }*/
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

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index, int data) {
        return false;
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

    }

}
