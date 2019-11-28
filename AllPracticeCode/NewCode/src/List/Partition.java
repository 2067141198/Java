package List;

public class Partition {
    public static ListNode partition(ListNode pHead, int x) {
        // write code here
        if (pHead == null) {
            return null;
        }
        ListNode maxHead = null;
        ListNode last1 = null;
        ListNode minHead = null;
        ListNode last2 = null;

        while (pHead != null) {
            if (pHead.val >= x) {
                if (maxHead == null)
                    maxHead = pHead;
                else
                    last1.next = pHead;
                last1 = pHead;
            } else {
                if (minHead == null)
                    minHead = pHead;
                else
                    last2.next = pHead;
                last2 = pHead;
            }

            pHead = pHead.next;
        }
        if (minHead != null) {
            last2.next = maxHead;
            return minHead;
        }
        return maxHead;
    }

    private static ListNode BuildList() {
        ListNode n1 = new ListNode((int) (Math.random() * 10));
        ListNode n2 = new ListNode((int) (Math.random() * 10));
        ListNode n3 = new ListNode((int) (Math.random() * 10));
        ListNode n4 = new ListNode((int) (Math.random() * 10));
        ListNode n5 = new ListNode((int) (Math.random() * 10));
        ListNode n6 = new ListNode((int) (Math.random() * 10));
        ListNode n7 = new ListNode((int) (Math.random() * 10));
        ListNode n8 = new ListNode((int) (Math.random() * 10));
        ListNode n9 = new ListNode((int) (Math.random() * 10));
        ListNode n10 = new ListNode((int) (Math.random() * 10));
        ListNode n11 = new ListNode((int) (Math.random() * 10));

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;
        n11.next = null;
        return n1;
    }

    public static void main(String[] args) {
        ListNode head = BuildList();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur);
        }
        System.out.println();
        System.out.println("---------------");
        ListNode result = partition(head, 6);
        for (ListNode cur = result; cur != null; cur = cur.next) {
            System.out.print(cur);
        }
    }
}
