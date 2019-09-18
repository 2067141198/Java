public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        //用到双指针思路，一个指针一次向后移动一个结点，一个指针向后移动两个结点，链表带环的话快慢指针总会相遇的
        //只要判断相遇的情况返回true；其他均为false
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null) {
            fast = fast.next;
            if(fast == slow) {
                return true;
            }
            slow = slow.next;
            //快的指针移动一次后可能会指向null，若直接让fast继续移动的话会产生空指针异常
            //必须对fast进行判断是否为null后，才能让fast继续向后移动一步，否则退出循环
            if(fast != null) {
                fast = fast.next;
                if(fast == slow) {
                    return true;
                }
            }
        }
        return false;
    }
}
