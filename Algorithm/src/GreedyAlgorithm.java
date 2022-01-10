import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法
 */
public class GreedyAlgorithm {


    /**
     *
     * @param activity 二维数组，表示活动的开始和截至时间
     * @return 表示一天可以进行活动的最大数
     * * 先结束的活动后可以进行更多的活动
     */

    public int maxActivitySelector(int[][] activity){
        /**
         * 按照活动的截至之间进行排序
         */
        Arrays.sort(activity, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int i=0;
        int ans=1;
        for(int j=1;j<activity.length;j++){
            if(activity[j][0]>=activity[i][1]){
                i=j;
                ans++;
            }
        }
        return ans;
    }

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

    public static void main1(String[] args) {
        int[] taskTime={1,3,4,6,8,3};
        int m=4;
        int ans=minTime(taskTime,m);
        System.out.println(ans);
    }
}
