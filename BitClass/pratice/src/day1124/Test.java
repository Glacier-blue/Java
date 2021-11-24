package day1124;

class MyArrays<E>{
    private E[] elem;
    private int usedSize;
    public MyArrays(){
        this.elem=(E[])new Object[10];
    }
    public void add(E val){
        this.elem[usedSize]=val;
        this.usedSize++;
    }
    public E get(int pos){
        return elem[pos];
    }
}
public class Test {
    public static void main(String[] args) {
        MyArrays<String> list1=new MyArrays<String>();
        MyArrays<Integer> list2=new MyArrays<Integer>();
        list1.add("abcd");
        list2.add(1);
        int ret=list2.get(0);
        String ret2=list1.get(0);
        System.out.println(ret+ret2);
    }
}
