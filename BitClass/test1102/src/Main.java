public class Main {
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.display();
        list.addFirst(7);
        list.display();
        list.addIndex(1,9);
        list.display();
        list.remove(2);
        list.removeAllKey(1);
        list.display();
    }
}

