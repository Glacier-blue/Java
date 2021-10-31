import java.util.Arrays;


class Person{
    public String name;
    public int age;
    {
        System.out.println("实例代码块");
    }
    static {
        System.out.println("静态代码块");
    }
    static int a=0;
}
class Test{
    public String toString() {

        System.out.print("aaa");

        return "bbb";

    }
}
public class Main {

    public static int[] func(int[] nums){
        int[] arr={0,0};
        int n=0;
        for (int x: nums) {
            n^=x;
        }

    }


    public static void main3(String[] args) {
        String s;

        System.out.println("s="+s);
    }
    private int count;
    static int cnt = 6;
    static{
        cnt += 9;
    }
    public static void main3(String[] args){
        System.out.println("cnt =" + cnt);
    }
    static{
        cnt /=3;
    };
    public static void main2(String[] args) {

        Main test=new Main(88);

        System.out.println(test.count);

    }

    Main(int a) {

        count=a;

    }
    public static void main1(String[] args) {
        Person person=new Person();
        System.out.println(person);
    }
}

//public class Main {
//    private static int x = 100;// 2
//    public static void main(String args[]) {// 3
//        Main hsl = new Main();// 4
//        hsl.x++;// 5
//        Main hs2 = new Main();// 6
//        hs2.x++;// 7
//        hsl = new Main();// 8
//        hsl.x++;// 9
//        Main.x--;// 10
//        System.out.println(" x=" + x);// 11
//    }
//    public static void main2(String[] args) {
//        int[] nums={1,2,3,4,5};
//        System.out.println(sumArr(nums));
//    }
//    public static int sumArr(int[] nums){
//        if(nums==null) return 0;
//        int sum=0;
//        for (int x: nums) {
//            sum+=x;
//        }
//        return sum;
//    }
//    public static void main1(String[] args) {
//        int[] nums={1,2,2,3,4,5};
//        System.out.println(avg(nums));
//        double[] arr={1.1,1.2,1.4};
//        System.out.println(avg(arr));
//    }
//    public static double avg(int[] nums){
//        if(nums==null) return 0;
//        int sum=0;
//        for (int x: nums) {
//            sum+=x;
//        }
//        return (double)sum*1.0/ nums.length;
//    }
//    public static double avg(double[] nums){
//        if(nums==null) return 0;
//        double sum=0;
//        for (double x:nums) {
//            sum+=x;
//        }
//        return sum/ nums.length;
//    }
//}

//class Test {
//    public static void hello() {
//        System.out.println("hello");
//    }
//    public int aMethod(){
//       int i = 0;
//        i++;
//        return i;
//    }
//}
//public class Person{
//
//    private String name = "Person";
//
//    int age=0;
//
//}
//
//
//
//public class Main {
//    static boolean Paddy;
//    public static void main(String[] args){
//
//        Person p = new Child();
//
//        System.out.println(p.name);
//
//    }
//    public static void main4(String args[]){
//        System.out.println(Paddy);
//    }
//    public static void main3(String[] args) {
//        String s=" ";
//
//        System.out.println("s="+s);
//    }
//    public static void main2(String[] args) {
//        // TODO Auto-generated method stub
//        Test test=null;
//        test.hello();
//    }
//    public static void main1(String[] args) {
//        int[] nums={1,2,3,4,5};
//        int[] cpoy=myCopyOf(nums);
//        System.out.println(Arrays.toString(cpoy));
//    }
//    public static int[] myCopyOf(int[] nums){
//        int[] copy=new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            copy[i]=nums[i];
//        }
//        return copy;
//    }
//}
