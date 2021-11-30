package day1130;

import java.util.Arrays;

public class Solution {
    public static int[] spiralOrder(int[][] matrix) {
        int row=matrix.length;
        if(row==0) return new int[0];
        int col=matrix[0].length;
        if(col==0) return new int[0];
        int len=row*col;
        int[] ret=new int[row*col];
        int count=0;
        int i=0;
        int j=0;
        while(count<len){
            int flag1=i;
            int flag2=j;
            for(;count<len&&j<col;j++){
                ret[count]=matrix[i][j];
                count++;
            }
            for(j--,i++;count<len&&i<row;i++){
                ret[count]=matrix[i][j];
                count++;
            }
            for(i--,j--;count<len&&j>=flag2;j--){
                ret[count]=matrix[i][j];
                count++;
            }
            for(i--,j++;count<len&&i>=flag1;i--){
                ret[count]=matrix[i][j];
                count++;
            }
            row--;
            col--;
            i=flag1+1;
            j=flag2+1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] ret=spiralOrder(matrix);
        System.out.println(Arrays.toString(ret));
    }
}
