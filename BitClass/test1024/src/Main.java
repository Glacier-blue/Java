import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr=new int[100];
        for(int i=0;i<100;i++){
            arr[i]=i+1;
        }
    }
    public static void main16(String[] args) {
        int[] arr={1,2,3,4,5,6};
        printfArray(arr);
    }
    public static void printfArray(int[] arr){
        for (int x:
             arr) {
            System.out.print(x+" ");
        }
    }
    public static void main14(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
        changeNums1(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void changeNums1(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            nums[i]=2*nums[i];
        }
    }
    public static void main12(String[] args) {
        int[] arr={1,2,2,3,4,5};
        System.out.println(avg(arr));
        System.out.println(addNums(arr));
    }
    public static int addNums(int[] nums){
        int sum=0;
        for (int x:
             nums) {
            sum+=x;
        }
        return sum;
    }
    public static double avg(int[] arr){
        if(arr==null){
            return 0;
        }
        int sum=0;
        int len=arr.length;
        for (int i = 0; i < len; i++) {
            sum+=arr[i];
        }
        return (double)sum*1.0/len;
    }

    public static void main11(String[] args) {
//        int[3] arr1={1,2,3};
//        int[] arr2=new int[3]{1,2,3};
//        int[3] arr3=new int[3]{1,2,3};
    }


    public static void main10(String[] args) {
        int[] arr={0,0,0,0,};
        System.out.println(Arrays.toString(arr));
        changeNums(arr);
        System.out.println(Arrays.toString(arr));
        changeNums2(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void changeNums(int[] arr){
        arr=new int[]{1,1,1,1,1};
    }
    public static void changeNums2(int[] arr){
        arr[0]=1;
        arr=new int[]{1,2,3,4};
    }
    public static void main9(String[] args) {
        int[] nums1={1,2,3,4};
        int[] nums2=nums1;
        System.out.println(nums1==nums2);
        nums2=new int[]{1,2,3,4};
        System.out.println(nums1==nums2);
    }


    public static void main8(String[] args) {
        String s=getStr();
        System.out.println(s);
    }

    public static String getStr() {
        String s="abcdefg";
        return s;
    }
    public static void main7(String[] args) {
        int[] arr={0,0,0,0,0,0};
        changeArr(arr);
        for (int x:
             arr) {
            System.out.print(x+" ");
        }
    }
    public static void changeArr(int[] arr){
        arr[0]=1;
        arr[1]=2;
    }
    public static void main6(String[] args) {
        int num=10;
        changeNum(num);
        System.out.println(num);
    }
    public static void changeNum(int x){
        x=0;
    }



    public static void main5(String[] args) {
        int[] arr={1,2,3,4,5,6};
        printfArr(arr);
    }
    public static void printfArr(int[] nums){
        for (int x: nums) {
            System.out.print(x+" ");
        }
    }




    public static void main4(String[] args) {
        int[] array={1,2,3,4,5,6};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        for (int x:array) {
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println(Arrays.toString(array));
    }



    public static String myToString(int[] nums){
        int len= nums.length;
        String s="[";
        for(int i=0;i<len;i++){
            s+=nums[i];
            if(i!=len-1){
                s+=',';
            }
        }
        s+="]";
        return s;
    }

    public static void main3(String[] args) {
        int[] nums={1};
        System.out.println(myToString(nums));
    }
    public static void main2(String[] args) {
        int[] nums=returnArr();
        System.out.println(Arrays.toString(nums));
    }
    public static int[] returnArr(){
        int[] arr={1,2,3,4,5};
        return arr;
    }
    public static void main1(String[] args) {
        String s="-2147483647";
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String s) {
        int len=s.length(),i=0;
        long num=0;
        char flag='+';
        while(i<len&&s.charAt(i)==' '){
            ++i;
        }
        if(i<len&&(s.charAt(i)=='-'||s.charAt(i)=='+')){
            flag=s.charAt(i);
            ++i;
        }
        while(i<len&&(int)s.charAt(i)>=48&&(int)s.charAt(i)<=57){
            num=num*10+(int)s.charAt(i)-48;
            ++i;
            if(flag=='-'&&(-num)<=Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            if(flag!='-'&&num>=Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }
        if(flag=='-'){
            return (int)(-num);
        }else{
            return (int)num;
        }
    }
}
