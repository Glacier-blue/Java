
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 这是对Java集合框架的联系以及测试
 */
public class TestCollection {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.contains(2));
        set.remove(2);
        System.out.println(set.contains(2));
    }
    public static void main6(String[] args) {
        HashMap<Integer,String> hashMap=new HashMap<>();
        hashMap.put(1,"a");// 添加元素
        hashMap.put(2,"b");
        hashMap.put(3,"c");
        hashMap.put(4,"d");
        hashMap.put(5,"e");
        System.out.println(hashMap.get(1));//查询key对于的value
        System.out.println(hashMap.get(0));//不存在就为null
        System.out.println(hashMap.getOrDefault(0,"no exits"));//修改不存在的默认值
        hashMap.remove(1);//删除key-value
        System.out.println(hashMap.get(1));
        Set<Integer> set1 = hashMap.keySet(); // 返回key的set集合
        for(Integer i:set1){
            System.out.print(i+" ");
        }
        System.out.println();
        Collection<String> list = hashMap.values();// 返回value的集合
        for(String s:list){
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.println(hashMap.containsKey(1));//判断是否存在key
        System.out.println(hashMap.containsValue("b"));//判断是否存在value
        // 返回key-value的set集合，便于进行遍历
        Set<Map.Entry<Integer,String>> set = hashMap.entrySet();
        for(Map.Entry<Integer,String> entry:set){
            System.out.println("key = "+entry.getKey()+" and value = "+entry.getValue());
        }
    }
    public static void main5(String[] args) {
        // 默认是一个小堆
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        while(!queue.isEmpty()){
            Integer tmp=queue.poll();
            System.out.println(tmp);
        }
        //通过比较器修改为大堆
        PriorityQueue<Integer> queue2=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        queue2.offer(1);
        queue2.offer(2);
        queue2.offer(3);
        queue2.offer(4);
        while(!queue2.isEmpty()){
            Integer tmp=queue2.poll();
            System.out.println(tmp);
        }
    }
    public static void main4(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        queue.offerFirst(1);
        queue.offerLast(2);
        queue.offerLast(3);
        queue.offerFirst(0);
        System.out.println("队首元素="+queue.peekFirst());
        System.out.println("队尾元素="+queue.peekLast());
        System.out.println("出队首元素"+queue.pollFirst());
        System.out.println("出队尾元素="+queue.pollLast());
    }
    public static void main3(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.peek());//查看队首元素
        System.out.println(queue.size());//查看队列长度
        System.out.println(queue.isEmpty());//判断队列是否为空
        System.out.println(queue.poll());//出队列元素
    }
    public static void main2(String[] args) {
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        stack1.push(1);
        stack1.push(13);
        stack2.push(1);
        stack2.push(13);
        System.out.println(Objects.equals(stack1.peek(), stack2.peek()));
        // api的测试
        Deque<Integer> stack=new ArrayDeque<>(); //推荐这样写
        stack.push(1);//入栈
        int size = stack.size();//查看栈的长度
        System.out.println("topNum="+stack.peek());//查看栈顶元素
        System.out.println("size="+size);
        stack.pop();
        System.out.println(stack);
        boolean isEmpty = stack.isEmpty();
        System.out.println("是否为空="+isEmpty);

        Stack<Integer> stack3 = new Stack<>();
        stack3.push(1);
        stack3.push(2);
        stack3.push(3);
        System.out.println(stack3.search(1));
        System.out.println(stack3.search(2));
        System.out.println(stack3.search(3));
        System.out.println(stack3.search(0));
    }
    public static void main1(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);// 尾插
        for(Integer num:list){
            System.out.print(num+" ");
        }
        System.out.println();
        list.add(0,0);//在指定未知插入
        list.add(2,2);
        for(Integer num:list){
            System.out.print(num+" ");
        }
        System.out.println();
        List<Integer> ans = new ArrayList<>();
        ans.addAll(list);//尾插一个列表
        for(Integer num:ans){
            System.out.print(num+" ");
        }
        System.out.println();
        ans.addAll(1,list);//在指定位置插入一个列表
        for(Integer num:ans){
            System.out.print(num+" ");
        }
        System.out.println();
        ans.remove(1);//删除 指定下标的元素
        for(Integer num:ans){
            System.out.print(num+" ");
        }
        System.out.println();
        ans.remove(Integer.valueOf(2));// 删除 第一个指定值的元素
        for(Integer num:ans){
            System.out.print(num+" ");
        }
        System.out.println();
        int ret = list.get(1); // 得到指定位置的元素
        System.out.println(ret);
        boolean isExit = list.contains(1); // 判断某元素是否在线性表中
        System.out.println(isExit);
        int start = ans.indexOf(1); // 得到元素的第一个下标
        int end = ans.lastIndexOf(1);//得到元素最后元素的下标
        System.out.println("start="+start+" end="+end);
        ans.set(1,100); // 修改指定位置的值
        for(Integer num:ans){
            System.out.print(num+" ");
        }
    }

}
