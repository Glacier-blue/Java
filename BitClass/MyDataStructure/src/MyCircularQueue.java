//循环队列
class MyCircularQueue {
    private int[] elem;
    private int len;
    private int front;
    private int rear;
    private boolean flag=false;
    public MyCircularQueue(int k) {
        this.elem=new int[k];
        this.len=k;
        this.front=0;
        this.rear=0;
    }

    public boolean enQueue(int value) {
        if(isFull())  return false;
        elem[this.rear]=value;
        this.rear=(this.rear+1)%this.len;
        flag=true;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        this.front=(this.front+1)%this.len;
        flag=false;
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
        return this.rear==this.front&&!this.flag;
    }

    public boolean isFull() {
        return this.flag&&this.rear==this.front;
    }
}
