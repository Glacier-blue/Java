package day1201;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len=triangle.size();
        int[] dp=new int[len];
        dp[0]=triangle.get(0).get(0);
        int min=100001;
        for(int i=1;i<len;i++){
            dp[i]=dp[i-1]+triangle.get(i).get(i);
            for(int j=i-1;j>0;j--){
                dp[j]=Math.min(triangle.get(i).get(j),triangle.get(i).get(j-1))+dp[j];
            }
            dp[0]=dp[0]+triangle.get(i).get(0);
        }
        for(int i=0;i<len;i++){
            min=min<dp[i]?min:dp[i];
        }
        return min;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();

    }

}
