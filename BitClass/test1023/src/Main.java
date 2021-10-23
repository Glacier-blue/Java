public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int ret = add(a, b);
        System.out.println("ret = " + ret);
        double a2 = 10.5;
        double b2 = 20.5;
        double ret2 = add(a2, b2);
        System.out.println("ret2 = " + ret2);
        double a3 = 10.5;
        double b3 = 10.5;
        double c3 = 20.5;
        double ret3 = add(a3, b3, c3);
        System.out.println("ret3 = " + ret3);
    }
    public static int add(int x, int y) {
        return x + y;
    }
    public static double add(double x, double y) {
        return x + y;
    }
    public static double add(double x, double y, double z) {
        return x + y + z;
    }


    public static void main2(String[] args) {
        int[][] matrix={{1}};
        System.out.println(findNumberIn2DArray(matrix,0));
    }
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row=matrix.length;
        if(row==0){
            return false;
        }
        int col=matrix[0].length;
        for(int i=0;i<row;i++){
            if(target<matrix[i][0]||target>matrix[i][col-1]){
                continue;
            }
            int left=0,right=col-1;
            int mid=0;
            while(left<=right){
                mid=(left+right)/2;
                if(matrix[i][mid]==target){
                    return true;
                }else if(matrix[i][mid]>target){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return false;
    }
    public static void main1(String[] args) {
        int area = 10;
        int[] nums=constructRectangle(20);
        for (int x: nums) {
            System.out.println(x);
        }
    }
    public static int[] constructRectangle(int area) {
        int[] nums=new int[]{0,0};
        int left=(int)Math.sqrt(area);
        int right=left;
        while(left>=1&&right<=area){
            if(left*right==area){
                nums[0]=left;
                nums[1]=right;
                break;
            }else if(left*right>area){
                --left;
            }else{
                ++right;
            }
        }
        return nums;
    }
}
