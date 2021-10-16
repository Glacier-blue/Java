public class PraticeDay {
    public static void main(String[] args) {
        int a=fun1();
        int b=fun2();
        System.out.println(a);
        System.out.println(b);
    }
    public static int fun1(){
        int i=100,count=0;
        do{
            ++i;
            ++count;
        }while(i<100);
        return count;
    }
    public static int fun2(){
        int i=100,count=0;
        while(i<100){
            ++i;
            ++count;
        }
        return count;
    }



//    public static void main(String[] args) {

//        String s="abcde";
//        switch (s){
//            case "ab":
//                System.out.println("ab");
//                break;
//            case "abcde":
//                System.out.println("abcde");
//                break;
//            default:
//                System.out.println("false");
//                break;
//        }
//        int x = 10;
//        int y = 20;
//        if(x==10)
//            if(y==10)
//                System.out.println("true");
//        else
//                System.out.println("false");


//       int[] height={1,8,6,2,5,4,8,3,7};
//       int a=maxArea(height);
//        System.out.println(a);
//    }
//    public static int maxArea(int[] height) {
//        int left=0,right=height.length-1;
//        int maxWater=0,nowWater,h;
//        while(left<right){
//            h=height[left]>height[right]?height[right]:height[left];
//            nowWater=h*(right-left);
//            maxWater=maxWater>nowWater?maxWater:nowWater;
//            if(height[left]>height[right]){
//                --right;
//            }
//            else{
//                ++left;
//            }
//        }
//        return maxWater;
//    }
}
