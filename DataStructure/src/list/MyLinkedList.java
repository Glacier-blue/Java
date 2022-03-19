package list;

import node.ListNode;

public class MyLinkedList {
    private ListNode dummy = new ListNode(0);//傀儡头节点存储节点个数
    private ListNode head = dummy;
    private ListNode last = dummy;
    public void display() {
        if (dummy.val == 0) {
            System.out.println("链表为空");
        } else {
            ListNode cur = this.head.next;
            while (cur != null) {
                System.out.print(cur.val + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
    public void addHead(int data) {
        ListNode node = new ListNode(data);
        if (head.next == null) {
            head.next = node;
            node.prior = head;
            this.last = node;
        } else {
            node.next = head.next;
            head.next.prior = node;
            node.prior = head;
            head.next = node;
        }
        dummy.val++;
    }

    public void addLast(int data) {
        ListNode node = new ListNode(data);
        this.last.next = node;
        node.prior = this.last;
        this.last = node;
        dummy.val++;
    }

    public boolean findKey(int key) {
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void delFirstKey(int key) {
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == this.last) {
                    this.last = this.last.prior;
                    this.last.next = null;
                } else {
                    cur.prior.next = cur.next;
                    cur.next.prior = cur.prior;
                }
                break;
            }
            cur = cur.next;
        }
        dummy.val--;
    }

    public void delAllKey(int key) {
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == this.last) {
                    this.last = this.last.prior;
                    this.last.next = null;
                } else {
                    cur.prior.next = cur.next;
                    cur.next.prior = cur.prior;
                }
                dummy.val--;
            }
            cur = cur.next;
        }
    }

    public void indexList(int index, int data) {
        if (index < 0 || index > dummy.val) {
            System.out.println("位置不合法");
        } else if (index == 0) {
            addHead(data);
        } else if (index == dummy.val) {
            addLast(data);
        } else {
            ListNode cur = head.next;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            ListNode node = new ListNode(data);
            cur.prior.next = node;
            node.prior = cur.prior;
            node.next = cur;
            cur.prior = node;
        }
    }

    public void clear() {
        while (head != null) {
            ListNode cur = head.next;
            head.prior = null;
            head.next = null;
            head = cur;
        }

        this.last = null;
        dummy = null;
    }
}
