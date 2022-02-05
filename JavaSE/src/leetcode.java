import java.util.Arrays;

class Solution {
    private int maxValue=0;
    public int getMaximumGold(int[][] grid) {
        maxValue=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dfs(i,j,grid,0);
            }
        }
        return maxValue;
    }
    public void dfs(int i,int j,int[][] grid,int value){
        value+=grid[i][j];
        if(value>maxValue){
            maxValue=value;
        }
        if(i+1<grid.length&&grid[i+1][j]!=0){
            int tmp=grid[i][j];
            grid[i][j]=0;
            dfs(i+1,j,grid,value);
            grid[i][j]=tmp;
        }
        if(i-1>=0&&grid[i-1][j]!=0){
            int tmp=grid[i][j];
            grid[i][j]=0;
            dfs(i-1,j,grid,value);
            grid[i][j]=tmp;
        }
        if(j-1>=0&&grid[i][j-1]!=0){
            int tmp=grid[i][j];
            grid[i][j]=0;
            dfs(i,j-1,grid,value);
            grid[i][j]=tmp;
        }
        if(j+1<grid[0].length&&grid[i][j+1]!=0){
            int tmp=grid[i][j];
            grid[i][j]=0;
            dfs(i,j+1,grid,value);
            grid[i][j]=tmp;
        }
    }
}


public class leetcode {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[][] grid={{23,21,38,12,18,36,0,7,30,29,20,3,28},{23,3,19,2,1,11,4,8,9,24,6,5,35}};
        int ret = solution.getMaximumGold(grid);
        System.out.println(ret);
        System.out.println(Arrays.deepToString(grid));
    }
}
