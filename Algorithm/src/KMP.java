import java.util.Arrays;

public class KMP {
    public int kmp(String str,String goal){
        int n1=str.length();
        int n2=goal.length();
        if(n2==0) return 0;
        int j=0;
        int i=0;
        int[] next=next(goal);
        while(i<n1&&j<n2){
            if(j==-1||str.charAt(i)==goal.charAt(j)){
                j++;
                i++;
            }else{
                j=next[j];
            }
        }
        if(j>=n2) {
            return i - j;
        }else{
            return -1;
        }
    }
    private  int[] next(String goal){
        int[] next=new int[goal.length()];
        next[0]=-1;
        next[1]=0;
        int i=2;
        int k=0;
        while(i<next.length){
            if(k==-1||goal.charAt(k)==goal.charAt(i-1)){
                next[i]=k+1;
                i++;
                k++;
            }else{
                k=next[k];
            }
        }
        return next;
    }



    public static void main(String[] args) {
        String str1="mississippi";
        String str2="issip";
        KMP kmp=new KMP();
        System.out.println(kmp.kmp(str1, str2));
    }
}
