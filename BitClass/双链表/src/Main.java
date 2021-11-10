public class Main {
    public static void main(String[] args) {
        DoubleLinkList list=new DoubleLinkList();
        list.addHead(1);
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.display();
        list.indexList(6,2);
        list.display();
    }
}
