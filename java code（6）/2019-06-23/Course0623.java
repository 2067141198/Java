class Node {
	int val;
	Node next;
	
	Node (int val) {
		this.val = val;
	}
	
	Node (int val, Node next) {
		this.val = val;
		this.next = next;
	}
}

class List {
	private int size;
	
	List() {
		size = 0;
	}
	
	public void pushFront(int val) {
		insert(0, val);
	}
	
	public void pushBack(int val) {
		insert(size, val);
	}
	
	public void insert(int index, int val);
	
	protected void incSize() {
		size++;
	}
}

class ArrayList extends List {
	
}

class LinkedList extends List {
	private Node head = null;
	
	public void insert(int index, int val) {
		Node node = new Node(val);
		if(index == 0) {
			node.next = head;
			head = node;
		} else {
			Node cur = head;
			for(int i = 0; i < index - 1; i++) {
				cur = cur.next;
			}
			node.next = cur.next;
			cur.next = node;
		}
		
		super.incSize();
	}
	
	public void display() {
		for(Node cur = head; cur != null; cur = cur.next) {
			System.out.println(cur.val);
		}
	}
}

public class Course0623 {
	public static void main(String[] args) {
		
	}
}

