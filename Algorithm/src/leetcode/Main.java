package leetcode;

// write your code here
import java.math.BigInteger;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        BigInteger[] dp=new BigInteger[100000];
        dp[0]= BigInteger.valueOf(1);
        dp[1]= BigInteger.valueOf(2);
        dp[2]= BigInteger.valueOf(3);
        for(int i=3;i<100000;i++){
            dp[i]=dp[i-1].add(dp[i-2]);
        }
        while(sc.hasNext()){
            int n=sc.nextInt();
            int ans=dp[i-1]%100;
            System.out.println(ans);
        }
    }
}