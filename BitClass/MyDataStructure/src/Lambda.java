import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn {
    void test();
}
//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}
//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}
//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}
//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}
//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}
public class Lambda {
    public static void main(String[] args) {
        PriorityQueue<String> queue=new PriorityQueue<>(((o1, o2) ->(o2+o1).compareTo(o1+o2)));
        queue.offer("123");
        queue.offer("9");
        queue.offer("90");
        System.out.println(queue);
    }
    public static void main2(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(0);
        list.add(2);
        list.sort(((o1, o2) -> o1-o2));
        System.out.println(list);
    }
    public static void main1(String[] args) {
        NoParameterNoReturn noParameterNoReturn=()->{
            System.out.println("没有参数返回");
        };
        noParameterNoReturn.test();
        OneParameterNoReturn oneParameterNoReturn=(a)->{
            System.out.println(a);
        };
        oneParameterNoReturn.test(10);
        MoreParameterNoReturn moreParameterNoReturn=(a,b)->{
            System.out.println(a+b);
        };
        moreParameterNoReturn.test(10,20);
        NoParameterReturn noParameterReturn=()->1;
        System.out.println(noParameterReturn.test());

        OneParameterReturn oneParameterReturn=(a)->a;
        System.out.println(oneParameterReturn.test(10));

        MoreParameterReturn moreParameterReturn=(a,b)->a+b;
        System.out.println(moreParameterReturn.test(10, 20));
    }
}
