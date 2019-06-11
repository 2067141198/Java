/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode prve = null;
        ListNode p1 = pHead;
        ListNode p2 = pHead.next;
        if(p1.val != p2.val) {
            prve = p1;
            p1 = p1.next;
            p2 = p2.next;
        } else {
            
            if(p2.val != null && p2.val == p1.val) {
                p2 = p2.next;
            }
            if(prve == null) {
                pHead = p2; 
            } else {
                prve.next = p2;
            }
            p1 = p2;
            p2 = p2.next;
        }
        return p1;
    }
}