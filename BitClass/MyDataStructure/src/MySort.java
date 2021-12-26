import java.util.Arrays;
import java.util.Stack;

public class MySort {

    /**
     * 名称：直接插入排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     */
    public void insertSort(int[] nums){
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                int tmp=nums[i];
                int j=i-1;
                for(;j>=0&&nums[j]>tmp;j--){
                    nums[j+1]=nums[j];
                }
                nums[j+1]=tmp;
            }
        }
    }
    //折半插入排序
    public void halfInsertSort(int[] nums){
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                int left=0,right=i-1;
                while(left<right){
                    int mid=(left+right)/2;
                    if(nums[mid]<nums[i]){
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }
                }
                int tmp=nums[i];
                for(int j=i;j>left;j--){
                    nums[j]=nums[j-1];
                }
                nums[left]=tmp;

            }
        }
    }

    /**
     * 名称：希尔排序
     * 时间复杂度：n^1.3---n^1.5
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * 技巧：具有跳跃变化的都是不稳定的排序
     */
    public void shellSort(int[] nums){
        for(int gap=nums.length/2;gap>=1;gap/=2){

            for(int i=gap;i< nums.length;i++){
                if(nums[i]<nums[i-gap]) {
                    int tmp = nums[i];
                    int j=i-gap;
                    for (;j>=0&&nums[j]>tmp; j -= gap) {
                        nums[j + gap] = nums[j];
                    }
                    nums[j+gap] = tmp;
                }
            }
        }
    }


    //选择排序
    public void selectSort(int[] nums){
        for(int i=0;i< nums.length;i++){
            int min=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[min]){
                    min=j;
                }
            }
            swap(nums,i,min);
        }
    }

    //冒泡排序
    public void bubbleSort(int[] nums){
        for(int i=0;i< nums.length;i++){
            boolean isSwap=false;
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]<nums[j-1]){
                    isSwap=true;
                    swap(nums,j-1,j);
                }
            }
            if(!isSwap){
                break;
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    //堆排序

    /**
     * 1、建堆
     * 2、进行调整
     */
    public void heapSort(int[] nums){
        for(int i= nums.length/2-1;i>=0;i--){
            adjustDown(nums,i, nums.length);
        }
        int end=nums.length-1;
        while(end>0){
            swap(nums,0,end);
            adjustDown(nums,0,end);
            end--;
        }
    }
    private void adjustDown(int[] nums,int root,int end){
        int parent=root;
        int child=2*root+1;
        while(child<end){
            if(child+1<end&&nums[child]<nums[child+1]){
                child++;
            }
            if(nums[parent]<nums[child]){
                swap(nums,child,parent);
                parent=child;
                child=child*2+1;
            }else{
                break;
            }
        }
    }
    //快速排序
    public void quickSort(int[] nums,int num){

        quickSortFun1(nums,0, nums.length-1);
    }
    private void selectPivotMidOfThree(int[] nums,int start,int end){
        //nums[mid]<=nums[start]<=nums[end]
        int mid=(start+end)/2;
        if(nums[mid]>nums[start]) swap(nums,mid,start);
        if(nums[mid]>nums[end]) swap(nums,mid,end);
        if(nums[mid]>nums[start]) swap(nums,mid,start);
    }
    private void insertSort(int[] nums,int start,int end){

    }
    //挖坑填坑法
    private void quickSortFun1(int[] nums,int left,int right){
        if(left>=right) return;
        selectPivotMidOfThree(nums,left,right);
        int i=left;
        int j=right;
        int pivot=nums[i];
        while(i<j){
            while(i<j&&nums[j]>=pivot){
                j--;
            }
            nums[i]=nums[j];
            while(i<j&&nums[i]<=pivot){
                i++;
            }
            nums[j]=nums[i];
        }
        nums[i]=pivot;
        quickSortFun1(nums,left,i);
        quickSortFun1(nums,i+1,right);
    }
    //霍尔法
    private void quickSortFun2(int[] nums,int left,int right){
        if(left>=right) return;
        selectPivotMidOfThree(nums,left,right);
        int i=left;
        int j=right;
        int pivot=nums[left];
        while(i<j){
            while(i<j&&nums[j]>=pivot){
                j--;
            }
            while(i<j&&nums[i]<=pivot){
                i++;
            }
            swap(nums,i,j);
        }
        swap(nums,i,left);
        quickSortFun2(nums,left,i);
        quickSortFun2(nums,i+1,right);
    }
    //快速排序的非递归写法
    private int partition(int[] nums,int left,int right){
        int tmp=nums[left];
        while(left<right){
            while(left<right&&nums[right]>=tmp){
                right--;
            }
            nums[left]=nums[right];
            while(left<right&&nums[left]<=tmp){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=tmp;
        return left;
    }
    public void quickSortFun3(int[] nums){
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        stack.push(nums.length-1);
        while(!stack.empty()){
            int end=stack.pop();
            int start=stack.pop();
            selectPivotMidOfThree(nums,start,end);
            int pivot=partition(nums,start,end);
            if(start<pivot-1){
                stack.push(start);
                stack.push(pivot-1);
            }
            if(end>pivot+1){
                stack.push(pivot+1);
                stack.push(end);
            }
        }
    }
}
