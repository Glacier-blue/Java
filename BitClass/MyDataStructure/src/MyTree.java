
class TreeNode{
    int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val=val;
    }
    public TreeNode(){

    }
}
public class MyTree {
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
    public void prevInorder(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+" ");
        prevInorder(root.left);
        prevInorder(root.right);
    }
    public void midInorder(TreeNode root){
        if(root==null) return;
        midInorder(root.left);
        System.out.print(root.val+" ");
        midInorder(root.right);
    }
    public void lastInorder(TreeNode root){
        if (root==null) return;
        lastInorder(root.left);
        lastInorder(root.right);
        System.out.print(root.val+" ");
    }
    public static void main(String[] args) {
        MyTree myTree=new MyTree();
        TreeNode root=myTree.creatTree();
        myTree.prevInorder(root);
        System.out.println();
        myTree.midInorder(root);
        System.out.println();
        myTree.lastInorder(root);
        System.out.println();
        int[] size=new int[1];
        myTree.getSize1(root,size);
        System.out.println(size[0]);
        System.out.println(myTree.getSize2(root));
    }
    public void getSize1(TreeNode root,int[] size){
        if(root==null) return;
        size[0]++;
        getSize1(root.left,size);
        getSize1(root.right,size);
    }
    public int getSize2(TreeNode root){
        if(root==null) return 0;
        return 1+getSize2(root.left)+getSize2(root.right);
    }
}
