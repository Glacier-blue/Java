public class Main {
    public static   void main(String[] args) {
        int[] nums={2,1,1,2};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int numsSize=nums.length;
        if(numsSize==1){
            return nums[0];
        }
        int[] dp=new int[numsSize];
        dp[0]=nums[0];
        dp[1]=nums[1];
        for(int i=2;i<numsSize;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return Math.max(dp[numsSize-1],dp[numsSize-2]);
    }
}
