import java.util.*;


public class OperationTree {
    //通过先序遍历创建一颗树
//    static int i=0;
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
    public void prevOrder(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+" ");
        prevOrder(root.left);
        prevOrder(root.right);
    }
    //非递归先序遍历
    public void prevOrderNor(TreeNode root){
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
    //递归中序遍历
    public void inOrder(TreeNode root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    //非递归中序遍历
    public void inOrderNor(TreeNode root){
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
    //递归后序遍历
    public void postOrder(TreeNode root){
        if (root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    //非递归后续遍历
    public void postOrderNor(TreeNode root){
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
    //层序遍历
    public void leverOrder(TreeNode root){
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
    public TreeNode find(TreeNode root,int find){
        if(root==null) return null;
        if(root.val==find) return root;
        return find(root.left,find)==null?find(root.right,find):find(root.left,find);
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

}
