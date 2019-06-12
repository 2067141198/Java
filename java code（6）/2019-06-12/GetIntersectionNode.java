
//Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
 
public class GetIntersectionNode {
    public int getMid(ListNode head) {
        int count = 0;
      for(ListNode cur = head; cur != null; cur = cur.next) {
          count++;
      }
        return count;
    }
    
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode result = null;
        for(ListNode cur = head; cur != null; cur = cur.next) {
            ListNode next = cur.next;
            cur.next = result;
            result = cur;
            cur = next;
        }
        return result;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getMid(headA);
        int lenB = getMid(headB);
        
        ListNode longList = headA;
        ListNode shortList = headB;
        int diff = lenA - lenB;
        if(lenA < lenB) {
            longList = headB;
            shortList = headA;
            diff = lenB - lenA;
        }
        
        for(int i = 0; i < diff; i++) {
            longList = longList.next;
        }
        
        while(longList != shortList) {
            longList = longList.next;
            shortList = shortList.next;
        }
        return longList;
    }
}