package List;

/**
 * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 */
public class ListNodeAAndB {
    public static ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        //两个链表结点值和构成新链表的头结点
        ListNode resultHead = null;
        //新链表的尾节点
        ListNode last = null;
        //用来表示是否有进位
        int count = 0;
        //两个链表都不为空的时候，使两个链表的结点的值相加并同时移动
        while (a != null && b != null) {
            int val = a.val + b.val + count;
            //当两节点和大于10 表示有进位得分开讨论
            if (val < 10) {
                //在给新链表插入时得判断头结点是否为空，以防出现NullPointerException
                if (resultHead == null) {
                    resultHead = new ListNode(val);
                    last = resultHead;
                } else {
                    last.next = new ListNode(val);
                    last = last.next;
                }
            } else {
                if (resultHead == null) {
                    resultHead = new ListNode(val % 10);
                    last = resultHead;
                } else {
                    last.next = new ListNode(val % 10);
                    last = last.next;
                }
            }

            count = val / 10;
            a = a.next;
            b = b.next;
        }

        //当两个链表不同时为空时，考虑以下几种情况
        //1.当没有进位时，直接把不为空链表的剩余部分接在新链表后面即为结果链表
        //2.有进位，且有一个链表不为空的时候，继续遍历到结束
        //3.有进位，但两个链表都为空的时候，在新链表最后添加一个值为进位值的结点，即结果链表
        if (count == 0) {
            if (a != null) {
                last.next = a;
            } else {
                last.next = b;
            }
        } else if (a != null || b != null) {
            if (a != null) {
                while (a != null) {
                    int val = a.val + count;
                    if (val < 10) {
                        last.next = new ListNode(val);
                        last = last.next;
                    } else {
                        last.next = new ListNode(val % 10);
                        count = val / 10;
                        last = last.next;
                    }
                    a = a.next;
                }
            } else {
                while (b != null) {
                    int val = b.val + count;
                    if (val < 10) {
                        last.next = new ListNode(val);
                        last = last.next;
                    } else {
                        last.next = new ListNode(val % 10);
                        count = val / 10;
                        last = last.next;
                    }
                    b = b.next;
                }
            }
        } else {
            last.next = new ListNode(count);
        }

        return resultHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        ListNode n11 = new ListNode(2);
        ListNode n21 = new ListNode(7);
        ListNode n31 = new ListNode(2);
        ListNode n41 = new ListNode(3);
        ListNode n51 = new ListNode(4);
        n11.next = n21;
        n21.next = n31;
        n31.next = n41;
        n41.next = n51;
        n51.next = null;

        ListNode result = plusAB(n1, n11);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
