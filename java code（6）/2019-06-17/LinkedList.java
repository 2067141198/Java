
class Node {
	int val;
	Node next;
	
	Node(int val) {
		this.val = val;
	}
}

public Linked {
	private int size;
	private Node head;
	
	public getSize() {
		return size;
	}
	
	public void pushFront(int val) {
		Node node = new Node(val);
		node.next = head;
		this.head = node;
		
		size++;
	}
	
	public void pushBack(int val) {
		if(head == null) {
			pushFront(val);
		} else {
			Node last = head;
			while(last.next != null) {
				last = last.next;
			}
			last.next = new Node(val);
			size++;
		}
	}
	
	public void popFront() {
		if(head == null) {
			System.out.println("应该抛异常处理");
		} else {
			head = head.next;
			size--;
		}
	}
	
	public void popBack() {
		if(head == null) {
			System.out.println("应该抛异常处理");
		} else if( head.next == null) {
			head = null;
			size = 0;
		} else {
			Node lastSecond = head;
			while(lastSecond.next.next != null) {
				lastSecond = lastSecond.next;
			}
			lastSecond.next = null;
			size--;
		}
	}
}

public class LinkedList{
	public static void main(String[] args) {
		Linked linkde = new Linkde();
		linked.pushFront(1);
		linked.pushFront(2);
		linked.pushFront(3);
		linked.pushFront(4);
	}
}


