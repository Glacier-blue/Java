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

        }
    }
//    public void removeKey(TreeNode root,int key){
//
//    }
}
