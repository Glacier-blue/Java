

public class PraticeDay {
    public static void main(String[] args) {
        int n=6;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
//    public static void main(String[] args) {
//        int a=Integer.MAX_VALUE,count=0;
//        for (int i = 32; i >= 0 ; i--) {
//            if((a&1)==1)
//                ++count;
//            a>>=1;
//        }
//        System.out.println(count);
//    }



//        public static void main(String[] args) {
//        int a=6 , b=4 , temp;
//        if (a < b) {
//            temp = a;
//            a = b;
//            b = temp;
//        }
//        while (a % b != 0) {
//            a = a % b;
//            temp = a;
//            a = b;
//            b = temp;
//        }
//        System.out.println(b);
//    }

//    public static void main(String[] args) {
//        int a = 10, b = 30, temp;
//        if (a < b) {
//            temp = a;
//            a = b;
//            b = temp;
//        }
//        while (a % b == 0) {
//            a = a % b;
//            temp = a;
//            a = b;
//            b = temp;
//        }
//        System.out.println(b);
//    }


//    public static void main(String[] args) {
//        double sum=0;
//        for (int i = 1; i <= 100 ; i++) {
//            if(i%2==1){
//                sum+=1.0/i;
//            }
//            else{
//                sum-=1.0/i;
//            }
//        }
//        System.out.println(sum);
//    }
//    public static void main(String[] args) {
//        for (int i = 0; i < 1000; i++) {
//            if(isNarNumber(i))
//                System.out.println(i);
//        }
//    }
//    public static boolean isNarNumber(int x){
//        if(x<100||x>=1000)
//            return false;
//        int a=x%10;
//        int b=(x/10)%10;
//        int c=x/100;
//        int num=a*a*a+b*b*b+c*c*c;
//        if(num==x)
//            return true;
//        else
//            return false;
//    }
//    public static void main(String[] args) {
//
//    }
//    public static void print(int n){
//        int row=(n+1)/2;
//    }
//    public static void main(String[] args) {
//        int age=29;
//        if(age<=18)
//            System.out.println(age+"是少年");
//        else if(age>=19&&age<=28)
//            System.out.println(age+"是青年");
//        else if(age>=29&&age<=55)
//            System.out.println(age+"是中年");
//        else
//            System.out.println(age+"是老年");
//    }

//    public static void main(String[] args) {
//        for (int i = 1; i <= 100 ; i++) {
//            if(isPrimeNumber(i)){
//                System.out.print(i+" ");
//            }
//        }
//    }
//    public static boolean isPrimeNumber(int n){
//        if(n<=2)
//            return false;
//        else {
//            for (int i = 2; i <= Math.sqrt(n); i++) {
//                if (n % i == 0)
//                    return false;
//            }
//            return true;
//        }
//    }

//import java.util.Scanner;

//    public static void main(String[] args) {
//        int j=0;
//        for (int i = 1000; i <= 2000 ; i++) {
//            if(isLeapYear(i)){
//                if(j>0&&j%20==0)
//                    System.out.println();
//                System.out.print(i+" ");
//                j++;
//            }
//        }
//    }
//    public static boolean isLeapYear(int n){
//        if(n%400==0||(n%4==0&&n%100!=0))
//            return true;
//        else
//            return false;
//    }
//    public static void main(String[] args) {
//        int count=0,m;
//        for (int i = 0; i < 100; i++) {
//            m=i;
//            while(m>0){
//                if(m%10==9)
//                    count++;
//                m/=10;
//            }
//        }
//        System.out.println(count);
//    }
}
