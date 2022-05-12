package binary;

public class BinaryFind {

    public int rightBound2(int[] nums,int target){
        int left = 0;
        int right = nums.length;
        while(left<right){
            int mid = (left+right)>>>1;
            if(nums[mid]==target){
                left=mid + 1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right=mid;
            }
        }
        return left-1;
    }
    public int rightBound1(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = (left+right)>>>1;
            if(nums[mid]==target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(right<0||nums[right]!=target){
            return -1;
        }else{
            return right;
        }
    }
    public int leftBound2(int[] nums,int target){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid]==target){
                right=mid;
            }else if(nums[mid]<target){
                left=mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    public int leftBound1(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = (left+right)>>>1;
            if(nums[mid]==target){
                right = mid - 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(left>= nums.length || nums[left]!=target){
            return -1;
        }else{
            return left;
        }
    }
    public int binaryFind2(int[] nums,int target){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = (left+right)>>>1;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return -1;
    }
    public int binaryFind1(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left+right)>>>1;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,4,4,4,4,4,5,6,7,8,9,10};
        BinaryFind binaryFind = new BinaryFind();
        int target = 5;
        System.out.println(binaryFind.binaryFind1(nums,target));
        System.out.println(binaryFind.binaryFind2(nums,target));
        target = 4;
        System.out.println(binaryFind.leftBound1(nums,target));
        System.out.println(binaryFind.leftBound2(nums,target));
        System.out.println(binaryFind.rightBound1(nums,target));
        System.out.println(binaryFind.rightBound2(nums,target));

    }
}
