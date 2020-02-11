package day05;

public class ListNodeFenGe {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode newList1 = null;
        ListNode newList2 = null;
        ListNode cur = pHead;
        ListNode last1 = null;
        ListNode last2 = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < x) {
                if (newList1 == null) {
                    newList1 = cur;
                } else {
                    last1.next = cur;
                }
                last1 = cur;
                last1.next = null;
            } else {
                if (newList2 == null) {
                    newList2 = cur;
                } else {
                    last2.next = cur;
                }
                last2 = cur;
                last2.next = null;
            }
            cur = next;
        }
        if (newList1 != null) {
            last1.next = newList2;
            return newList1;
        }
        return newList2;
    }
}

