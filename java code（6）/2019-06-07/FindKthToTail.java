class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class FindKthToTail {
	public static void displayList(ListNode head) {
		for(ListNode cur = head; cur != null; cur = cur.next) {
			System.out.printf("%d-->", cur.val);
		}
		System.out.println("null");
	}
	
    public static ListNode findKthToTail(ListNode head,int k) {
        int count = 0;
        ListNode cur = head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        cur = head;
        if(count < k){
            return null;
        }
        for(int tmp = count - k; tmp > 0; tmp--) {
            cur = cur.next;
        }
        return cur;
    }
	
	public static void main(String[] args) {
		ListNode head = null;
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(7);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(6);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(11);
		
		head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = null;
		
		displayList(head);
		head = findKthToTail(head, 3);
		displayList(head);
	}
}


