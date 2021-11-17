package data1117;

public class Main {


    public static void main(String[] args) {
        String s="abcdefg";
        String s1=s.substring(0,1);
        String s2=s.substring(0,2);
        System.out.println(s1);
        System.out.println(s2);
        String s3=new String("abcdefg");
        System.out.println(s==s3);
        System.out.println(s.equals(s3));
    }




    public static boolean isAdmin(String userId){
        return userId.toLowerCase()=="admin";
    }
    public static void main4(String[] args){
        System.out.println(isAdmin("Admin"));
        String s="adaSDA";
        s=s.toLowerCase();
        System.out.println(s);
    }
    public static void main3(String[] args) {
        String s1="abc"+"def";//1
        String s2=new String(s1);//2
        if(s1.equals(s2))//3
            System.out.println(".equals succeeded");//4
        if(s1==s2)//5
            System.out.println("==succeeded");//6
    }
    public static void main2(String[] args) {
        String str1 = "abcdefhg";
        String str2 = "abcdefhg";
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
        System.out.println("abcdefhg"==str2);
        System.out.println("abcdefhg".equals(str1));
    }
    public static void main1(String[] args) {
        String[] str=new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        Main main =new Main();
        System.out.println(main.maxProduct(str));
    }
    public int maxProduct(String[] words) {
        int max=0;
        for(int i=0;i<words.length;i++){
            int[] map=new int[26];
            for(int k=0;k<words[i].length();k++){
                map[(int)words[i].charAt(k)-97]++;
            }
            for(int j=i+1;j<words.length;j++){
                boolean flag=false;
                for(int k=0;k<words[j].length();k++){
                    if(map[(int)words[j].charAt(k)-97]!=0){
                        flag=true;
                        break;
                    }
                }
                if(flag==false){
                    if(max<words[i].length()*words[j].length()){
                        max=words[i].length()*words[j].length();
                    }
                }
            }
        }
        return max;
    }
}
