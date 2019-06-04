
class ListNode {
	int val;
	ListNode next;
	
	ListNode(int val) {
		this val = val; 
	}
}

public class Solution {
	public static void display(ListNode head) {
		for(ListNode cur = head; cur != null; cur = cur.next) {
			System.out.printf("%d-->", cur.val);
		}
		System.out.printf("null");
	}
	
    public static ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        cur = head;
        if(count % 2 != 0) {
            for(int i = count % 2 + 1; i > 0; i--) {
                cur = cur.next;
            }
        }else{
            for(int i = (count + 1) % 2; i > 0; i--) {
                cur = cur.next;
            }
        }
        return cur;
    }
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
	}
}



