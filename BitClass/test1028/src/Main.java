import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6};
        int[] nums1=nums.clone();
        int[] nums2= Arrays.copyOf(nums,nums.length);
        int[] nums3=nums;
        System.out.println(nums.hashCode());
        System.out.println(nums1.hashCode());
        System.out.println(nums2.hashCode());
        System.out.println(nums3.hashCode());
        System.out.println(nums1==nums);
        System.out.println(nums2==nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }
    public static int func(int num){
        return 0;
    }
}
