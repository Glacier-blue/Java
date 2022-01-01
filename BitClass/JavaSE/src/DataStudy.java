import java.util.Arrays;

public class DataStudy {
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5,6,7};
        int[] arr2=Arrays.copyOf(arr1,arr1.length);//拷贝所有
        int[] arr3=Arrays.copyOfRange(arr1,1,3);//拷贝下标[1,3)之间的元素
        int[] arr4=arr1.clone();//拷贝所有
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
    }
    public static void main5(String[] args) {
        int[] arr={1,2,1,4,3,90,3452,21,23,2,34,6,5,78};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main4(String[] args) {
        int[] arr1=new int[10];
        int[] arr2=new int[10];
        Arrays.fill(arr1,1);//将所有元素填充为1
        Arrays.fill(arr2,1,3,9);//将下标[1,3)填充为9
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    public static void main3(String[] args) {
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
    public static void main2(String[] args) {
        int x = 10;
        int y = 20;
        if(x==10)
            if(y==10)
                System.out.println("true");
        else
            System.out.println("false");
    }
    public static void main1(String[] args) {
        byte a=127;
        a=(byte) 128;
        System.out.println(a);
        Integer a1=100;
        Integer a2=100;
        Integer a3=180;
        Integer a4=180;
        System.out.println("a1==a2:"+(a1==a2));//true
        System.out.println("a3==a4:"+(a3==a4));//false
        System.out.println("a3.equlas(a4):"+a3.equals(a4));//true
    }
}
