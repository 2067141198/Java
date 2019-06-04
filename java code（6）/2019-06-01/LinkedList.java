class Node {
	int value;
	Node next;
	
	public Node (int value) {
		this.value = value;
		this.next = null;
	}
}

public class LinkedList {
	//打印
	public static void displayLinkedList(Node head) {
		for(Node cur = head; cur != null; cur = cur.next) {
			System.out.printf("%d-->", cur.value);
		}
		System.out.println("null");
	}
	
	//头插
	public static Node pushFront(Node head, int value) {
		Node cur = head;
		Node node = new Node(value);
		node.next = cur;
		return node;
		
	}
	
	//尾插
	public static Node pushBack(Node head, int value) {
		return head;
	}
	
	public static Node getLast(Node head) {
		return head;
	}
	
	//头删
	public static Node popFront(Node head) {
		return head;
	}
	
	//尾删
	public static Node popBack(Node head) {
		if(head == null) {
			return null;
		}
		Node cur = head;
		Node last = null;
		if(cur.next == null) {
			return cur.next;
		}else{
			while(cur.next.next != null) {
				cur = cur.next;
			}
			last = cur;
			last.next = null;
		}
		return head;
	}
	
	
	public static void main(String[] args) {
		Node head = null;
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		displayLinkedList(head);
		head = pushFront(head, 3);
		displayLinkedList(head);
		head = popBack(head);
		displayLinkedList(head);
		
	}
}