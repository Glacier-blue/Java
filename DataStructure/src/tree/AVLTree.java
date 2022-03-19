package tree;

import node.AVLNode;

import java.util.TreeMap;

public class AVLTree {
    public AVLNode root;
    //得到树高度
    private int getHeight(AVLNode root){
        if(root==null){
            return 0;
        }else{
            return Math.max(getHeight(root.left),getHeight(root.right))+1;
        }
    }
    //得到树的平衡因子
    private int getBF(AVLNode root){
        return getHeight(root.left)-getHeight(root.right);
    }

    public AVLNode search(AVLNode root,int key){
        if(root==null){
            return null;
        }
        if(root.val==key) {
            return root;
        }else if(root.val>key){
            return search(root.left,key);
        }else{
            return search(root.right,key);
        }
    }
    public void insert(int val){
        if(root==null){
            this.root=new AVLNode(val);
            return;
        }
        AVLNode cur=root;
        while(true){
            if(val== cur.val){
                return;
            }else if(val> cur.val){
                if(cur.right==null){
                    cur.right=new AVLNode(val);
                    cur.right.parent=cur;
                    siftInsert(cur.right);
                    break;
                }else{
                    cur=cur.right;
                }
            }else{
                if(cur.left==null){
                    cur.left=new AVLNode(val);
                    cur.left.parent=cur;
                    siftInsert(cur.left);
                    break;
                }else{
                    cur=cur.left;
                }
            }
        }
    }
    private void siftInsert(AVLNode cur){
        AVLNode parent=cur.parent;
        while(parent!=null){
            if(cur == parent.left) {
                parent.bf++;
            } else {
                parent.bf--;
            }
            if(parent.bf == 0) {
                break;
            } else if(parent.bf == -1 || parent.bf == 1) {
                cur = parent;
                parent = cur.parent;
            }
            else {
                if(parent.bf==2) {
                    if(cur.bf==1){
                        rightRotation(parent);
                    }else{
                        leftRotation(cur);
                        rightRotation(parent);
                    }
                } else{
                    if(cur.bf==-1){
                        leftRotation(parent);
                    }else{
                        rightRotation(cur);
                        rightRotation(parent);
                    }
                }
                break;
            }
        }
    }

//    private void siftDel(AVLNode parent){
//        AVLNode cur=null;
//        while(parent!=null){
//            if(parent.bf==0){
//                cur=parent;
//                parent=parent.parent;
//                if(parent!=null){
//                    if(cur==parent.left){
//                        parent.bf--;
//                    }else{
//                        parent.bf++;
//                    }
//                }
//            }else if(Math.abs(parent.bf)==1){
//                break;
//            }else{
//                if(parent.bf==2) {
//                    if(parent.left.bf==1){
//                        rightRotation(parent);
//                    }else{
//                        leftRotation(parent.left);
//                        rightRotation(parent);
//                    }
//                } else{
//                    if(parent.right.bf==-1){
//                        leftRotation(parent);
//                    }else{
//                        rightRotation(parent.right);
//                        rightRotation(parent);
//                    }
//                }
//                break;
//            }
//        }
//    }
private void siftDel(AVLNode parent){
    AVLNode cur=null;
    while(parent!=null){
        if(Math.abs(parent.bf)==1){
            break;
        }else{
            if(parent.bf==2) {
                if(parent.left.bf==1){
                    rightRotation(parent);
                }else{
                    leftRotation(parent.left);
                    rightRotation(parent);
                }
            } else if(parent.bf==-2){
                if(parent.right.bf==-1){
                    leftRotation(parent);
                }else{
                    rightRotation(parent.right);
                    rightRotation(parent);
                }
            }else{
                cur=parent;
                parent=parent.parent;
                if(parent!=null){
                    if(cur==parent.left){
                        parent.bf--;
                    }else{
                        parent.bf++;
                    }
                }
            }
        }
    }
}
    private void leftRotation(AVLNode root){
        AVLNode parent=root.parent;
        AVLNode right=root.right;
        AVLNode rightLeft=right.left;
        right.left=root;
        root.parent=right;
        root.right=rightLeft;
        if(rightLeft!=null){
            rightLeft.parent=root;
        }
        if(parent==null){
            this.root=right;
        }else if(root==parent.left){
            parent.left=right;
        }else {
            parent.right=right;
        }
        right.parent=parent;
        root.bf=getBF(root);
        right.bf=getBF(right);
    }

    private void rightRotation(AVLNode root){
        AVLNode parent=root.parent;
        AVLNode left=root.left;
        AVLNode leftRight=left.right;
        left.right=root;
        root.parent=left;
        root.left=leftRight;
        if(leftRight!=null){
            leftRight.parent=root;
        }
        if(parent==null){
            this.root=left;
        }else if(root==parent.left){
            parent.left=left;
        }else{
            parent.right=left;
        }
        left.parent=parent;
        root.bf=getBF(root);
        left.bf=getBF(left);
    }

    public void remove(int key){
        if(root==null) {
            return;
        }
        AVLNode cur=search(root,key);
        if(cur==null){
            return;
        }
        AVLNode parent=cur.parent;
        if(cur.right==null&&cur.left==null){
            if(parent==null){
                root=null;
            }else if(cur==parent.left){
                parent.left=null;
                parent.bf--;
            }else{
                parent.right=null;
                parent.bf++;
            }
            cur.parent=null;
            siftDel(parent);
        }else if(cur.left==null){
            if(parent==null){
                root=cur.right;
                cur.right.parent=root;
            }else if(parent.left==cur){
                parent.left=cur.right;
                parent.bf--;
            }else{
                parent.right=cur.right;
                parent.bf++;
            }
            cur.parent=null;
            siftDel(parent);
        }else if(cur.right==null){
            if(parent==null){
                root=cur.left;
                cur.left.parent=root;
            }else if(parent.left==cur){
                parent.left=cur.left;
                parent.bf--;
            }else{
                parent.right=cur.left;
                parent.bf++;
            }
            cur.parent=null;
            siftDel(parent);
        }else{
            AVLNode minNode=getMin(cur);
            remove(minNode.val);
            minNode.right=cur.right;
            minNode.left=cur.left;
            minNode.bf=cur.bf;
            minNode.parent=cur.parent;
            if(parent==null){
                root=minNode;
            }else if(cur==parent.left){
                parent.left=minNode;
            }else{
                parent.right=minNode;
            }
        }
    }

    public void inorder(AVLNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val+" "+ root.bf);
        inorder(root.right);
    }

    private AVLNode getMin(AVLNode root){
        if(root==null){
            return null;
        }
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        AVLTree avlTree=new AVLTree();
        avlTree.insert(58);
        avlTree.insert(29);
        avlTree.insert(83);
        avlTree.insert(11);
        avlTree.insert(46);
        avlTree.insert(81);
        avlTree.insert(95);
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(42);
        avlTree.insert(51);
        avlTree.insert(78);
        avlTree.insert(92);
        avlTree.insert(100);
        avlTree.insert(13);
        avlTree.insert(22);
        avlTree.insert(31);
        avlTree.insert(57);
        avlTree.insert(91);
        avlTree.insert(93);
        avlTree.inorder(avlTree.root);
        System.out.println("-----------------------");
//        avlTree.remove(15);
//        avlTree.inorder(avlTree.root);
        System.out.println();
        TreeMap
    }
}
