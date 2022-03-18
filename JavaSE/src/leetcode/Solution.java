package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map1=new HashMap<>();
        Map<String,Integer> map2=new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map1.put(list1[i],i);
        }
        for(int i=0;i<list2.length;i++){
            map2.put(list2[i],i);
        }
        int min=99999;
        Map<String,Integer> map3=new HashMap<>();
        int num=0;
        for(int i=0;i<list1.length;i++){
            Integer count=map2.get(list1[i]);
            if(count!=null){
                if(i+count<min){
                    num=1;
                    min=i+count;
                    map3.put(list1[i],min);
                }else if(i+count==min){
                    num++;
                    map3.put(list1[i],min);
                }
            }
        }
        String[] ans=new String[num];
        for(Map.Entry<String,Integer> entry:map3.entrySet()){
            if(entry.getValue()==min){
                ans[--num]=entry.getKey();
            }
        }
        return ans;
    }
}
