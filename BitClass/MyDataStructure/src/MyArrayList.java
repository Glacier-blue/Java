import java.util.Arrays;


public class MyArrayList {
    private int[] elem;
    private int usedSize;//有效的数据个数
    public MyArrayList() {
        this.elem = new int[10];
    }

    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    // 获取顺序表的有效数据长度
    public int size() {
        return this.usedSize;
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if(pos<0||pos>this.usedSize){
            System.out.println("输入不合法");
            return;
        }
        if(isFull()){
            this.elem= Arrays.copyOf(this.elem,this.elem.length+10);
        }
        for(int i=this.usedSize-1;i>=pos;i--){
            elem[i+1]=elem[i];
        }
        elem[pos]=data;
        this.usedSize++;
    }
    //判断表是否满
    public boolean isFull() {
        return this.usedSize==this.elem.length;
    }
    //判断表是否为空
    public boolean isEmpty(){
        return this.usedSize==0;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int x: elem) {
            if(x==toFind) return true;
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < elem.length; i++) {
            if(elem[i]==toFind) return i;
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos<0||pos>=this.usedSize){
            return -1;
        }
        if(isEmpty()){
            System.out.println("顺序表为空");
            return -1;
        }
        return elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if(isEmpty()){
            System.out.println("顺序表为空");
            return;
        }
        if(pos<0||pos>=this.usedSize){
            System.out.println("输入不合法");
        }else{
            this.elem[pos]=value;
            System.out.println("设置成功");
        }
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        if(isEmpty()){
            System.out.println("顺序表为空");
            return;
        }
        int pos=this.search(toRemove);
        if(pos==-1){
            System.out.println("删除元素不存在");
        }else{
            for(int i=pos;i<this.usedSize-1;i++){
                elem[i]=elem[i+1];
            }
            this.usedSize--;
            System.out.println("删除成功");
        }
    }
    // 清空顺序表
    public void clear() {
        for(int i=0;i<this.usedSize;i++){
            this.elem[i]=0;
        }
        this.usedSize=0;
        System.out.println("成功清空表");
    }
}
