import java.util.List;

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode node = copy(head);
        ListNode reverseHead = reverse(node);
        ListNode cur = head;
        ListNode cur2 = reverseHead;
        while(cur != null) {
            if(cur.val != cur2.val) {
                return false;
            }
            cur = cur.next;
            cur2 = cur2.next;
        }
    return true;
}

    private static ListNode copy(ListNode head) {
        ListNode newNode = new ListNode(head.val);
        ListNode node = newNode;
        for(ListNode cur = head.next; cur != null; cur = cur.next) {
            node.next = new ListNode(cur.val);
            node = node.next;
        }
        return newNode;
    }

    public static ListNode reverse(ListNode head) {
        ListNode newNode = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;

            cur.next = newNode;
            newNode = cur;

            cur = next;
        }
        return newNode;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        System.out.println(isPalindrome(n1));
    }
}
