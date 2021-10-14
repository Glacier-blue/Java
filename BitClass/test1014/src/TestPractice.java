public class TestPractice {
    public static void main(String[] args) {
        int[] arr={1,2,4,3,7,9,5,6};
        changeArr(arr);
        printArray(arr);
    }
    public static void changeArr(int[] arr){
        int i=0,j= arr.length-1;
        while(i<j){
            while(i<j&&arr[i]%2==0)
                ++i;
            while(i<j&&arr[j]%2==1)
                --j;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }


//    public static void main(String[] args) {
//        int[] arr={1,2,3};
//        printArray(arr);
//    }
    public static void printArray(int[] arr){
        for(int x:arr){
            System.out.println(x);
        }
    }
//
//
//    public static void main(String[] args) {
//        int[] arr=newarr();
//        printArray(arr);
//    }
//    public static int[] newarr(){
//        int[] arr={1,2,3,4,5};
//        return arr;
//    }
//    public static void main(String[] args){
//        int[] arr={1,2,3,4,5,6};
//        String ret=stringArr(arr);
//        System.out.println(ret);
//    }
//    public static String stringArr(int[] arr){
//        String ret="[";
//        for (int i = 0; i < arr.length ; ++i) {
//            ret+=arr[i];
//            if(i!= arr.length-1)
//                ret+=",";
//        }
//        ret+="]";
//        return ret;
//    }
//
}
