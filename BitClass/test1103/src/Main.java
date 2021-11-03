
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
class ListNode{
    char val;
    ListNode next;
    ListNode(char val){
        this.val=val;
    }
}
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        char ch=s.charAt(0);
        ListNode head=new ListNode(ch);
        for(int i=1;i<n;i++){
            ch=s.charAt(i);
            if(ch=='['||ch=='('||ch=='{'){
                addHead(head,ch);
            }else if(head!=null&&ch==')'&&head.val=='('){
                head=head.next;
            }else if(head!=null&&ch==']'&&head.val=='['){
                head=head.next;
            }else if(head!=null&&ch=='}'&&head.val=='{'){
                head=head.next;
            }else{
                return false;
            }
        }
        if(head!=null) return false;
        return true;
    }
    public void addHead(ListNode head,char val){
        ListNode cur=new ListNode(val);
        cur.next=head;
        head=cur;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution fun = new Solution();
        String s="()[]{}";
        System.out.println(fun.isValid(s));
    }

}
