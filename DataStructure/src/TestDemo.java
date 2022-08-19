import list.MyArrayStack;
import list.MyCircularQueue;
import list.MyHeap;
import list.MyQueue;
import node.TreeNode;
import sort.MySort;
import tree.BSTree;
import tree.OperationTree;

import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
        TreeNode  A = new TreeNode(1);
        TreeNode  B = new TreeNode(2);
        TreeNode  C = new TreeNode(3);
        TreeNode  D = new TreeNode(4);
        A.left = B;
        B.left = C;
        C.left = D;
        OperationTree operationTree = new OperationTree();
        operationTree.preorder(A);
        operationTree.postorder(A);
        TreeNode  Q = new TreeNode(5);
        TreeNode  W = new TreeNode(6);
        TreeNode  E = new TreeNode(7);
        TreeNode  R = new TreeNode(8);
        Q.right = W;
        W.right = E;
        E.right = R;
        operationTree.preorder(Q);
        operationTree.postorder(Q);
    }
    public static void main8(String[] args) {
        HashBucket<Integer,Integer> hashBucket=new HashBucket<>();
        hashBucket.put(1,1);
        hashBucket.put(2,2);
        hashBucket.put(3,3);
        hashBucket.put(4,3);
        hashBucket.put(5,5);
        hashBucket.put(6,6);
        hashBucket.put(7,7);
        hashBucket.put(8,8);
        hashBucket.put(9,9);
        System.out.println(hashBucket.get(7));
        hashBucket.put(10,10);
        hashBucket.put(11,11);
        hashBucket.put(12,12);
        hashBucket.put(13,13);
        hashBucket.put(14,14);
        hashBucket.put(15,15);
        hashBucket.put(16,16);
        hashBucket.put(17,17);
        hashBucket.put(17,24);
        hashBucket.put(18,18);
        hashBucket.put(19,19);
        hashBucket.put(20,20);
        System.out.println(hashBucket.get(7));
        System.out.println(hashBucket.get(11));
        System.out.println(hashBucket.get(17));
        System.out.println(hashBucket.get(23));

    }
    public static void main7(String[] args) {
        MyCircularQueue myCircularQueue=new MyCircularQueue(10);
        System.out.println(myCircularQueue.isEmpty());
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(4);
        myCircularQueue.enQueue(5);
        myCircularQueue.enQueue(6);
        myCircularQueue.enQueue(7);
        myCircularQueue.enQueue(8);
        myCircularQueue.enQueue(9);
        myCircularQueue.enQueue(10);
        System.out.println(myCircularQueue.isFull());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.Front());
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(11);
        System.out.println(myCircularQueue.Rear());
    }
    public static void main6(String[] args) {
        OperationTree operationTree=new OperationTree();
        BSTree bst=new BSTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(7);
        TreeNode root=bst.getRoot();
        operationTree.inorder(root);
        System.out.println();
        TreeNode root1=bst.remove(5,root);
        operationTree.inorder(root1);
        System.out.println();
    }
    public static void main5(String[] args) {
        OperationTree operationTree=new OperationTree();
        TreeNode root=operationTree.creatTree();
        System.out.print("先序遍历1：");
        operationTree.preorder(root);
        System.out.println();
        System.out.print("先序遍历2：");
        operationTree.preorderNor(root);
        System.out.print("莫里斯先序遍历:");
        operationTree.preorderMorris(root);
        System.out.print("中序遍历1：");
        operationTree.inorder(root);
        System.out.println();
        System.out.print("中序遍历2：");
        operationTree.inorderNor(root);
        System.out.print("莫里斯中序遍历");
        operationTree.inorderMorris(root);
        System.out.print("后序遍历1：");
        operationTree.postorder(root);
        System.out.println();
        System.out.print("后序遍历2：");
        operationTree.postorderNor(root);
        System.out.print("莫里斯后序遍历：");
        operationTree.postorderMorris(root);
        System.exit(0);
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
        operationTree.preorder(root);
        operationTree.mirror(root);
        System.out.println();
        System.out.println("层序遍历测试：");
        operationTree.leverorder(root);
        System.out.println("完全二叉树判断：");
        System.out.println(operationTree.isCompleteTree(root));
    }
    public static void main4(String[] args) {
        MyArrayStack myArrayStack=new MyArrayStack();
        myArrayStack.push(1);
        myArrayStack.push(2);
        System.out.println(myArrayStack.peek());
        System.out.println(myArrayStack.pop());
        System.out.println(myArrayStack.peek());
    }
    public static void main3(String[] args) {
        MyQueue myQueue=new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());

    }
    public static void main2(String[] args) {
        MySort mySort=new MySort();
        Random random = new Random();
        int[] nums1=new int[30_0000];
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
    public static void main1(String[] args) {
        int[] arr={1,4,2,5,6,3,7,9,0};
        MyHeap myHeap=new MyHeap(20);
        myHeap.creatHeap(arr);
        System.out.println();
    }
}
