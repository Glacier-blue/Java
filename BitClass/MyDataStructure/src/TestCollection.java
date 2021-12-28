import java.util.*;

/**
 * 这是对Java集合框架的联系以及测试
 */
public class TestCollection {
    public static void main(String[] args) {
//        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        queue.offer(1);
//        queue.offer(2);
//        queue.offer(3);
//        queue.offer(4);
//        while(!queue.isEmpty()){
//            Integer tmp=queue.poll();
//            System.out.println(tmp);
//        }
    }
    //对Map和Set的测试
    public static void main2(String[] args) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        Set<Integer> hashSet=new HashSet<>();
        Random random=new Random();
        int[] nums=new int[10_0000];
        for(int i=0;i< nums.length;i++){
            nums[i]= random.nextInt(10000);
        }
        for(int i=0;i< nums.length;i++){
            if(hashSet.contains(nums[i])){
                System.out.println(nums[i]);
                break;
            }else{
                hashSet.add(nums[i]);
            }
        }
        for(int i=0;i< nums.length;i++){
            Integer count=hashMap.get(nums[i]);
            hashMap.put(nums[i],count==null?1:count+1);
        }
        Set<Map.Entry<Integer,Integer>> set=hashMap.entrySet();
        for(Map.Entry<Integer,Integer> entry:set){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
    public static void main1(String[] args) {
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        stack1.push(1);
        stack1.push(13);
        stack2.push(1);
        stack2.push(13);
        System.out.println(stack1.peek()==stack2.peek());
    }
}
