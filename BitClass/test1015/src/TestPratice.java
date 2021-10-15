public class TestPratice {
    public static void main(String[] args) {
//        String a="abcdefgh";
//        String b=a.substring(0,2);
//        System.out.println(b);
//        System.out.println(Integer.MAX_VALUE);
//        int x=123456789;
//        System.out.println(reverse(x));
        int[] digits={9,9};
        int[] ret=plusOne(digits);
        for (int x:ret) {
            System.out.println(x);
        }
    }
    public static int[] plusOne(int[] digits) {
        int n=digits.length;
        int i,flag=1;
        for(i=n-1;i>=0;--i){
            if(digits[i]!=9){
                flag=0;
                break;
            }
        }
        if(flag==1){
            int[] answer=new int[n+1];
            answer[0]=1;
            return answer;
        }
        else{
            i=n-1;
            int count=1;
            while(count!=0){
                digits[i]+=count;
                count=0;
                if(digits[i]>9){
                    digits[i]=0;
                    --i;
                    count=1;
                }
            }
            return digits;
        }
    }
//    public static int reverse(int x) {
//        int sum=0;
//        int i=0;
//        while(x!=0){
//            if(sum>(Integer.MAX_VALUE/10)||sum<(Integer.MIN_VALUE/10)){
//                i=1;
//                break;
//            }
//            sum=sum*10+x%10;
//            x/=10;
//        }
//        if(i==1){
//            return 0;
//        }
//        else{
//            return sum;
//        }
//    }
}
