package list;

//循环队列
public class MyCircularQueue {
    private final int[] elem;
    private int size;
    private int front;
    private int rear;
    public MyCircularQueue(int k) {
        this.elem=new int[k];
    }

    public void enQueue(int value) {
        if(isFull()) {
            return;
        }
        elem[this.rear]=value;
        size--;
        rear++;
        if(rear==elem.length){
            rear=0;
        }
    }

    public void deQueue() {
        if(isEmpty()) {
            return;
        }
        front++;
        if(front==elem.length){
            front=0;
        }
        size--;
    }

    public int Front() {
        if(!isEmpty()){
            return this.elem[this.front];
        }else{
            return -1;
        }
    }

    public int Rear() {
        if(!isEmpty()){
            return this.elem[rear];
        }else{
            return -1;
        }
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size== elem.length;
    }
}
