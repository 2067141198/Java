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
        // write code here
    }
}