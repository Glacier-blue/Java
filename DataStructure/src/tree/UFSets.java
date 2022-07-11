package tree;


import java.util.ArrayList;
import java.util.List;

public class UFSets {

    private List<Integer> list;
    public UFSets(){
        list = new ArrayList<>();
    }
    public void init(){
        list.add(-8);
        list.add(0);
        list.add(11);
        list.add(-5);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(7);
    }
    public void display(){
        for(Integer num:list){
            System.out.print(num+" ");
        }
    }
    // 查基操作
    public int find(int x){
        int tmp = x;
        while(list.get(x)>=0){
            x=list.get(x);
        }
        // 进行压缩路径优化
        while(list.get(tmp)>=0){
            int val = list.get(tmp);
            list.set(tmp,x);
            tmp = val;
        }
        return x;
    }
    // 并集操作
    public void union(int root1,int root2){
        if(root1==root2){
            return;
        }
        if(list.get(root1) <= list.get(root2)){
            list.set(root1,list.get(root1)+ list.get(root2));
            list.set(root2,root1);
        }else{
            list.set(root2,list.get(root1)+ list.get(root2));
            list.set(root1,root2);
        }
    }

    public static void main(String[] args) {
        UFSets ufSets = new UFSets();
        ufSets.init();
        ufSets.display();
        System.out.println("\nindex="+ufSets.find(11));
        ufSets.display();
        System.out.println();
        ufSets.union(3,0);
        ufSets.display();
    }
}
