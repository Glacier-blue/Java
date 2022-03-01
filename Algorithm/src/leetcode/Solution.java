package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
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
