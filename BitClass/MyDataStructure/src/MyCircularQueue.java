//循环队列
public class MyCircularQueue {
    private int[] elem;//存储数组
    private int rear;//指向头部
    private int front;//指向尾巴
    private int length;//数组长度
    boolean flag=false;//标志
    public MyCircularQueue(int k){
        elem=new int[k];
        length=k;
    }
    //循环队列需要对头指针相加进行特殊处理
    public void enQueue(int x){
        if(!isFull()){
            elem[rear]=x;
            rear=(rear+1)%length;
            flag=true;
        }
    }
    public int deQueue(){
        if(!isEmpty()){
            int x=elem[front];
            front=(front+1)%length;
            flag=false;
            return x;
        }else{
            return -1;
        }
    }
    public int Front(){
        if(!isEmpty()){
            return elem[front];
        }else{
            return -1;
        }
    }
    public int Rear(){
        if(!isEmpty()){
            int index=rear==0?length-1:rear-1;
            return elem[index];
        }else{
            return -1;
        }
    }
    public boolean isFull(){
        return front==rear&&flag;
    }
    public boolean isEmpty(){
        return front==rear&&!flag;
    }

}
