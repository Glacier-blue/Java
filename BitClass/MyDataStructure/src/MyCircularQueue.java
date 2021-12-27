//循环队列
class MyCircularQueue {
    private int[] elem;
    private int len;
    private int front;
    private int rear;
    public MyCircularQueue(int k) {
        this.elem=new int[k+1];
        this.len=k+1;
        this.front=0;
        this.rear=0;
    }

    public boolean enQueue(int value) {
        if(isFull())  return false;
        elem[this.rear]=value;
        this.rear=(this.rear+1)%this.len;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        this.front=(this.front+1)%this.len;
        return true;
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
            int index=(this.rear==0)?len-1:this.rear-1;
            return elem[index];
        }else{
            return -1;
        }
    }

    public boolean isEmpty() {
        return this.rear==this.front;
    }

    public boolean isFull() {
        return (this.rear+1)%len==this.front;
    }
}
