package day1202;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1=version1.split("\\.");
        String[] ver2=version2.split("\\.");
        int len1=ver1.length;
        int len2=ver2.length;
        for(int i=0;i<len1&&i<len2;i++){
            int count1=0;
            int count2=0;
            for(int j=0;j<ver1[i].length();j++){
                count1=count1*10+ver1[i].charAt(j)-97;
            }
            for(int j=0;j<ver2[i].length();j++){
                count2=count2*10+ver2[i].charAt(j)-97;
            }
            if(count1>count2) return 1;
            if(count1<count2) return -1;
        }
        for(int i=len1;i<len2;i++){
            int count2=0;
            for(int j=0;j<ver2[i].length();j++){
                count2=count2*10+ver2[i].charAt(j)-97;
            }
            if(count2!=0) return -1;
        }
        for(int i=len2;i<len1;i++){
            int count1=0;
            for(int j=0;j<ver1[i].length();j++){
                count1=count1*10+ver1[i].charAt(j)-97;
            }
            if(count1!=0) return 1;
        }
        return 0;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String version1="0.1";
        String version2="1.1";
        System.out.println(solution.compareVersion(version1, version2));
    }
}
