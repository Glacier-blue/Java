import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,6,5,4,3,2,1};
        System.out.println(findOnce(nums));
    }

    public static int findOnce(int[] nums) {
        int n= nums[0];
        for(int i=1;i< nums.length;i++){
            n^=nums[i];
        }
        return n;
    }
    public static void main5(String[] args) {
        int[] nums1={1,2,3};
        int[] nums2={1};
        int[] nums3={};
        System.out.println(myToString(nums1));
        System.out.println(myToString(nums2));
        System.out.println(myToString(nums3));
    }
    public static String myToString(int[] nums){
        if(nums==null){
            return null;
        }
        String s="[";
        for (int i = 0; i < nums.length; i++) {
            s+=nums[i];
            if(i!= nums.length-1){
                s+=",";
            }
        }
        s+="]";
        return s;
    }


    public static void main4(String[] args) {
        int[] nums={1,2,4,6,78,90,100,123,127,158,190,257};
        System.out.println(findByTwo(nums,2));
        System.out.println(findByTwo(nums,3));
    }
    public static int findByTwo(int[] nums,int target){
        int left=0,right= nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }

    public static void main3(String[] args) {
        int[] nums1={1,2,3,4,5,6};
        int[] nums2=null;
        int[] nums3={1};
        int[] nums4={1,3,2,5};
        System.out.println(isUpArr(nums1));
        System.out.println(isUpArr(nums2));
        System.out.println(isUpArr(nums3));
        System.out.println(isUpArr(nums4));

    }
    public static boolean isUpArr(int[] nums){
        if(nums==null){
            return false;
        }else if(nums.length==1){
            return true;
        }else{
            for (int i = 1;i < nums.length; i++){
                if(nums[i]<=nums[i-1]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main2(String[] args) {
        int[] nums={1,3,5,2,4,6,8,4,9,2,0};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void bubbleSort(int[] nums){
        int i,j;
        int temp=0;
        boolean flag;
        for(i=0;i< nums.length;i++){
            flag=true;
            for(j= nums.length-1;j>i;j--){
                if(nums[j]<nums[j-1]){
                    temp=nums[j-1];
                    nums[j-1]=nums[j];
                    nums[j]=temp;
                    flag=false;
                }
            }
            if(flag==true){
                break;
            }
        }
    }


    public static void main1(String[] args) {
     int[][] mat={{1,2},{3,4}};
     int[][] arr=matrixReshape(mat,1,4);
    }
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] arr=new int[r][c];
        if(r*c!=mat.length*mat[0].length){
            return mat;
        }else{
            int k=0,l=0;
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    if(l==c){
                        k++;
                        l=0;
                    }
                    arr[k][l]=mat[i][j];
                    ++l;
                }
            }
        }
        return arr;
    }
}
