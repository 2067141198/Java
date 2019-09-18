class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReverseList {
    //用迭代法反转链表
    public ListNode reverseList1(ListNode head) {
        if(head == null) {
            return null;
        }
        //定义两个引用，一个代表着反转后链表的最后一个节点，一个代表遍历到的结点
        ListNode last = head;
        ListNode cur = head.next;
        //只要遍历到的结点不为空，循环继续下去
        while(cur != null) {
            //定义一个引用指向cur.next，原因是下面的反转会更改cur的值，导致cur无法正常的向后移动
            ListNode next = cur.next;

            //为了保证链表在反转的过程中不会断成两段链表
            last.next = next;
            //让遍历到的结点的next等于head，相当于将cur之前的结点已经进行过反转
            cur.next = head;
            //让head等于cur，每次将cur放在原来head的之前时，链表的head就已经发生了改变，变成了cur，实时更新head
            head = cur;

            //更新cur的位置
            cur = next;
        }
        //循环走完时，链表全部进行了反转，此时的head也已经指向原链表的最后一个结点，直接返回head便可
        return head;
    }

    //递归写法
    public ListNode reverseList2(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode last = head;
        ListNode cur = head.next;

        return reverse(head, last, cur);
    }
    public ListNode reverse(ListNode head, ListNode last, ListNode cur) {
        if(cur == null) {
            return head;
        }
        ListNode next = cur.next;
        cur.next = head;
        last.next = next;

        return reverse(cur, last, next);
    }
}
