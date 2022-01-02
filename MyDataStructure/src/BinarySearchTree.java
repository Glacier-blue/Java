public class BinarySearchTree {
    private TreeNode root;
    public TreeNode getRoot() {
        return root;
    }
    public TreeNode search(int key){
        TreeNode cur=root;
        while(cur!=null){
            if(cur.val==key){
                return cur;
            }else if(cur.val>key){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return null;
    }
    public boolean insert(int key){
        if(root==null) {
            root=new TreeNode(key);
            return true;
        }
        TreeNode cur=root;
        while(cur!=null){
            if(cur.val==key){
                System.out.println("插入失败");
                return false;
            }else if(cur.val>key){
                if(cur.left==null){
                    cur.left=new TreeNode(key);
                    return true;
                }else {
                    cur=cur.left;
                }
            }else{
                if(cur.right==null){
                    cur.right=new TreeNode(key);
                    return true;
                }else {
                    cur=cur.right;
                }
            }
        }
        return true;
    }
    private void remove(TreeNode parent,TreeNode child,TreeNode root){
        if(child.left==null){
            if(child==root){
                root=child.right;
            }else if(child==parent.left){
                parent.left=child.right;
            }else{
                parent.right=child.right;
            }
        }else if(child.right==null){
            if(child==root){
                root=child.left;
            }else if(child==parent.left){
                parent.left=child.left;
            }else{
                parent.right=child.left;
            }
        }else{
            TreeNode cur=child.right;
            TreeNode prev=child;
            while(cur.left!=null){
                prev=cur;
                cur=cur.left;
            }
            child.val=cur.val;
            if(cur==prev.left){
                prev.left=cur.right;
            }else{
                prev.right=cur.right;
            }

        }
    }
    public void removeKey(int key){
        TreeNode child=this.root;
        TreeNode parent=null;
        while (child!=null&&child.val!=key){
            parent=child;
            if(child.val>key){
                child=child.left;
            }else{
                child=child.right;
            }
        }
        if(child!=null){
            remove(parent,child,root);
        }
    }
}
