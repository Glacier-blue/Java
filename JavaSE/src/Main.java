import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Deque<Integer> stack=new LinkedList<>();
        while(sc.hasNext()){
            int n=sc.nextInt();
            String s = sc.nextLine();
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(ch==' '){
                    i++;
                }
                if(ch!='+'&&ch!='-'&&ch!='*'&&ch!='/'){
                    Integer tmp=ch-48;
                    stack.push(tmp);
                }else{
                    operation(stack,ch);
                }
            }
            if(!stack.isEmpty()){
                Integer ans=stack.pop();
                System.out.println(ans);
            }
        }
    }
    public static void operation(Deque<Integer> stack,char c){
        if(stack.isEmpty()){
            return;
        }
        int a=stack.pop();
        if(stack.isEmpty()){
            return;
        }
        int b=stack.pop();
        if(c=='='){
            stack.push(a+b);
        }else if(c=='-'){
            stack.push(b-a);
        }else if(c=='/'){
            stack.push(b/a);
        }else{
            stack.push(a*b);
        }
    }
    public static void main1(String[] args) {
        int nums1=123;
        int nums2=234;
        int ret=new Main().Add(nums1,nums2);
        System.out.println(ret);
        for(int i=1,j=2;i<20&&j<20;i++,j++){
            nums1++;
        }
        System.out.println(nums1);
    }
    public int Add(int num1,int num2) {
        int[] ans=new int[32];
        boolean flag=false;
        for(int i=0;i<32;i++){
            int a=num1>>i;
            int b=num2>>i;
            if(a==1&&b==1){
                if(flag){
                    ans[i]=1;
                }else{
                    ans[i]=0;
                    flag=true;
                }
            }else if(a==1||b==1){
                if(flag){
                    ans[i]=0;
                }else{
                    ans[i]=1;
                }
            }else{
                if(flag){
                    ans[i]=1;
                    flag=false;
                }
            }
        }
        int ret=0;
        for(int i=31;i>=0;i--){
            System.out.print(ans[i]);
            ret=((ret<<1)|ans[i]);
        }
        return ret;
    }
//    public static void main(String[] args) {
//        int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        List<Integer> ans=spiralOrder(arr);
//        for (Integer i:ans){
//            System.out.print(i+" ");
//        }
//    }
//
//    public static List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> ans=new ArrayList<>();
//        int m=matrix.length;
//        int n=matrix[0].length;
//        int row=0;
//        int col=0;
//        while(row<m&&col<n){
//            int i=row;
//            int j=col;
//            if(j<n){
//                while(j<n){
//                    ans.add(matrix[i][j]);
//                    j++;
//                }
//                j--;
//                i++;
//            }
//            row++;
//            if(i<m){
//                while(i<m){
//                    ans.add(matrix[i][j]);
//                    i++;
//                }
//                i--;
//                j--;
//            }
//            n--;
//            if(j>=col){
//
//            }
//            while(j>=col){
//                ans.add(matrix[i][j]);
//                j--;
//            }
//            j++;
//            m--;
//            i=m-1;
//            while(i>=row){
//                ans.add(matrix[i][j]);
//                i--;
//            }
//            col++;
//        }
//        return ans;
//    }


//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNextLong()){
//            long n=sc.nextLong();
//            long r=sc.nextLong();
//            boolean flag=(n/6.28)<=(r);
//            System.out.println(n/6.28);
//            System.out.println(r);
//            String ans=flag?"Yes":"No";
//            System.out.println(ans);
//        }
//    }

//    public static void main(String[] args) {
//        String s="leetcode";
//        List<String> wordDict=new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");
//        Main main=new Main();
//        boolean ret=(main.wordBreak(s, wordDict));
//        System.out.println(ret);
//    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> set=new HashSet<>();
//        for(int i=0;i<wordDict.size();i++){
//            set.add(wordDict.get(i));
//        }
//        //  [)
//        boolean[] dp=new boolean[s.length()+1];
//        dp[0]=true;
//        for(int i=1;i<=s.length();i++){
//            for(int j=0;j<i;j++){
//                String str=s.substring(j,i);
//                if(set.contains(str)&&dp[j]){
//                    dp[i]=true;
//                }
//            }
//        }
//        return dp[s.length()];
//    }

//    private static List<int[]> ans=null;
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        int m=sc.nextInt();
//        int n=sc.nextInt();
//        int[][] board=new int[m][n];
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                board[i][j]=sc.nextInt();
//            }
//        }
//        List<int[]> list=new ArrayList<>();
//        dfs(list,0,0,board);
//        for (int[] arr : ans) {
//            System.out.println("(" + arr[0] + "," + arr[1] + ")");
//        }
//    }
//    public static void dfs(List<int[]> list,int i,int j,int[][] board){
//        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
//            if((i == board.length && j==board[0].length-1) || (j==board[0].length&&i== board.length-1)){
//                if(ans==null||ans.size()>list.size()){
//                    ans=new ArrayList<>(list);
//                }
//            }
//            return;
//        }
//        if(board[i][j]==1){
//            return;
//        }
//        int[] arr={i,j};
//        list.add(arr);
//        if(i+1<board.length){
//            dfs(list,i+1,j,board);
//        }
//        if(j+1< board[0].length){
//            dfs(list,i,j+1,board);
//        }
//        if(j-1>=0){
//            dfs(list,i,j-1,board);
//        }
//        list.remove(list.size()-1);
//    }


//    public static void main(String[] args) {
//        int[][] board={
//                {111,111,111,111,111,111},
//                {111,111,111,111,111,111},
//                {111,111,111,111,211,111},
//                {111,111,111,111,111,111},
//                {111,111,111,111,111,111},
//                {111,111,111,111,111,111}};
//        Main m=new Main();
//        int ret= m.getMost(board);
//        System.out.println(ret);
//    }
//    public int getMost(int[][] board) {
//        // write code here
//        int[][] dp=new int[7][7];
//        dp[0][0]=board[0][0];
//        for(int j=1;j<6;j++){
//            dp[0][j]=dp[0][j-1]+board[0][j];
//        }
//        for(int i=1;i<6;i++){
//            dp[i][0]=dp[i-1][0]+board[i][0];
//        }
//        for(int i=1;i<6;i++){
//            for(int j=1;j<6;j++){
//                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+board[i][j];
//            }
//        }
//        return dp[5][5];
//    }



//    public static void main(String[] args) {
//        int[] nums=new int[]{1,2,3};
//        Main main=new Main();
//        List<List<Integer>> ret=main.fun(nums);
//        for(List<Integer> list:ret){
//            System.out.println(list);
//        }
//    }
//    private List<List<Integer>> ans;
//    public List<List<Integer>> fun(int[] nums){
//        ans=new ArrayList<>();
//        List<Integer> list=new ArrayList<>();
//        for(int i=0;i<= nums.length;i++){
//            dfs(nums,i,0,list);
//        }
//        return ans;
//    }
//    private void dfs(int[] nums,int number,int index,List<Integer> list){
//        if(list.size()==number){
//            ans.add(new ArrayList<>(list));
//            return;
//        }
//        for(int i=index;i<nums.length;i++){
//            list.add(nums[i]);
//            dfs(nums,number,i+1,list);
//            list.remove(list.size()-1);
//        }
//    }



//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNextInt()){
//            int n=sc.nextInt();
//            int a=sc.nextInt();
//            int[] b=new int[n];
//            for(int i=0;i<n;i++){
//                if(sc.hasNext()){
//                    b[i]=sc.nextInt();
//                }
//            }
//            for(int i=0;i<n;i++){
//                if(a>=b[i]){
//                    a+=b[i];
//                }else{
//                    a+=function(b[i],a);
//                }
//            }
//            System.out.println(a);
//        }
//    }
//    //a>=b
//    public static int function(int a,int b){
//        while(a!=b){
//            int tmp=a-b;
//            a=Math.max(tmp,b);
//            b=Math.min(tmp,b);
//        }
//        return a;
//    }


//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int n= scanner.nextInt();
//        while (scanner.hasNext()){
//            String order= scanner.nextLine();
//            System.out.println(order);
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n= sc.nextInt();
//        while(sc.hasNext()){
//            int a= sc.nextInt();
//            int b= sc.nextInt();
//            int[] arr=new int[2*a];
//            for(int i=0;i<2*a;i++){
//                arr[i]= sc.nextInt();
//            }
//            System.out.println(Arrays.toString(arr));
//        }
//    }

//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        List<int[]> list=new ArrayList<>();
//        for(int i=0;i<n;i++){
//            String temp=sc.nextLine();
//            String read=sc.nextLine();
//            String[] msg=read.split(" ");
//            int a=Integer.parseInt(msg[0]);
//            int b=Integer.parseInt(msg[1]);
//            int[] num=new int[a*2];
//            for(int j=0;j<2*a;j++){
//                num[j]=sc.nextInt();
//            }
//            for(int j=1;j<=b;j++){
//                operation(num);
//            }
//            print(num);
//        }
//    }
//    public static void print(int[] nums){
//        for(int i=0;i<nums.length;i++){
//            System.out.print(nums[i]);
//            if(i<nums.length-1){
//                System.out.print(" ");
//            }
//        }
//        System.out.println();
//    }
//    public static void operation(int[] nums){
//        int n=nums.length;
//        int i=0;
//        int j=n/2;
//        int k=0;
//        int[] tmp=new int[n];
//        while(i<n/2){
//            tmp[k++]=nums[i++];
//            tmp[k++]=nums[j++];
//        }
//        while(k>=0){
//            nums[k]=tmp[k];
//            k--;
//        }
//    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        String[] list1={"Shogun","Tapioca Express","Burger King","KFC"};
//        String[] list2={"KFC","Burger King","Tapioca Express","Shogun"};
//        String[] ans=solution.findRestaurant(list1,list2);
//        System.out.println(Arrays.toString(ans));
//    }

//    public static void main(String[] args) {
//        int a = (int) Math.round(11.5);
//        System.out.println(a);
//    }
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        String[] str=new String[50];
//        int n=0;
//        n=2;
//        str[0]="BUTTER FLOUR";
//        str[1]="HONEY FLOUR EGG";
//        while(sc.hasNextLine()){
//            str[n]=sc.nextLine();
//            n++;
//        }
//        HashSet<String> set=new HashSet<>();
//        for(int i=0;i<n;i++){
//            String[] word=str[i].split(" ");
//            for(int j=0;j<word.length;j++){
//                set.add(word[i]);
//            }
//        }
//        int ans = set.size();
//        System.out.println(ans);


//        HashMap<String,Integer> map=new HashMap<>();
//        int ans = 0;
//        for(int i=0;i<n;i++){
//            String[] word=str[i].split(" ");
//            for(int j=0;j<word.length;j++){
//                Integer count = map.get(word[j]);
//                map.put(word[j],count==null?1:count+1);
//            }
//        }
//        ans=map.size();
//        System.out.println(ans);
//    }

//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int[] arr=new int[100];
//        arr[0]=0;
//        arr[1]=1;
//        for(int i=2;i<40;i++){
//            arr[i]=arr[i-1]+arr[i-2];
//        }
//        for(int i=1;i<40;i++){
//            if(n>=arr[i-1]&&n<=arr[i]){
//                int ans=Math.min(n-arr[i-1],arr[i]-n);
//                System.out.println(ans);
//                break;
//            }
//        }
//    }
}
