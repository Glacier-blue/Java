package leetcode;

import java.util.*;

public class Solution {
    /**
     *	正数数组中的最小不可组成和
     *	输入：正数数组arr
     *	返回：正数数组中的最小不可组成和
     */
    public static void main(String[] args) {
        int[] arr={3,2,4,1,1};
        Solution solution=new Solution();
        int ans= solution.getFirstUnFormedNum(arr);
        System.out.println(ans);
    }
    private Set<Integer> set=new HashSet<>();
    public int getFirstUnFormedNum(int[] arr) {
        Arrays.sort(arr);
        int len=remove(arr);
        int[] array=new int[len];
        int min=arr[0];
        int max=0;
        for(int i=0;i<len;i++){
            array[i]=arr[i];
            max+=array[i];
        }
        dfs(array,0,0);
        for(int i=min;i<=max;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return max+1;
    }
    public void dfs(int[] arr,int pos,int sum){

        for(int i=pos;i<arr.length;i++){
            set.add(sum+arr[i]);
            dfs(arr,i+1,sum+arr[i]);
        }
    }
    public static int remove(int[] arr){
        int low=0;
        int high=1;
        while(high<arr.length){
            if(arr[high]!=arr[low]){
                arr[++low]=arr[high];
            }
            high++;
        }
        return low+1;
    }

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
