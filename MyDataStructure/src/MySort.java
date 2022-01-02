
import java.util.Stack;

public class MySort {

    /**
     * 名称：直接插入排序
     * 时间复杂度：
     *          最坏时： O(n^2)
     *          最好时： O(n)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     */
    public void insertSort(int[] nums){
//        insertSort(nums,0, nums.length-1);
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
    public void insertSort(int[] nums,int start,int end){
        if(start>=nums.length) return;
        if(end>= nums.length) end=nums.length-1;
        for(int i=start+1;i<=end;i++){
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

    /**
     * 名称：选择排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定，有跳跃式变化
     */
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

    /**
     * 名称：冒泡排序
     * 时间复杂度：
     *            最坏时：O(n^2)
     *            最好时：O(n)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     */
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

    /**
     * 1、建堆
     * 2、进行调整
     * 名称：堆排序
     * 时间复杂度:O(n*log2(n))
     * 空间复杂度:O(1)
     * 稳定性：不稳定
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

    /**
     * 1、快速排序
     * 2、递归和非递归两种写法
     * 3、主要实现有挖坑填坑法以及霍尔法
     * 4、优化：固定下标，随机下标，三数取中法
     * 5、当数据量较低时可以进行直接插入排序
     * 5、时间复杂都：
     *              最好时：O(n*log2(n))
     *              最坏时：O(n^2)
     * 6、空间复杂度：
     *              最好时：O(log2(n))
     *              最坏时：O(n)
     * 稳定性：不稳定
     */
    public void quickSort(int[] nums,int num){
        if(num==1)
            quickSortFun1(nums,0, nums.length-1);
        if(num==2)
            quickSortFun2(nums,0, nums.length-1);
        if(num==3)
            quickSortFun3(nums);
    }
    private void selectPivotMidOfThree(int[] nums,int start,int end){
        //nums[mid]<=nums[start]<=nums[end]
        int mid=(start+end)/2;
        if(nums[mid]>nums[start]) swap(nums,mid,start);
        if(nums[mid]>nums[end]) swap(nums,mid,end);
        if(nums[mid]>nums[start]) swap(nums,mid,start);
    }
    //挖坑填坑法
    private void quickSortFun1(int[] nums,int left,int right){
        if(left>=right) return;
        if(right-left<50){
            insertSort(nums,left,right);
            return;
        }
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
        if(right-left<50){
            insertSort(nums,left,right);
            return;
        }
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
    private void quickSortFun3(int[] nums){
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

    /**
     * 名称：归并排序
     * 时间复杂度：O(n*log2(n))
     * 空间复杂度：O(n)
     * 稳定性：稳定
     */
    public void mergeSort(int[] nums,int num){
        if(num==1)
            mergeInterval(nums,0, nums.length-1);
        if(num==2)
            mergeSort(nums);
    }
    private void mergeInterval(int[] nums,int left,int right){
        if(left==right) return;
        int mid=(left+right)/2;
        mergeInterval(nums,left,mid);
        mergeInterval(nums,mid+1,right);
        mergeAnd(nums,left,right);
    }
    private void mergeAnd(int[] nums,int left,int right){
        int s1=left;
        int e1=(left+right)/2;
        int s2=e1+1;
        int e2=right;
        int[] tmp=new int[right-left+1];
        int k=0;
        while(s1<=e1&&s2<=e2){
            tmp[k++]=nums[s1]<=nums[s2]?nums[s1++]:nums[s2++];
        }
        while(s1<=e1){
            tmp[k++]=nums[s1++];
        }
        while(s2<=e2){
            tmp[k++]=nums[s2++];
        }
        for(int i=0;i<tmp.length;i++){
            nums[i+left]=tmp[i];
        }
    }
    private void mergeSort(int[] nums){
        for(int i=1;i< nums.length;i*=2){
            mergeAnd(nums,i);
        }
    }
    private void mergeAnd(int[] nums,int gap){
        int[] tmp=new int[nums.length];
        int s1=0;
        int e1=s1+gap-1;
        int s2=e1+1;
        int e2=s2+gap-1>= nums.length? nums.length-1:s2+gap-1;
        int k=0;
        while(s2<nums.length){
            while(s1<=e1&&s2<=e2){
                tmp[k++]=nums[s1]<=nums[s2]?nums[s1++]:nums[s2++];
            }
            while(s1<=e1){
                tmp[k++]=nums[s1++];
            }
            while(s2<=e2){
                tmp[k++]=nums[s2++];
            }
            s1=e2+1;
            e1=s1+gap-1;
            s2=e1+1;
            e2=s2+gap-1>= nums.length? nums.length-1:s2+gap-1;
        }
        while(s1<nums.length){
            tmp[k++]=nums[s1++];
        }
        for(int i=0;i< nums.length;i++){
            nums[i]=tmp[i];
        }
    }

}
