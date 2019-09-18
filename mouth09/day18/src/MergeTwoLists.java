public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        if(l1 != null && l2 == null) {
            return l1;
        }
        if(l1 == null && l2 != null) {
            return l2;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode result = null;
        ListNode last = null;
        while(cur1 != null && cur2 != null) {
            if(cur1.val <= cur2.val) {
                if(result == null) {
                    result = cur1;
                } else {
                    last.next = cur1;
                }
                last = cur1;
                cur1 = cur1.next;
            } else {
                if(result == null) {
                    result = cur2;
                } else {
                    last.next = cur2;
                }
                last = cur2;
                cur2 = cur2.next;
            }
        }
        //下面是让last后面接上l1或者l2剩下的内容即cur1或者cur2.后几次写错接了l1和l2，下次切记勿错
        if(cur1 != null) {
            last.next = cur1;
            //last.next = l1;   错误的
        } else {
            last.next = cur2;
            //last.next = l2;   错误的
        }
        return result;
    }
}
