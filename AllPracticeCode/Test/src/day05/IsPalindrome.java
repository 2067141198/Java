package day05;

public class IsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode cur1 = head;
        ListNode cur2 = head;
        ListNode nHead = null;
        while (cur2 != null) {
            cur2 = cur2.next;

            if (cur2 == null)
                break;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1 != null) {
            ListNode next = cur1.next;
            cur1.next = nHead;
            nHead = cur1;

            cur1 = next;
        }

        while (nHead != null) {
            if (nHead.val != head.val)
                return false;
            nHead = nHead.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n5.next = n3;
        n3.next = n4;
        n4.next = null;
        boolean b = isPalindrome(n1);
        System.out.println(b);
    }
}
