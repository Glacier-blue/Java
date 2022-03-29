package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        char[] task={'A','A','A','B','B','B'};
        Solution solution=new Solution();
        int ret= solution.leastInterval(task,2);
        System.out.println(ret);
    }
    public int leastInterval(char[] tasks, int n) {
        int[] task=new int[26];
        for (char c : tasks) {
            task[(int) c - 65]++;
        }
        Arrays.sort(task);
        int time=0;
        while(true){
            int work=0;
            for(int i=25;i>=0;i--){
                if(work==n+1){
                    break;
                }
                if(task[i]!=0){
                    task[i]--;
                    work++;
                    time++;
                }else{
                    break;
                }
            }
            Arrays.sort(task);
            if(task[25]==0){
                break;
            }else{
                time+=n+1-work;
            }
        }
        return time;
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        double[][] car=new double[n][2];
        for(int i=0;i<n;i++){
            car[i][0]=position[i];
            car[i][1]=1.0*(target-position[i])/speed[i];
        }
        Arrays.sort(car, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return (int) ((int)o1[0]-o2[0]);
            }
        });
        int ans = 0;
        int t = n;
        while(--t>0){
            if(car[t][1]<car[t-1][1]){
                ans++;
            }else{
                car[t-1]=car[t];
            }
        }
        return ans + (t == 0 ? 1 : 0);
    }
}
