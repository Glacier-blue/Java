package day1129;
class Solution {
    public boolean oneEditAway(String first, String second) {
        int flag=1;
        if(first.length()-second.length()>=2||first.length()-second.length()<=-2){
            return false;
        }
        int i=0,j=0;
        while(i<first.length()&&j<second.length()){
            if(first.charAt(i)!=second.charAt(i)){
                if(flag!=1) return false;
                if(first.length()>second.length()){
                    i++;
                }else if(second.length()>first.length()){
                    j++;
                }else{
                    i++;
                    j++;
                }
                flag--;
            }else{
                i++;
                j++;
            }
        }
        return true;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        String f="pales";
        String sec="palea";
        System.out.println(s.oneEditAway(f, sec));
    }
}
