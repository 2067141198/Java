public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class PalindromeList {
	public ListNode getMiddle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null) {
			fast = fast.next;
			if(fast == null) {
				break;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode result = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode next = cur.next;
			
			cur.next = result;
			result = cur;
			
			cur = next;
		}
		return result;
	}
	
    public boolean chkPalindrome(ListNode A) {
        ListNode mid = getMiddle(A);
		ListNode head2 = reverseList(mid);
		
		ListNode n1 = A;
		ListNode n2 = head2;
		
		while(n1 != null && n2 != null) {
			if(n1.val != n2.val) {
				return false;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		return true;
    }
}