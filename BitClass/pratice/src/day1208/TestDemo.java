package day1208;
class TripleInOne {

    int[] array;
    int[] num=new int[3];
    int stackSize;
    public TripleInOne(int stackSize) {
        array=new int[stackSize*3];
        num[0]=-1;
        num[1]=stackSize-1;
        num[2]=stackSize*2-1;
        this.stackSize=stackSize;
    }

    public boolean push(int stackNum, int value) {
        if(num[stackNum]<(stackNum+1)*stackSize-1){
            array[++num[stackNum]]=value;
            return true;
        }
        return false;
    }

    public int pop(int stackNum) {
        int res;
        if(num[stackNum]>=stackNum*stackSize){
            res=array[num[stackNum]--];
        }else{
            res=-1;
        }
        return res;
    }

    public int peek(int stackNum) {
        int res;
        if(num[stackNum]>=stackNum*stackSize){
            res=array[num[stackNum]];
        }else{
            res=-1;
        }
        return res;
    }

    public boolean isEmpty(int stackNum) {
        return num[stackNum]==stackNum*stackSize-1;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        TripleInOne stack=new TripleInOne(1);
        System.out.println(stack.push(0, 1));
        System.out.println(stack.push(0, 2));
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.pop(0));
        System.out.println(stack.isEmpty(0));
    }
}
