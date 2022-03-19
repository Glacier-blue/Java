package tree;

import node.TreeNode;

public class BSTree {
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
    public void insert(int key){
        if(root==null) {
            root=new TreeNode(key);
            return;
        }
        TreeNode cur=root;
        while(true){
            if(cur.val==key){
                System.out.println("插入失败");
                return;
            }else if(cur.val>key){
                if(cur.left==null){
                    cur.left=new TreeNode(key);
                    return;
                }else {
                    cur=cur.left;
                }
            }else{
                if(cur.right==null){
                    cur.right=new TreeNode(key);
                    return;
                }else {
                    cur=cur.right;
                }
            }
        }
    }
    public TreeNode remove(int key,TreeNode root){
        if(root==null){
            return null;
        }
        if(root.val==key){
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            TreeNode minNode=getMinNode(root.right);
            root.right=remove(minNode.val,root.right);
            minNode.right=root.right;
            minNode.left=root.left;
            root=minNode;
        }else if(root.val>key){
            root.left=remove(key,root.left);
        }else{
            root.right=remove(key,root.right);
        }
        return root;
    }
    private TreeNode getMinNode(TreeNode root){
        if(root==null){
            return null;
        }
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    private void remove(TreeNode child,TreeNode parent){
        if(child.left==null){
            if(child==root){
                this.root=child.right;
            }else if(child==parent.left){
                parent.left=child.right;
            }else{
                parent.right=child.right;
            }
        }else if(child.right==null){
            if(child==root){
                this.root=child.left;
            }else if(child==parent.left){
                parent.left=child.left;
            }else{
                parent.right=child.left;
            }
        }else{
            TreeNode prev=child;
            TreeNode cur=child.right;
            while(cur.left!=null){
                prev=cur;
                cur=cur.left;
            }
//            child.val=cur.val;
             if(prev==child){
                 prev.right=cur.right;
             }else{
                 prev.left=null;
             }
             cur.left=child.left;
             cur.right=child.right;
             if(child==root){
                 this.root=cur;
             }else if(child==parent.left){
                 parent.left=cur;
             }else{
                 parent.right=cur;
             }
        }
    }



    public void removeKey(int key){
        TreeNode child=this.root;
        TreeNode parent=null;
        while (child!=null){
            if(child.val==key){
                remove(child,parent);
                break;
            }else if(child.val>key){
                parent=child;
                child=child.left;
            }else{
                parent=child;
                child=child.right;
            }
        }
    }
}
