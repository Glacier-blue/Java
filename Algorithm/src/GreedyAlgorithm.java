import java.util.Arrays;

/**
 * 贪心算法
 */
public class GreedyAlgorithm {

    /**
     * 工厂调度问题
     * @param tackTime 每个任务需要的时间
     * @param m 表示机器的个数
     * @return 这些机器完成这些任务需要的最少时间树
     */
    public static int minTime(int[] tackTime,int m){
        int maxTime=0;
        Arrays.sort(tackTime);
        int n=tackTime.length;
        if(n<=m){
            return tackTime[n-1];
        }
        /**
         * 核心解决方案就是优先解决时间长，然后我们为已经完成的机器分配新的时间长的任务
         * 然后找出时间最长的那个机器
         */
        int[] workTime=new int[m];
        for(int i=n-1;i>=0;i--){
            int index=0;
            int time=workTime[index];
            for(int j=0;j<m;j++){
                if(workTime[j]<time){
                    time=workTime[j];
                    index=j;
                }
            }
            workTime[index]+=tackTime[i];
            maxTime=Math.max(maxTime,workTime[index]);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        int[] taskTime={1,3,4,6,8,3};
        int m=4;
        int ans=minTime(taskTime,m);
        System.out.println(ans);
    }
}
