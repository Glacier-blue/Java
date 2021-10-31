public class Main {
    public static void main(String[] args) {
        int n=10;//空瓶子数
        int count=0;//喝的水数
        while(n>=3){
            count=count+n/3;
            n=n%3+n/3;
        }
        if(n==2){
            count++;
        }
        System.out.println(count);
    }
    public static void main1(String[] args) {
        MyArrayList list=new MyArrayList();
        list.add(0,1);
        list.add(1,2);
        list.add(2,3);
        list.remove(2);
        list.display();
    }
}
//public class Main {
//    public static void main(String[] args) {
//        String s= "the sky is blue";
//        System.out.println(reverseWords(s));
//    }
//    public static String reverseWords(String s) {
//        String str="";
//        int left,right=s.length()-1;
//        int count=1;
//        while(true){
//            while(right>=0&&s.charAt(right)==' ') --right;
//
//            if(right<0) break;
//            left=right;
//            while(left>=0&&s.charAt(left)!=' ')  --left;
//            if(count!=1) str+=" ";
//            count++;
//            str+=s.substring(left+1,right+1);
//            right=left;
//            if(right<0||left<0) break;
//        }
//        return str;
//    }
//}



//public class Main {
//    public static void swap(MyValue a,MyValue b){
//        int tmp=a.num;
//        a.num=b.num;
//        b.num=tmp;
//    }
//    public static void main(String[] args) {
//        MyValue a=new MyValue();
//        MyValue b=new MyValue();
//        int m=10;
//        int n=20;
//        a.num=m;
//        b.num=n;
//        swap(a,b);
//        System.out.println(m);
//
//    }
//}
