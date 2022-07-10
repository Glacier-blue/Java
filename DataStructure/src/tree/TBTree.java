package tree;

import node.TBTNode;

import java.util.concurrent.LinkedTransferQueue;

public class TBTree {
    //穷举法创建一棵树
    public TBTNode createTree(){
        TBTNode root = new TBTNode(1);
        TBTNode a = new TBTNode(2);
        TBTNode b = new TBTNode(3);
        TBTNode c = new TBTNode(4);
        TBTNode d = new TBTNode(5);
        TBTNode e = new TBTNode(6);
        TBTNode f = new TBTNode(7);
        TBTNode g = new TBTNode(8);
        TBTNode h = new TBTNode(9);
        TBTNode j = new TBTNode(10);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        c.right = g;
        d.left = h;
        d.right = j;
        return root;
    }


    //先序遍历，不受线索的影响
    public void preorder(TBTNode root){
        if(root!=null){
            System.out.println(root);
            if(root.ltag==0){
                preorder(root.left);
            }
            if(root.rtag==0){
                preorder(root.right);
            }
        }
    }
    //中序遍历，不受线索的影响
    public void inorder(TBTNode root){
        if(root!=null){
            if(root.ltag==0){
                inorder(root.left);
            }
            System.out.println(root);
            if(root.rtag==0){
                inorder(root.right);
            }
        }
    }

    //后续遍历，不受线索的影响
    public void postorder(TBTNode root){
        if(root!=null){
            if(root.ltag==0){
                inorder(root.left);
            }
            if(root.rtag==0){
                inorder(root.right);
            }
            System.out.println(root);
        }
    }
    // 先序线索化，类似遍历
    private void cluePre(TBTNode root){
        if(root!=null){
            visit(root);
            if(root.ltag==0){
                cluePre(root.left);
            }
            if(root.rtag==0){
                cluePre(root.right);
            }
        }
    }
    // 中序线索化，类似遍历
    private void clueIn(TBTNode root){
        if(root!=null){
            if(root.ltag==0){
                clueIn(root.left);
            }
            visit(root);
            if(root.rtag==0){
                clueIn(root.right);
            }
        }
    }
    // 后续线索化，类似遍历
    private void cluePost(TBTNode root){
        if(root!=null){
            if(root.ltag==0){
                cluePost(root.left);
            }
            if(root.rtag==0){
                cluePost(root.right);
            }
            visit(root);
        }
    }
    // 全局变量，前节点
    private TBTNode preNode;
    private void visit(TBTNode root) {
        if(root!=null){
            if(root.left==null){
                root.left = preNode;
                root.ltag = 1;
            }
            if(preNode!=null&&preNode.right==null){
                preNode.right = root;
                preNode.rtag = 1;
            }
            preNode = root;
        }
    }
    //中序线索化
    public void createInorder(TBTNode root){
        // 由于函数可能使用多次，需要对全局变量进行初始化
        preNode = null;
        if(root!=null){
            clueIn(root);
            // 中序 左中右，最后一个节点一定是叶子节点，如果是根节点，那么右子树为空
            preNode.right = null;
            preNode.rtag = 1;
        }
    }
    // 先序线索化
    public void createPreorder(TBTNode root){
        preNode = null;
        if(root!=null){
            cluePre(root);
            // 先序 中左右 最后一个节点也是叶子节点
            preNode.right = null;
            preNode.rtag = 1;
        }
    }
    // 后序线索化
    public void createPostorder(TBTNode root){
        preNode = null;
        if(root!=null){
            cluePost(root);
            //这里和前面不同的是，根节点一定是最后一个节点
            if(preNode.right==null){
                preNode.rtag = 1;
            }
        }
    }
    // 先序找到前驱节点
    public TBTNode preFindPre(TBTNode root){
        // 被线索化--直接返回
        if(root.ltag==1){
            return root.left;
        }

        return null;
    }
    // 先序找到后继接节点
    public  TBTNode preFindNext(TBTNode root){
        // 被线索化 -- 直接返回
        if(root.rtag==1){
            return root.right;
        }
        // 如果没有被线索化，将访问左孩子，或者访问右孩子，注意要排除被线索化

        // 如果左孩子为空，要被线索化指向前驱节点
        if(root.ltag==0){
            return root.left;
        }
        // 如果右孩子为空，要被线索化指向后驱节点
        if(root.rtag==0){
            return root.right;
        }
        return null;
    }
    // 中序找到前驱节点
    public TBTNode inFindPre(TBTNode root){
        //被线索化--直接返回
        if(root.ltag==1){
            return root.left;
        }
        // 没有线索化，就是左子树最右节点
        TBTNode tmp = root.left;
        while(tmp!=null&&tmp.rtag==0){
            tmp = tmp.right;
        }
        return tmp;
    }
    // 中序找到后继接节点
    public  TBTNode inFindNext(TBTNode root){
        //被线索化--直接返回
        if(root.rtag==1){
            return root.right;
        }
        //没有被线索化-后继是右子树最左节点
        TBTNode tmp = root.right;
        while (tmp!=null&&tmp.ltag==0){
            tmp = tmp.left;
        }
        return tmp;
    }
    // 后续找到前驱节点
    public TBTNode postFindPre(TBTNode root){
        return null;
    }
    // 后续找到后继接节点
    public  TBTNode postFindNext(TBTNode root){
        return null;
    }
    public static void main(String[] args) {
        TBTree t = new TBTree();
        TBTNode root = t.createTree();
//        t.createInorder(root);
//        t.inorder(root);
//        t.createPreorder(root);
//        t.preorder(root);
        t.createPostorder(root);
        t.postorder(root);
    }
}
