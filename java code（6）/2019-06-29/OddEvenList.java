
Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode head2 = p2;
        int nodes = 0;
        for(ListNode cur = head; cur != null; cur = cur.next) {
            nodes++;
        }
        int count = nodes % 2 - 1;
        while(count > 0) {
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1.next;
            p2 = p2.next;
            count--;
        }
        if(nodes % 2 == 0) {
            p1.next = head2;
			
        } else {
            p1.next = p2.next;
            p1 = p1.next;
            
            p1.next = head2;
        }
        
        return head;
    }
}