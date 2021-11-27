package day1127;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main1(String[] args) {
        Main main=new Main();
        int n=2;
        int[][] trust={{1,2}};
        int ret= main.findJudge(n,trust);
        System.out.println(ret);
    }
    public int findJudge(int n, int[][] trust) {
        boolean[][] arr=new boolean[n+1][n+1];
        for(int i=0;i<trust.length;i++){
            int a=trust[i][0];
            int b=trust[i][1];
            arr[a][b]=true;
        }
        for(int i=0;i<trust.length&&trust[i][0]==trust[0][0];i++){
            int m=trust[i][1];
            int j;
            for(j=1;j<=n;j++){
                if(m==j){
                    continue;
                }
                if(arr[m][j]==false){
                    break;
                }
            }
            if(j==n+1){
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int[][] grid={{1,2,3},{4,5,6},{7,8,9}};
        //int[][] grid={{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        int[][] grid={{1},{2},{3},{4},{5},{6},{7}};
        int k=23;
        Solution s=new Solution();
        List<List<Integer>> ret=s.shiftGrid(grid,k);
        System.out.println(ret);
    }
}
