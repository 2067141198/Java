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
	
	
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(1);
		Node n5 = new Node(2);
		Node n6 = new Node(3);
		Node n7 = new Node(2);
		Node n8 = new Node(1);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = null;
		
		displayList(n1);
	}
}