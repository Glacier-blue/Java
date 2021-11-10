class LinkNode{
    int val;
    LinkNode next;
    LinkNode prev;
    LinkNode(){
    }
    LinkNode(int val){
        this.val=val;
    }
}
public class DoubleLinkList {
    LinkNode dummy=new LinkNode(0);//傀儡头节点存储节点个数
    LinkNode head=dummy;
    LinkNode last=dummy;
    public void display(){
        if(dummy.val==0){
            System.out.println("链表为空");
        }else{
            LinkNode cur=this.head.next;
            while(cur!=null){
                System.out.print(cur.val+" ");
                cur=cur.next;
            }
            System.out.println();
        }
    }
    public void addHead(int data){
        LinkNode node=new LinkNode(data);
        if(head.next==null){
            head.next=node;
            node.prev=head;
            this.last=node;
        }else{
            node.next=head.next;
            head.next.prev=node;
            node.prev=head;
            head.next=node;
        }
        dummy.val++;
    }
    public void addLast(int data){
        LinkNode node=new LinkNode(data);
        this.last.next=node;
        node.prev=this.last;
        this.last=node;
        dummy.val++;
    }
    public boolean findKey(int key){
        LinkNode cur=head.next;
        while(cur!=null){
            if(cur.val==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    public void delFirstKey(int key){
        LinkNode cur=head.next;
        while(cur!=null){
            if(cur.val==key){
                if(cur==this.last){
                    this.last=this.last.prev;
                    this.last.next=null;
                }else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                break;
            }
            cur=cur.next;
        }
        dummy.val--;
    }
    public void delAllKey(int key){
        LinkNode cur=head.next;
        while(cur!=null){
            if(cur.val==key){
                if(cur==this.last){
                    this.last=this.last.prev;
                    this.last.next=null;
                }else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                dummy.val--;
            }
            cur=cur.next;
        }
    }
    public void indexList(int index,int data){
        if(index<0||index> dummy.val){
            System.out.println("位置不合法");
        }else if(index==0){
            addHead(data);
        }else if(index==dummy.val){
            addLast(data);
        }else{
            LinkNode cur=head.next;
            for(int i=0;i<index;i++){
                cur=cur.next;
            }
            LinkNode node=new LinkNode(data);
            cur.prev.next=node;
            node.prev=cur.prev;
            node.next=cur;
            cur.prev=node;
        }
    }
    public void clear(){
        while(head!=null){
            LinkNode cur=head.next;
            head.prev=null;
            head.next=null;
            head=cur;
        }
        this.last=null;
        dummy=null;
    }
}
