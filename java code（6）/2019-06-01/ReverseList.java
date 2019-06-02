class Node {
	int value;
	Node next;
	
	Node(int value) {
		this.value = value;
		this.next = null;
	}
}

public class ReverseList {
	public static Node reverseList(Node head) {
		Node newList = null;
		Node cur = head;
		while(cur != null) {
			Node next = cur.next;
			cur.next = newList;
			newList = cur;
			cur = next;
		}
		return newList;
	}
	
	public static Node reverseList2(Node head) {
		if(head == null) {
			return null;
		}
		
		Node node1 = null;
		Node node2 = head;
		Node node3 = head.next;
		while(node2 != null) {
			node2.next = node1;
			
			node1 = node2;
			node2 = node3;
			
			if(node3 != null) {
				node3 = node3.next;
			}
		}
		return node1;
	}
	
	public static void displayLinkedList(Node head) {
		for(Node cur = head; cur != null; cur = cur.next) {
			System.out.printf("(%d)-->", cur.value);
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		Node head = null;
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		displayLinkedList(n1);
		head = reverseList(n1);
		displayLinkedList(head);
		head = reverseList2(head);
		displayLinkedList(head);
	}
}