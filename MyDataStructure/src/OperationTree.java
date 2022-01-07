import java.util.*;


public class OperationTree {
    /**
     * 通过先序遍历创建一颗树(字符树，给出‘#’等效于null
     */
//    private int i=0;
//    public TreeNode creatTreeByPrevOrder(String str){
//        if(str==null) return null;
//        TreeNode root=null;
//        if(str.charAt(i)!='#'){
//            root=new TreeNode(str.charAt(i));
//            i++;
//            root.left=creatTreeByPrevOrder(str);
//            root.right=creatTreeByPrevOrder(str);
//        }else{
//            i++;
//        }
//        return root;
//    }
    //穷举法创建一颗树
    public TreeNode creatTree(){
        TreeNode A=new TreeNode(1);
        TreeNode B=new TreeNode(2);
        TreeNode C=new TreeNode(3);
        TreeNode D=new TreeNode(4);
        TreeNode E=new TreeNode(5);
        TreeNode F=new TreeNode(6);
        TreeNode G=new TreeNode(7);
        TreeNode H=new TreeNode(8);
        TreeNode I=new TreeNode(9);
        TreeNode J=new TreeNode(10);
        TreeNode K=new TreeNode(11);
        TreeNode L=new TreeNode(12);
        TreeNode M=new TreeNode(13);
        A.left=B;
        A.right=C;
        B.left=D;
        B.right=E;
        C.left=F;
        C.right=G;
        D.left=H;
        D.right=I;
        E.left=J;
        E.right=K;
        F.left=L;
        F.right=M;
        return A;
    }
    //递归先序遍历
    public void preorder(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    //非递归先序遍历
    public void preorderNor(TreeNode root){
        if(root==null) return;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        while(p!=null||!stack.empty()){
            if(p!=null){
                stack.push(p);
                System.out.print(p.val+" ");
                p=p.left;
            }else{
                p=stack.pop();
                p=p.right;
            }
        }
        System.out.println();
    }
    public void preorderMorris(TreeNode root){
        TreeNode cur=root;
        TreeNode pre=null;
        while (cur != null) {
            pre = cur.left;
            if (pre != null) {
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    System.out.print(cur.val+" ");
                    pre.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    pre.right = null;
                }
            } else {
                System.out.print(cur.val+" ");
            }
            cur = cur.right;
        }
    }
    //递归中序遍历
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    //非递归中序遍历
    public void inorderNor(TreeNode root){
        if(root==null) return;
        TreeNode p=root;
        Stack<TreeNode> stack=new Stack<>();
        while(p!=null||!stack.empty()){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }else{
                p=stack.pop();
                System.out.print(p.val+" ");
                p=p.right;
            }
        }
        System.out.println();
    }
    public void inorderMorris(TreeNode root){
        TreeNode cur=root;
        TreeNode pre=null;
        while(cur!=null) {
            if (cur.left != null) {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    System.out.print(cur.val + " ");
                    pre.right = null;
                    cur = cur.right;
                }
            } else {
                System.out.print(cur.val + " ");
                cur = cur.right;
            }
        }
    }
    //递归后序遍历
    public void postorder(TreeNode root){
        if (root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val+" ");
    }
    //非递归后续遍历
    public void postorderNor(TreeNode root){
        if(root==null) return;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        TreeNode r=null;
        while(p!=null||!stack.empty()){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }else{
                p=stack.peek();
                if(p.left!=null&&p.right!=r){
                    p=p.right;
                }else{
                    p=stack.pop();
                    System.out.print(p.val+" ");
                    r=p;
                    p=null;
                }
            }
        }
        System.out.println();
    }
    public void postorderMorris(TreeNode root){
        TreeNode cur=root;
        TreeNode pre=null;
        while(cur!=null){
            if(cur.left!=null){
                pre=cur.left;
                while(pre.right!=null&&pre.right!=cur){
                    pre=pre.right;
                }
                if(pre.right==null){
                    pre.right=cur;
                    cur=cur.left;
                    continue;
                }else{
                    pre.right=null;
                    System.out.print(cur.left.val+" ");
                }
            }
            cur=cur.right;
        }
    }
    //层序遍历
    public void leverorder(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode p=root;
        queue.offer(root);
        while(!queue.isEmpty()){
            p=queue.poll();
            if(p!=null){
                queue.offer(p.left);
                queue.offer(p.right);
                System.out.print(p.val+" ");
            }
            p=null;
        }
        System.out.println();
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

    /**
     * 找到某个节点，通过递归方式，没有就返回null
     */
    public TreeNode find(TreeNode root,int key){
        if(root==null) return null;
        if(root.val==key) return root;
        return find(root.left,key)==null?find(root.right,key):find(root.left,key);
    }
    //得到树的长度
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
    //将二叉树变成对称二叉树
    public void mirror(TreeNode root){
        if(root==null) return;
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=right;
        root.right=left;
        mirror(root.left);
        mirror(root.right);
    }
    //判断是不是完全二叉树
    public boolean isCompleteTree(TreeNode root){
        if(root==null) return true;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tmp= queue.poll();
            if(tmp!=null){
                queue.offer(tmp.left);
                queue.offer(tmp.right);
            }else{
                break;
            }
        }
        while(!queue.isEmpty()){
            TreeNode tmp= queue.poll();
            if(tmp==null){
                return false;
            }
        }
        return true;
    }
    //通过先序和中序遍历来建一颗树
    private int previndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        previndex=0;
        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }
    private TreeNode buildTreeChild(int[] preorder,int[] inorder,int start,int end){
        if(start>end) return null;
        TreeNode root=new TreeNode(preorder[previndex]);
        int index=findIndex(inorder,start,end,preorder[previndex]);
        previndex++;
        root.left=buildTreeChild(preorder,inorder,start,index-1);
        root.right=buildTreeChild(preorder,inorder,index+1,end);
        return root;
    }
    private int findIndex(int[] inorder,int start,int end,int key){
        for(int i=start;i<=end;i++){
            if(inorder[i]==key){
                return i;
            }
        }
        return -1;
    }
    //通过中序和后序遍历建立一颗树
//    private int postIndex=0;
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        return buildTreeChild(inorder,postorder,0,inorder.length-1);
//    }
//    public TreeNode buildTreeChild(int[] inorder,int[] postorder,int start,int end){
//        if(start>end) return null;
//        int postIndexX=postorder.length-1-postIndex;
//        TreeNode root=new TreeNode(postorder[postIndexX]);
//        int index=findIndex(inorder,start,end,postorder[postIndexX]);
//        postIndex++;
//        root.right=buildTreeChild(inorder,postorder,index+1,end);
//        root.left=buildTreeChild(inorder,postorder,start,index-1);
//        return root;
//    }
}
