public class BinarySearchTree {

    public TreeNode search(TreeNode root,int key){
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
    public boolean insert(TreeNode root,int key){
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
//    private void remove(TreeNode parent,TreeNode child){
//
//    }
//    public void removeKey(TreeNode root,int key){
//
//    }
}
