package leetcode;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String s = "a0b1c2";
        String ans = new Solution().reformat(s);
        System.out.println(ans);
    }
    public String reformat(String s) {
        int[] nums = new int[10];
        int[] chars = new int[26];
        int p1 = 0;
        int p2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                nums[s.charAt(i)-'0']++;
                cnt1++;
            }else{
                chars[s.charAt(i)-'a']++;
                cnt2++;
            }
        }
        if(Math.abs(cnt1-cnt2)>1){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = true;//插入数字
        if(cnt1<cnt2){
            flag = false;//插入字符串
        }
        while(p1<=9||p2<=25){
            if(flag){
                while(p1<=9&&nums[p1]<=0){
                    p1++;
                }
                if(p1>=10) break;
                sb.append(p1);
                nums[p1]--;
                flag = false;
            }else{
                while(p2<=25&&chars[p2]<=0){
                    p2++;
                }
                if(p2>=26) break;
                char ch = (char)(p2+97);
                sb.append(ch);
                chars[p2]--;
                flag = true;
            }
        }
        return sb.toString();
    }
    public static void main10(String[] args) {
        String equation = "x+5-3+x=6+x-2";
        Solution solution = new Solution();
        String ans = solution.solveEquation(equation);
        System.out.println(ans);
    }
    private final String ANS1 =  "No solution";
    private final String ANS2 = "Infinite solutions";
    public String solveEquation(String equation) {
        String[] equ = equation.split("=");
        int[] ansleft = getParam(equ[0]);
        int[] ansright = getParam(equ[1]);
        int leftX = ansleft[1];
        int leftNum = ansleft[0];
        int rightX = ansright[1];
        int rightNum = ansright[0];
        int a = leftX - rightX;
        int b = rightNum - leftNum;
        if(a==0&&b==0){
            return ANS2;
        }else if(a==0&&b!=0){
            return ANS1;
        }else{
            return "x=" + b/a;
        }
    }
    private int[] getParam(String s){
        int[] arr = new int[2];// 0 数字系数，1方程系数
        int i = 0;
        int j = 0;
        boolean flag = true;
        while(i<s.length()){
            int num = 0;
            boolean cnt = false;
            j=i;
            while(j<s.length()){
                char c = s.charAt(i);
                if(c=='x'){
                    if(num==0&&cnt==false){
                        num = 1;
                    }
                    if(flag){
                        arr[1] += num;
                    }else{
                        arr[1] -= num;
                    }
                    j++;
                    i=j;
                    break;
                }else if(c =='-'){
                    if(flag){
                        arr[0] += num;
                    }else{
                        arr[0] -= num;
                    }
                    j++;
                    i=j;
                    flag = false;
                    break;
                }else if(c=='+'){
                    if(flag){
                        arr[0] += num;
                    }else{
                        arr[0] -= num;
                    }
                    j++;
                    i=j;
                    flag = true;
                    break;
                }else{
                    num = num*10 + c - '0';
                    cnt = true;
                    if(j==s.length()-1){
                        if(flag){
                            arr[0] += num;
                        }else{
                            arr[0] -= num;
                        }
                    }
                    j++;
                    i=j;
                }
            }
        }
        return arr;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public void preorder(TreeNode root){
        if(root==null) {
            return;
        }
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main9(String[] args) {
        int[] preorder = {1,2,4,5,3,6,7};
        int[] postorder = {4,5,2,6,7,3,1};
        Solution solution = new Solution();
        TreeNode root = solution.constructFromPrePost(preorder,postorder);
        solution.preorder(root);
    }
    private int preIndex;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        preIndex = 0;
        return constructFromPrePost(preorder,postorder,0,postorder.length-1);
    }
    private TreeNode constructFromPrePost(int[] preorder,int[] postorder,int l,int r){
        if(l>r) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if(preIndex>=preorder.length){
            return root;
        }
        int index = findElem(postorder,preorder[preIndex],l,r-1);
        if(index==-1){
            return root;
        }
        root.left = constructFromPrePost(preorder,postorder,l,index);
        root.right = constructFromPrePost(preorder,postorder,index+1,r-1);
        return root;
    }
    private int findElem(int[] postorder,int num,int l,int r){
        for(int i = l; i <= r; i++){
            if(postorder[i]==num){
                return i;
            }
        }
        return -1;
    }
    public static void main8(String[] args) {
        int[][] isInfected = {{0,1,0,0,0,0,0,1},{0,1,0,0,0,0,0,1},{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0}};
        Solution solution = new Solution();
        int ans = solution.containVirus(isInfected);
        System.out.println(ans);
    }
    public int containVirus(int[][] isInfected) {
        int ans = 0;
        for(int i = 0; i < isInfected.length;i++){
            for(int j = 0; j < isInfected[0].length; j++){
                if(isInfected[i][j]==1){
                    if(i-1>=0&&isInfected[i-1][j]==0){
                        ans++;
                    }
                    if(i+1<isInfected.length&&isInfected[i+1][j]==0){
                        ans++;
                    }
                    if(j-1>=0&&isInfected[i][j-1]==0){
                        ans++;
                    }
                    if(j+1<isInfected[0].length&&isInfected[i][j+1]==0){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }


    public static void main7(String[] args) {
        char[] task={'A','A','A','B','B','B'};
        Solution solution=new Solution();
        int ret= solution.leastInterval(task,2);
        System.out.println(ret);
    }
    public int leastInterval(char[] tasks, int n) {
        int[] task=new int[26];
        for (char c : tasks) {
            task[(int) c - 65]++;
        }
        Arrays.sort(task);
        int time=0;
        while(true){
            int work=0;
            for(int i=25;i>=0;i--){
                if(work==n+1){
                    break;
                }
                if(task[i]!=0){
                    task[i]--;
                    work++;
                    time++;
                }else{
                    break;
                }
            }
            Arrays.sort(task);
            if(task[25]==0){
                break;
            }else{
                time+=n+1-work;
            }
        }
        return time;
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        double[][] car=new double[n][2];
        for(int i=0;i<n;i++){
            car[i][0]=position[i];
            car[i][1]=1.0*(target-position[i])/speed[i];
        }
        Arrays.sort(car, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return (int) ((int)o1[0]-o2[0]);
            }
        });
        int ans = 0;
        int t = n;
        while(--t>0){
            if(car[t][1]<car[t-1][1]){
                ans++;
            }else{
                car[t-1]=car[t];
            }
        }
        return ans + (t == 0 ? 1 : 0);
    }
    public static void main6(String[] args) {
//        int[] arr = new int[]{1,1,2};
        int[] arr = new int[]{10,10,10};
        Solution solution = new Solution();
        int ans = solution.numRabbits(arr);
        System.out.println(ans);
    }

    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : answers){
            Integer cnt = map.get(num);
            map.put(num,cnt==null?1:cnt+1);
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            Integer num1 = entry.getKey();//还有数量
            Integer num2 = entry.getValue();//次数
            int a = num2%(num1+1);
            int b = num2/(num1+1);
            if(a==0){
                ans += (num1+1)*b;
            }else{
                ans += (num1+1)*(b+1);
            }
        }
        return ans;
    }
    public static void main5(String[] args) {
        Solution solution = new Solution();
        int[] input = {-2,-1,1,2};
        int[] ans = solution.asteroidCollision(input);
        System.out.println(Arrays.toString(ans));
    }
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        int pos = 0;
        while(pos<asteroids.length){
            Integer top = stack.peek();
            if(top==null||top*asteroids[pos]>0||top<0&&asteroids[pos]>0){
                stack.push(asteroids[pos]);
                pos++;
            }else{
                int tmp = asteroids[pos];
                if(tmp+top==0){
                    stack.pop();
                    pos++;
                }else if(Math.abs(tmp)>Math.abs(top)){
                    stack.pop();
                }else{
                    pos++;
                }
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for(int i = size - 1; i >= 0; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main4(String[] args) {
        Solution solution=new Solution();
        List<ListNode> l1=solution.getList1();
        List<ListNode> l2=solution.getList2();
        List<ListNode> a1=solution.getAnswer();
        int sum=0;
        long begin=System.currentTimeMillis();
        for(int i=0;i<l1.size();i++){
            ListNode ans=solution.addTwoNumbers(l1.get(i),l2.get(i));
            if(solution.isSame(ans,a1.get(i))){
                sum++;
            }else {
                System.out.println("Pass: "+sum+"/"+a1.size());
                System.out.println("Last Input1:"+solution.ListNodeToString(l1.get(i)));
                System.out.println("Last Input2:"+solution.ListNodeToString(l2.get(i)));
                System.out.println("Answer:"+ solution.ListNodeToString(a1.get(i)));
                System.out.println("Your Answer:"+ solution.ListNodeToString(ans));
                System.exit(0);
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("Time:"+(end-begin));
    }

    private ListNode addTwoNumbers(ListNode listNode, ListNode listNode1) {
        return null;
    }

    private String ListNodeToString(ListNode head){
        if(head==null) {
            return "[]";
        }
        StringBuilder sb=new StringBuilder();
        sb.append('[');
        while(head!=null){
            sb.append(head.val);
            sb.append(',');
            head=head.next;
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(']');
        return sb.toString();
    }
    private boolean isSame(ListNode head1,ListNode head2){
        while(head1!=null&&head2!=null){
            if(head1.val!=head2.val){
                return false;
            }
            head1=head1.next;
            head2=head2.next;
        }
        return head1==null&&head2==null;
    }
    private List<ListNode> getList1(){
        List<ListNode> ans=new ArrayList<>();
        ans.add(arrToList(new int[]{2,4,3}));
        ans.add(arrToList(new int[]{0}));
        ans.add(arrToList(new int[]{9,9,9,9,9,9,9}));
        ans.add(arrToList(new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}));
        return ans;
    }
    private List<ListNode> getList2(){
        List<ListNode> ans=new ArrayList<>();
        ans.add(arrToList(new int[]{5,6,4}));
        ans.add(arrToList(new int[]{0}));
        ans.add(arrToList(new int[]{9,9,9,9}));
        ans.add(arrToList(new int[]{9,9,9,1,1,4,5}));
        return ans;
    }
    private List<ListNode> getAnswer(){
        List<ListNode> ans=new ArrayList<>();
        ans.add(arrToList(new int[]{7,0,8}));
        ans.add(arrToList(new int[]{0}));
        ans.add(arrToList(new int[]{8,9,9,9,0,0,0,1}));
        ans.add(arrToList(new int[]{0,0,0,2,1,4,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}));
        return ans;
    }
    private ListNode arrToList(int[] arr){
        ListNode head=new ListNode(arr[0]);
        ListNode p=head;
        for(int i=1;i<arr.length;i++){
            p.next=new ListNode(arr[i]);
            p=p.next;
        }
        return head;
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
    public static void main1(String[] args) {
        Solution solution=new Solution();
        List<int[]> test=solution.getTestEg2321();
        List<Integer> target=solution.getTarget123();
        List<int[]> answer=solution.getAnswer21321();
        int sum=0;
        Long begin=System.currentTimeMillis();
        for(int i=0;i< target.size();i++){
            int[] ret=solution.twoSum(test.get(i), target.get(i) );
            Arrays.sort(ret);
            if(Arrays.equals(answer.get(i), ret)){
                sum++;
            }else{
                System.out.println("Pass: "+sum+"/"+test.size());
                System.out.println("Last Input:"+ Arrays.toString(test.get(i))+"and target="+target.get(i));
                System.out.println("Answer:"+ Arrays.toString(answer.get(i)));
                System.out.println("Your Answer:"+ Arrays.toString(ret));
                System.exit(0);
            }
        }
        Long end=System.currentTimeMillis();
        System.out.println(target.size()+"/"+target.size()+" All Yes");
        System.out.println("Time:"+(end-begin));
    }
    private List<int[]> getTestEg2321(){
        List<int[]> ans=new ArrayList<>();
        ans.add(new int[]{2,7,11,5});
        ans.add(new int[]{3,2,4});
        ans.add(new int[]{3,3});
        ans.add(new int[]{1,2,3,4});
        return ans;
    }
    private List<Integer> getTarget123(){
        List<Integer> ans=new ArrayList<>();
        ans.add(9);
        ans.add(6);
        ans.add(6);
        ans.add(7);
        return ans;
    }
    private List<int[]> getAnswer21321(){
        List<int[]> ans=new ArrayList<>();
        ans.add(new int[]{0,1});
        ans.add(new int[]{1,2});
        ans.add(new int[]{0,1});
        ans.add(new int[]{3,4});
        return ans;
    }
    public static void main3(String[] args) {
        Solution solution=new Solution();
        int[] dp=solution.getFib();
        for(int i=1;i<31;i++){
            int ret=solution.fib(i);
            if(ret==dp[i]){
                System.out.println("case"+i+"is OK");
            }else{
                System.out.println("case"+i+"is failed");
                System.out.println("最后执行的测试数据"+i+"\n期望的结果"+dp[i]+"\n你的结果"+ret);
                break;
            }
        }
    }

    private int fib(int i) {
        if(i==0){
            return 0;
        }else if(i==1){
            return 1;
        }else{
            return fib(i-1)+fib(i-2);
        }
    }

    private int[] getFib(){
        int[] dp=new int[31];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<31;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp;
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0) {
            return 0;
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int mul=nums[i];
            int j=i+1;
            while(mul<k){
                ans++;
                if(j<nums.length){
                    mul*=nums[j++];
                }else{
                    break;
                }
            }
        }
        return ans;
    }

    /**
     *	正数数组中的最小不可组成和
     *	输入：正数数组arr
     *	返回：正数数组中的最小不可组成和
     */
    public static void main2(String[] args) {
        int[] arr={3,2,4,1,1};
        Solution solution=new Solution();
        int ans= solution.getFirstUnFormedNum(arr);
        System.out.println(ans);
    }
    private Set<Integer> set=new HashSet<>();
    public int getFirstUnFormedNum(int[] arr) {
        Arrays.sort(arr);
        int len=remove(arr);
        int[] array=new int[len];
        int min=arr[0];
        int max=0;
        for(int i=0;i<len;i++){
            array[i]=arr[i];
            max+=array[i];
        }
        dfs(array,0,0);
        for(int i=min;i<=max;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return max+1;
    }
    public void dfs(int[] arr,int pos,int sum){

        for(int i=pos;i<arr.length;i++){
            set.add(sum+arr[i]);
            dfs(arr,i+1,sum+arr[i]);
        }
    }
    public static int remove(int[] arr){
        int low=0;
        int high=1;
        while(high<arr.length){
            if(arr[high]!=arr[low]){
                arr[++low]=arr[high];
            }
            high++;
        }
        return low+1;
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map1=new HashMap<>();
        Map<String,Integer> map2=new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map1.put(list1[i],i);
        }
        for(int i=0;i<list2.length;i++){
            map2.put(list2[i],i);
        }
        int min=99999;
        Map<String,Integer> map3=new HashMap<>();
        int num=0;
        for(int i=0;i<list1.length;i++){
            Integer count=map2.get(list1[i]);
            if(count!=null){
                if(i+count<min){
                    num=1;
                    min=i+count;
                    map3.put(list1[i],min);
                }else if(i+count==min){
                    num++;
                    map3.put(list1[i],min);
                }
            }
        }
        String[] ans=new String[num];
        for(Map.Entry<String,Integer> entry:map3.entrySet()){
            if(entry.getValue()==min){
                ans[--num]=entry.getKey();
            }
        }
        return ans;
    }

}
