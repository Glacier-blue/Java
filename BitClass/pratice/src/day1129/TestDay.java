package day1129;


import java.util.*;

class StuMessage{
    private String name;
    private String classes;
    private double score;
}
public class TestDay {
        public static void main2(String[] args) {
            List<Character> list1=new ArrayList<>();
            List<Character> list2=new ArrayList<>();
            String str1="welcome to bit";
            String str2="come";
            int[] map=new int[128];
            for(int i=0;i<list2.size();i++) {
                map[list2.get(i)]++;
            }
            int i=0;
            while(i<list1.size()){
                if(map[list1.get(i)]!=0){
                    list1.remove(i);
                }else{
                    i++;
                }
            }
            System.out.println(list1);
        }
    public static void main1(String[] args) {
        char[] list1={'w','e','l','c','o','m','e',' ','t','o',' ','b','i','t'};
        char[] list2={'c','o','m','e'};
        int[] map=new int[128];
        for(int i=0;i<list2.length;i++){
            map[list2[i]]++;
        }
        int i=0,j=0;
        while(j<list1.length){
            if(map[list1[j]]==0){
                list1[i]=list1[j];
                i++;
            }
            j++;
        }
        int len=i;//修改字符串长度
        for(i=0;i<len;i++){
            System.out.print(list1[i]);
        }
    }
}
