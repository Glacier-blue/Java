package day1204;

class MyArrayList<E>{
    private E[] array;
    private int size;
    public MyArrayList(){
        this.array=(E[])new Object[20];
        size=0;
    }
    public void add(E e){
        array[size++]=e;
    }
    public E remove(){
        E element=array[size-1];
        array[size-1]=null;
        size--;
        return element;
    }
}
public class Main {
    public static void main(String[] args) {

    }
}
