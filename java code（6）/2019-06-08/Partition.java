import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode newList1 = null;
        ListNode newList2 = null;
        ListNode cur = pHead;
        ListNode last = null;
        int tmp = 0;
        while(x > 0) {
            tmp = cur.val;
            cur = cur.next;
            x--;
        }
        cur = pHead;
        while(cur != null) {
            ListNode next = cur.next;
            if(cur.val < tmp) {
                cur.next = newList1;
                newList1 = cur;
                last = cur;
            }else{
                cur.next = newList2;
                newList2 = cur;
            }
            cur = next;
        }
        last.next = newList2;
        return newList1;
    }
}