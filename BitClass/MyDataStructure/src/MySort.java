public class MySort {

    public void insertSort(int[] nums){
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                int tmp=nums[i];
                int j;
                for(j=i-1;j>=0&&nums[j]>tmp;j--){
                    nums[j+1]=nums[j];
                }
                nums[j+1]=tmp;
            }
        }
    }
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
    public void shellSort(int[] nums){

        for(int i=nums.length/2;i>=1;i/=2){
            for(int j=i;j< nums.length;j+=i){
                if(nums[j]<nums[j-i]) {
                    int tmp = nums[j];
                    int k;
                    for (k = j - i;k>=0&&nums[k]>tmp; k -= i) {
                        nums[k + i] = nums[k];
                    }
                    nums[k+i] = tmp;
                }
            }

        }
    }
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
    public void bubbleSort(int[] nums){
        for(int i=0;i< nums.length;i++){
            boolean isSwap=false;
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]<nums[j-1]){
                    isSwap=true;
                    swap(nums,j-1,j);
                }
            }
            if(isSwap==false){
                break;
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public void quickSort(int[] nums){
        quickSortFun(nums,0, nums.length-1);
    }
    private void quickSortFun(int[] nums,int left,int right){
        if(left>=right) return;
        int i=left;
        int j=right;
        int tmp=nums[i];
        while(i<j){
            while(i<j&&nums[j]>tmp){
                j--;
            }
            nums[i]=nums[j];
            while(i<j&&nums[i]<tmp){
                i++;
            }
            nums[j]=nums[i];
        }
        nums[i]=tmp;
        quickSortFun(nums,left,i);
        quickSortFun(nums,i+1,right);
    }

}
