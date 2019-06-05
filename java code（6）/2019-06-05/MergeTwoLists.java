
class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) { 
		val = x; 
	}
}

public class MergeTwoLists {
	public static void displayList(ListNode head) {
		for(ListNode cur = head; cur != null; cur = cur.next) {
			System.out.printf("%d-->", cur.val);
		}
		System.out.println("null");
	}
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {return l2;}
        if(l2 == null) {return l1;}
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode result = null;
        ListNode last = null;
        
        while(cur1 != null && cur2 != null) {
            if(cur1.val <= cur2.val) {
                ListNode next = cur1.next;
                if(result == null) {
                    cur1.next = result;
                    result = cur1;
                }else{
                    last.next = cur1;
                }
                last = cur1;
                cur1 = next;
            }else{
                ListNode next = cur2.next;
                if(result == null) {
                    cur2.next = result;
                    result = cur2;
                }else{
                    last.next = cur2;
                }
                last = cur2;
                cur2 = next;
            }
        }
        
        if(cur1 != null) {
            last.next = cur1;
        }else{
            last.next = cur2;
        }
        return result;
    }
	
	public static void main(String[] args) {
		ListNode head = null;
		ListNode head1 = null;
		ListNode head2 = null;
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(7);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(6);
		ListNode n8 = new ListNode(8);
		ListNode n9 = new ListNode(11);
		
		head1 = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		
		head2 = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = null;
		
		displayList(head1);
		displayList(head2);
		head = mergeTwoLists(head1, head2);
		displayList(head);
	}
}