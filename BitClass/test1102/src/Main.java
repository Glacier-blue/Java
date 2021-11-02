public class Main {
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.addLast(2);
        list.addLast(1);
        list.removeAllKey(1);

        list.display();

    }
}

