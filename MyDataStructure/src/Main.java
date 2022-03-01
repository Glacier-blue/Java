import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String[] str=new String[n+1];
        for(int i=0;i<n+1;i++){
            str[i]=sc.nextLine();
        }
        boolean a = isSort1(str);
        boolean b = isSort2(str);
        if(a&&b){
            System.out.println("both");
        }else if(a){
            System.out.println("lexicogrphically");
        }else if(b){
            System.out.println("lengths");
        }else{
            System.out.println("none");
        }
    }
    public static boolean isSort1(String[] str){
        for(int i=2;i<str.length;i++){
            if(str[i-1].compareTo(str[i])>0){
                return false;
            }
        }
        return true;
    }
    public static boolean isSort2(String[] str){
        int preLen=str[1].length();
        for(int i=2;i<str.length;i++){
            int curLen=str[i].length();
            if(curLen<preLen){
                return false;
            }
            preLen=curLen;
        }
        return true;
    }
}