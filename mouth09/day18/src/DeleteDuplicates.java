public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        //双指针的思路，快慢指针作比较删除相同的结点
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null) {
            if(fast.val == slow.val) {
                fast = fast.next;
                slow.next = fast;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return head;
    }
}

