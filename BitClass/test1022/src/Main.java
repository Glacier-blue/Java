public class Main {
    public static void main(String[] args) {
        String needle="abcac";
        int len2=needle.length();
        int[] next=new int[len2];
        next[1]=0;
        int i=1,j=0;
        for(i=0;i<len2-1;i++){
            j=next[i];
            if(j>0&&needle.charAt(j-1)==needle.charAt(i)){
                next[i+1]=next[i]+1;
            }else{
                next[i+1]=1;
            }
        }
        for(int x:next){
            System.out.println(x);
        }
    }
}
