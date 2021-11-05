public class Main {
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addFirst(7);
        list.addIndex(1,9);
        list.display();
        ListNode ret= list.findKth(9);
        System.out.println(ret.val);
    }
}

