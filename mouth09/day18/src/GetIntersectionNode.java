public class GetIntersectionNode {
    //找到两个单链表相交的起始节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        ListNode result = null;
        //先通过循环计算出两个链表的长度
        while(curA != null) {
            lengthA++;
            curA = curA.next;
        }
        while(curB != null) {
            lengthB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        //计算出两个链表的差值
        int tmp = lengthA - lengthB;
        //判断哪个链表的节点个数多，然后让结点个数多的链表的cur先移动长度差值个位置
        //然后让两个两边的cur同时移动直到找到相同的结点位置
        if(tmp > 0) {
            for(int i = 0; i < tmp; i++) {
                curA = curA.next;
            }
            while(curA != null && curB != null) {
                //**易错点**
                //此时比较的应该是两个结点是否为同一个结点，不能比较两个结点的值，因为在相交之前可能会存在两个结点的值的一样的
                if(curA == curB) {
                    result = curA;
                    break;
                }
                curA = curA.next;
                curB = curB.next;
            }
        } else {
            for(int i = 0; i < -tmp; i++) {
                curB = curB.next;
            }
            while(curA != null && curB != null) {
                //同上
                if(curA == curB) {
                    result = curA;
                    break;
                }
                curA = curA.next;
                curB = curB.next;
            }
        }
        return result;
    }
}
