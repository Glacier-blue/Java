public class Main {
    public static void main(String[] args) {
        int[] nums={200,30,140,20,10};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int len=nums.length;
        int ret=Math.max(robMax(nums,0,len-2),robMax(nums,1,len-1));
        return ret;
    }
    public static int robMax(int[] nums,int left,int right){
        if(left>right) return 0;
        if(left==right) return nums[left];
        int[] dp=new int[right-left+1];
        dp[0]=nums[left];
        dp[1]=Math.max(nums[left],nums[left+1]);
        for(int i=2;i<right-left+1;i++){
            dp[i]=Math.max(dp[i-2]+nums[i+left],dp[i-1]);
        }
        return dp[right-left];
    }
}
