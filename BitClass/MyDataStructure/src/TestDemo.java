import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class TestDemo {
    public static void main(String[] args) {
        OperationTree operationTree=new OperationTree();
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        binarySearchTree.insert(1);
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(8);
        binarySearchTree.insert(0);
        binarySearchTree.insert(9);
        TreeNode root=binarySearchTree.getRoot();
        operationTree.inOrder(root);
    }
    public static void main6(String[] args) {
        OperationTree operationTree=new OperationTree();
        TreeNode root=operationTree.creatTree();
        System.out.print("先序遍历1：");
        operationTree.prevOrder(root);
        System.out.println();
        System.out.print("先序遍历2：");
        operationTree.prevOrderNor(root);
        System.out.print("中序遍历1：");
        operationTree.inOrder(root);
        System.out.println();
        System.out.print("中序遍历2：");
        operationTree.inOrderNor(root);
        System.out.print("后序遍历1：");
        operationTree.postOrder(root);
        System.out.println();
        System.out.print("后序遍历2：");
        operationTree.postOrderNor(root);
        System.out.println("节点个数测试");
        int[] size=new int[1];
        operationTree.getSize1(root,size);
        System.out.println(size[0]);
        System.out.println(operationTree.getSize2(root));
        System.out.println("叶子节点数测试");
        int[] size2=new int[1];
        operationTree.getLeafSize1(root,size2);
        System.out.println(size2[0]);
        System.out.println(operationTree.getLeafSize2(root));
        System.out.println("测试K层节点数");
        System.out.println(operationTree.getKLevelSize(root,1));
        System.out.println(operationTree.getKLevelSize(root,2));
        System.out.println(operationTree.getKLevelSize(root,3));
        System.out.println(operationTree.getKLevelSize(root,4));
        System.out.println("查找节点测试");
        System.out.println(operationTree.find(root, 8).val);
        System.out.println("树的高度测试：");
        System.out.println(operationTree.getHeight(root));
        System.out.println("镜像测试：");
        operationTree.mirror(root);
        operationTree.prevOrder(root);
        operationTree.mirror(root);
        System.out.println();
        System.out.println("层序遍历测试：");
        operationTree.leverOrder(root);
        System.out.println("完全二叉树判断：");
        System.out.println(operationTree.isCompleteTree(root));
    }
    public static void main5(String[] args) {
        MyArrayStack myArrayStack=new MyArrayStack();
        myArrayStack.push(1);
        myArrayStack.push(2);
        System.out.println(myArrayStack.peek());
        System.out.println(myArrayStack.pop());
        System.out.println(myArrayStack.peek());
    }
    public static void main4(String[] args) {
        MyQueue myQueue=new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());

    }
    public static void main3(String[] args) {
        MySort mySort=new MySort();
        Random random = new Random();
        int[] nums1=new int[10_0000];
        for(int i=0;i< nums1.length;i++){
            nums1[i]= random.nextInt(10_0000);
        }
        int[] nums2=nums1.clone();
        int[] nums3=nums1.clone();
        int[] nums4=nums1.clone();
        int[] nums5=nums1.clone();
        int[] nums6=nums1.clone();
        int[] nums7=nums1.clone();
        int[] nums8=nums1.clone();
        int[] nums9=nums1.clone();
        int[] nums10=nums1.clone();
        long start,end;
        start=System.currentTimeMillis();
        mySort.insertSort(nums1);
        end=System.currentTimeMillis();
        System.out.println("插入排序："+(end-start));

        start=System.currentTimeMillis();
        mySort.shellSort(nums2);
        end=System.currentTimeMillis();
        System.out.println("希尔排序："+(end-start));

        start=System.currentTimeMillis();
        mySort.bubbleSort(nums3);
        end=System.currentTimeMillis();
        System.out.println("冒泡排序："+(end-start));

        start=System.currentTimeMillis();
        mySort.selectSort(nums4);
        end=System.currentTimeMillis();
        System.out.println("选择排序1："+(end-start));


        start=System.currentTimeMillis();
        mySort.heapSort(nums5);
        end=System.currentTimeMillis();
        System.out.println("堆排序："+(end-start));
;
        start=System.currentTimeMillis();
        mySort.quickSort(nums6,1);
        end=System.currentTimeMillis();
        System.out.println("快速排序1："+(end-start));

        start=System.currentTimeMillis();
        mySort.quickSort(nums7,2);
        end=System.currentTimeMillis();
        System.out.println("快速排序2："+(end-start));

        start=System.currentTimeMillis();
        mySort.quickSort(nums8,3);
        end=System.currentTimeMillis();
        System.out.println("快速排序3："+(end-start));

        start=System.currentTimeMillis();
        mySort.mergeSort(nums9,1);
        end=System.currentTimeMillis();
        System.out.println("归并排序1："+(end-start));

        start=System.currentTimeMillis();
        mySort.mergeSort(nums10,2);
        end=System.currentTimeMillis();
        System.out.println("归并排序2："+(end-start));

    }
    public static void main2(String[] args) {
        int[] arr={1,4,2,5,6,3,7,9,0};
        MyHeap myHeap=new MyHeap(20);
        myHeap.creatHeap(arr);
        System.out.println();
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
