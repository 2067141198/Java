
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
        ListNode last1 = null;
        ListNode last2 = null;
        while(cur != null) {
            if(cur.val < x) {
				if(newList1 == null) {
					newList1 = cur;
				} else {
					last1.next = cur;
				}
                last1 = cur;
            } else {
				if(newList2 == null) {
					newList2 = cur;
				} else {
					last2.next = cur;
				}
				last2 = cur;
            }
            cur = cur.next;
        }
		if(newList1 == null) {
			return newList2;
		} else {
			last1.next = newList2;
			if(last2 != null) {
				last2.next == null;
			}
			return newList1;
		}
    }
}