import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(fib(100));
    }
    public static int fib(int n) {
        if(n==0){
            return 0;
        }else if(n<=2){
            return 1;
        }else{
            int predata=0;
            int nowdata=1;
            int nextdata;
            while(n-1!=0){
                nextdata=predata+nowdata;
                predata=nowdata;
                nowdata=nextdata;
                n--;
            }
            return nowdata;
        }
    }
    public static void main12(String[] args) {
        int[] nums={1,2,3,4,5,6,1,2,3,4,5};
        System.out.println(onlyNum(nums));
    }
    public static int onlyNum(int[] nums){
        int n=0;
        for (int i = 0; i < nums.length; i++) {
            n^=nums[i];
        }
        return n;
    }
    public static void main11(String[] args) {
        System.out.println(sum(1,2));
        System.out.println(sum(1.3,sum(1.1,1.2)));

    }
    public static int sum(int x,int y){
        return x+y;
    }
    public static double sum(double x,double y){
        return x+y;
    }




    public static void main10(String[] args) {
        System.out.println(max1(1,2));
        System.out.println(max1(1.1,2.2));
        System.out.println(max1(1,1.2));
        System.out.println(max1(1.2,1));
        System.out.println(max1(2,max1(1.1,1.2)));
    }
    public static double max1(double x,double y){
        return x>y?x:y;
    }
    public static double max1(int x,double y){
        return x>y?x:y;
    }
    public static double max1(double x,int y){
        return x>y?x:y;
    }

    public static void main9(String[] args) {
        int a =10;
        int b =20;
        int c =30;
        System.out.println(max1(a,b));
        System.out.println(max2(a,b,c));
    }
    public static int max1(int x,int y){
        return x>y?x:y;
    }
    public static int max2(int x,int y,int z){
        return max1(max1(x,y),z);
    }
    public static void main8(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9};
        change0ddEven(nums);
        for (int x:nums) {
            System.out.print(x+" ");
        }
    }
    public static void change0ddEven(int[] nums){
        int left=0,right= nums.length-1;
        while(left<right){
            while (left<right&&nums[left]%2==1){
                ++left;
            }
            while(left<right&&nums[right]%2==0){
                --right;
            }
            if(left<right){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                ++left;
                --right;
            }
        }
    }
    public static void main7(String[] args) {
        int n =5;
        System.out.println(fac(n));
    }
    public static void main6(String[] args) {
        int sum = 0;
        int n=3;
        for (int i = 1; i <= n; i++) {
            sum+=fac(i);
        }
        System.out.println(sum);
    }

    public static int fac (int n) {
        if(n==0){
            return 1;
        }else{
            return n*fac(n-1);
        }
    }
    public static void main5(String[] args) {
        int n =5;
        System.out.println(Fib(n));
        //0112358
    }
    public static int Fib(int n){
        if(n==1){
            return 0;
        }else if(n==2){
            return 1;
        } else{
            return Fib(n-1)+Fib(n-2);
        }
    }
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+"×"+i+"="+i*j+"   ");
            }
            System.out.println();
        }
    }

    public static void main3(String[] args) {
        int num=1234;
        getBit(num);
    }
    public static void getBit(int num){
        if(num>9)
            getBit(num/10);
        System.out.println(num%10);
    }
    public static void main2(String[] args) {
        boolean n=logMenu();
        if(n){
            System.out.println("欢迎回来");
        }else{
            System.out.println("账户锁定");
        }
    }
    public static boolean logMenu(){
        String userName="admin";
        String userPassworld="123456";
        Scanner scanner = new Scanner(System.in);
        for (int i = 3; i > 0; i--) {
            System.out.print("输入用户名>>>");
            String user= scanner.nextLine();
            System.out.print("输入密码>>>");
            String passworld= scanner.nextLine();
            if(user.equals(userName)&&passworld.equals(userPassworld)){
                System.out.println("登录成功，即将进入系统");
                return true;
            }else {
                if(i!=1)
                    System.out.println("账户或者密码错误，" + (i-1) + "次后账户锁定");
            }
        }
        return false;
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getOddBit(n));
        System.out.println(getEvenBit(n));
    }
    public static String getOddBit(int num){
        String s="";
        for (int i = 30; i >= 0; i-=2) {
            s+=(num>>i)&1;
        }
        return s;
    }
    public static String getEvenBit(int num){
        String s="";
        for(int i=31;i >= 1;i-=2){
            s+=(num>>i)&1;
        }
        return s;
    }
}
