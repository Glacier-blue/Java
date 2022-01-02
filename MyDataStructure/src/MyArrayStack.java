import java.util.Arrays;

public class MyArrayStack{
    private int[] elem;
    private int size=-1;
    public MyArrayStack(int k){
        elem=new int[k];
    }
    public MyArrayStack(){
        elem=new int[10];
    }
    public void push(int val){
        if(full()){
            elem= Arrays.copyOf(elem,2*elem.length);
        }
        elem[++size]=val;
    }
    public int size(){
        return this.size+1;
    }
    public int peek(){
        if(!empty()){
            return elem[size];
        }else{
            return -1;
        }
    }
    public int pop(){
        if(!empty()){
            return elem[size--];
        }else{
            return -1;
        }
    }
    public boolean empty(){
        return size==-1;
    }
    public boolean full(){
        return size==elem.length-1;
    }
}
