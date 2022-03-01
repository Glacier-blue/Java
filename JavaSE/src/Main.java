import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class Main{


    public static void main(String[] args) {
        int a = (int) Math.round(11.5);
        System.out.println(a);
    }
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        String[] str=new String[50];
//        int n=0;
//        n=2;
//        str[0]="BUTTER FLOUR";
//        str[1]="HONEY FLOUR EGG";
//        while(sc.hasNextLine()){
//            str[n]=sc.nextLine();
//            n++;
//        }
//        HashSet<String> set=new HashSet<>();
//        for(int i=0;i<n;i++){
//            String[] word=str[i].split(" ");
//            for(int j=0;j<word.length;j++){
//                set.add(word[i]);
//            }
//        }
//        int ans = set.size();
//        System.out.println(ans);


//        HashMap<String,Integer> map=new HashMap<>();
//        int ans = 0;
//        for(int i=0;i<n;i++){
//            String[] word=str[i].split(" ");
//            for(int j=0;j<word.length;j++){
//                Integer count = map.get(word[j]);
//                map.put(word[j],count==null?1:count+1);
//            }
//        }
//        ans=map.size();
//        System.out.println(ans);
//    }

//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int[] arr=new int[100];
//        arr[0]=0;
//        arr[1]=1;
//        for(int i=2;i<40;i++){
//            arr[i]=arr[i-1]+arr[i-2];
//        }
//        for(int i=1;i<40;i++){
//            if(n>=arr[i-1]&&n<=arr[i]){
//                int ans=Math.min(n-arr[i-1],arr[i]-n);
//                System.out.println(ans);
//                break;
//            }
//        }
//    }
}
