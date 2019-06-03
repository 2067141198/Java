class Node {
	int val;
	Node next;
	
	Node(int val) {
		this.val = val;
		this.next = null;
	}
}

public class RemoveElements {
	public static void displayList(Node head) {
		for(Node cur = head; cur != null; cur = cur.next) {
			System.out.printf("%d-->", cur.val);
		}
		System.out.println("null");
	}
	
	public static Node removeElements(Node head, int val) {
		if(head == null) {
			return null;
		}
		
		Node cur = head.next;
		Node prve = head;
		
		while(cur != null) {
			if(cur.val == val) {
				prve.next = cur.next;
			}else{
				prve = cur;
			}
			
			cur = cur.next;
		}
		
		if(head.val == val) {
			return head.next;
		}
		
		return head;
	}
	
	public static Node removeElements2(Node head, int val) {
		Node newList = null;
		Node cur = head;
		while(cur != null) {
			Node next = cur.next;
			if(cur.val != val) {
				if(newList == null) {
					cur.next = newList;
					newList = cur;
				}else{
					Node last = newList;
					while(last.next != null){
						last = last.next;
					}
					last.next = cur;
					cur.next = null;
				}
			}
			cur = next;
		}
		return newList;
	}
	
	public static void main(String[] args) {
		Node head = null;
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(1);
		Node n5 = new Node(2);
		Node n6 = new Node(3);
		Node n7 = new Node(2);
		Node n8 = new Node(1);
		
		head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = null;
		
		displayList(head);
		head = removeElements2(head, 1);
		displayList(head);
	}
}