import java.util.Arrays;
import java.util.Scanner;

class Person{
    public String name;
    public int age;
    public void eat(){
        System.out.println("eat");
    }
}
public class Main {
    public static void main7(String[] args) {
        int[] arr1={1,2,3,4,5,6,7};
        int[] arr2=Arrays.copyOf(arr1,arr1.length);
        int[] arr3=Arrays.copyOfRange(arr1,1,3);
        int[] arr4=arr1.clone();
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
    }
    public static void main6(String[] args) {
        int[] arr={1,2,1,4,3,90,3452,21,23,2,34,6,5,78};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] arr1=new int[10];
        int[] arr2=new int[10];
        Arrays.fill(arr1,1);
        Arrays.fill(arr2,1,3,9);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    public static void main4(String[] args){
        Person person = new Person();
        person.name="glacierBlue";
        person.age=18;
        System.out.println(person.name);//访问成员变量
        System.out.println(person.age);
        person.eat();//访问方法
    }
    public static void main3(String[] args) {
        int[][] nums={{1,2},{4,5,6}};
        for (int[] ret: nums) {
            for(int x: ret)
                System.out.print(x+" ");
            System.out.println();
        }
        System.out.println("--------------------------------");
        System.out.println(Arrays.deepToString(nums));
    }

    public static void main2(String[] args) {
        String s="abbcdefg";
        String s1=s.substring(0,8);
        System.out.println(s1);
    }
    public static void main1(String[] args) {
        int[] nums={1,1,1,2,2,2,3,3,3,3};
        System.out.println(Arrays.toString(nums));
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int count=1;
        int slow=0,fast=1;
        while(fast<nums.length){
            if(nums[slow]!=nums[fast]){
                nums[++slow]=nums[fast++];
                count=1;
            }else{
                if(count<2){
                    nums[++slow]=nums[fast++];
                    count++;
                }else{
                    fast++;
                }
            }
        }
        return slow;
    }
}
