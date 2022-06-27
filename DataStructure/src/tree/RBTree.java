package tree;

import node.AVLNode;
import node.RBNode;
import node.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class RBTree {
    private RBNode root;
    public RBNode search(int key){
        RBNode cur=root;
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
    public void insert(int key) {
        if (root == null) {
            root = new RBNode(key,0);
            return;
        }
        RBNode cur = root;
        while (true) {
            if (cur.val == key) {
                System.out.println("插入失败");
                return;
            } else if (cur.val > key) {
                if (cur.left == null) {
                    cur.left = new RBNode(key,1);
                    cur.left.parent=cur;
                    if(cur!=root){
                        siftInsert(cur.left);
                    }
                    return;
                } else {
                    cur = cur.left;
                }
            } else {
                if (cur.right == null) {
                    cur.right = new RBNode(key,1);
                    cur.right.parent=cur;
                    if(cur!=root){
                        siftInsert(cur.right);
                    }
                    return;
                } else {
                    cur = cur.right;
                }
            }
        }
    }
    private void siftInsert(RBNode cur){
        RBNode parent,gFather;
        while((parent=cur.parent)!=null&&parent.color==1){
            gFather = parent.parent;
            if(parent==gFather.left){
                RBNode uncle = gFather.right;
                if(uncle!=null&&uncle.color==1){
                    uncle.color=0;
                    parent.color=0;
                    gFather.color=1;
                    cur=gFather;
                    continue;
                }
                if(parent.right==cur){
                    leftRotation(parent);
                    RBNode tmp = parent;
                    parent = cur;
                    cur = tmp;
                }
                parent.color=0;
                gFather.color=1;
                rightRotation(gFather);
            }else{
                RBNode uncle = gFather.left;
                if(uncle!=null&&uncle.color==1){
                    uncle.color=0;
                    parent.color=0;
                    gFather.color=1;
                    cur=gFather;
                    continue;
                }
                if(parent.left==cur){
                    rightRotation(parent);
                    RBNode tmp = parent;
                    parent = cur;
                    cur = tmp;
                }
                parent.color=0;
                gFather.color=1;
                leftRotation(gFather);
            }
        }
        this.root.color=0;
    }

    private void leftRotation(RBNode root){
        RBNode parent=root.parent;
        RBNode right=root.right;
        RBNode rightLeft=right.left;
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
    }

    private void rightRotation(RBNode root){
        RBNode parent=root.parent;
        RBNode left=root.left;
        RBNode leftRight=left.right;
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
    }
    public void leverOrder(RBNode root){
        if(root==null){
            return;
        }
        Deque<RBNode> queue = new LinkedList<>();
        queue.offer(root);
        int lever = 1;
        while(!queue.isEmpty()){
            System.out.print("第"+lever+"层:");
            int size = queue.size();
            for(int i = 0; i < size; i++){
                RBNode tmp = queue.poll();
                System.out.print(tmp+"   ");
                if(tmp.left!=null) {
                    queue.offer(tmp.left);
                }
                if(tmp.right!=null) {
                    queue.offer(tmp.right);
                }
            }
            lever++;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        RBTree rbTree = new RBTree();
        rbTree.insert(7);
        rbTree.insert(10);
        rbTree.insert(3);
        rbTree.insert(5);
        rbTree.insert(4);
        rbTree.leverOrder(rbTree.root);
    }
}
