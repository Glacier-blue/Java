
class TreeNode{
    int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val=val;
    }
    public TreeNode(){}
}
class OperationTree{
    public TreeNode creatTree(){
        TreeNode A=new TreeNode(1);
        TreeNode B=new TreeNode(2);
        TreeNode C=new TreeNode(3);
        TreeNode D=new TreeNode(4);
        TreeNode E=new TreeNode(5);
        TreeNode F=new TreeNode(6);
        TreeNode G=new TreeNode(7);
        TreeNode H=new TreeNode(8);
        A.left=B;
        A.right=C;
        B.left=D;
        B.right=E;
        C.left=F;
        C.right=G;
        D.right=H;
        return A;
    }
    //递归先序访问
    public void prevOrder(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+" ");
        prevOrder(root.left);
        prevOrder(root.right);
    }
    //递归中序访问
    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    //递归后序遍历
    public void postOrder(TreeNode root){
        if (root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    //递归得到节点数
    public void getSize1(TreeNode root,int[] size){
        if(root==null) return;
        size[0]++;
        getSize1(root.left,size);
        getSize1(root.right,size);
    }
    //子问题思想得到节点数
    public int getSize2(TreeNode root){
        if(root==null) return 0;
        return 1+getSize2(root.left)+getSize2(root.right);
    }
    //先序遍历得到叶子节点数
    public void getLeafSize1(TreeNode root,int[] nums){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            nums[0]++;
        }
        getLeafSize1(root.left,nums);
        getLeafSize1(root.right,nums);
    }
    //子问题思想得到叶子节点数
    public int getLeafSize2(TreeNode root){
        if(root==null) return 0;
        if(root.right==null&&root.left==null) return 1;
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }
    //子问题思想求K层叶子个数
    public int getKLevelSize(TreeNode root,int k){
        if(root==null) return 0;
        if(k==1) return 1;
//        if(k==2){
//            int count=0;
//            if(root.left!=null) count++;
//            if(root.right!=null) count++;
//            return count;
//        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }
    public TreeNode find(TreeNode root,int find){
        if(root==null) return null;
        if(root.val==find) return root;
        return find(root.left,find)==null?find(root.right,find):find(root.left,find);
    }
    public int getHeight(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
    public boolean isSameTree(TreeNode q,TreeNode p){
        if(p==null&&q==null){
            return true;
        }else if(p==null&&q!=null){
            return false;
        }else if(p!=null&&q==null){
            return false;
        }else{
            return (q.val==p.val)&&isSameTree(q.left,p.left)&&isSameTree(q.right, p.right);
        }
    }
}
public class MyTree {
    public static void main(String[] args) {
        OperationTree operationTree=new OperationTree();
        TreeNode root=operationTree.creatTree();
        System.out.print("先序遍历：");
        operationTree.prevOrder(root);
        System.out.println();
        System.out.print("中序遍历：");
        operationTree.inOrder(root);
        System.out.println();
        System.out.print("后序遍历：");
        operationTree.postOrder(root);
        System.out.println();
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
    }

}
