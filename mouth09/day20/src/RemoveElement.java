class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class RemoveElement {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) {
            head = head.next;
        }
        if(head == null) {
            return null;
        }
        ListNode cur = head.next;
        ListNode prev = head;
        while(cur != null) {
            if(cur.val == val) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
