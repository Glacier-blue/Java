public class Main {
    public static void main(String[] args) {
        String s="2147483648";
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String s) {
        int len=s.length(),i=0;
        int num=0;
        char flag='+';
        while(i<len){
            while(i<len&&s.charAt(i)==' '){
                ++i;
            }
            if(i==len){
                break;
            }
            if(s.charAt(i)=='-'||s.charAt(i)=='+'){
                flag=s.charAt(i);
                ++i;
            }
            while(i<len&&(int)s.charAt(i)>=48&&(int)s.charAt(i)<=57){
                if(flag=='-'&&(-num)<=Integer.MIN_VALUE/10){
                    return Integer.MIN_VALUE;
                }
                else if(num>=Integer.MAX_VALUE/10){
                    return Integer.MAX_VALUE;
                }
                else{
                    num=num*10+(int)s.charAt(i)-48;
                    ++i;
                }
            }
            break;
        }
        if(flag=='-'){
            return (-num);
        }
        else{
            return num;
        }
    }


//    public static void main(String[] args) {
//        String s="aaaaaaa";
//        System.out.println(s.charAt(0)==s.charAt(1));
//    }
//    public static void main(String[] args) {
//        int a=1;
//        String s="abcd";
//        s+=a;
//        int b = (int)s.charAt(4);
//        String c=s.charAt(4);
//        System.out.printf(c);
//        System.out.println(s);
//        int[] arr;
//        arr=new int[]{1,2,3,4,5};
//        int[] str= new int[6];
//        str[0]=1;
//        str=new int[6];
//        String s="abcde";
//        char a=98;
//        System.out.println(a);
//        char a=s.charAt(2);
//        System.out.printf("%d\n",(int)a);
//        System.out.println(a);
//        String s="pwwkew";
//        System.out.println(lengthOfLongestSubstring(s));
//
//    }
//    public static int lengthOfLongestSubstring(String s) {
//        int[] arr=new int[128];
//        int max=0;
//        int i=0,j=0;
//        while(j<s.length()) {
//            while (j<s.length()&&arr[(int) s.charAt(j)] == 0) {
//                arr[(int) s.charAt(j)]++;
//                ++j;
//            }
//            if(j>=s.length())
//                break;
//            max = max > (j - i) ? max : (j - i);
//            while (s.charAt(i) !=s.charAt(j)) {
//                arr[(int) s.charAt(i)] = 0;
//                ++i;
//            }
//            arr[(int)s.charAt(i)]=0;
//            ++i;
//        }
//        return max;
//    }

}
