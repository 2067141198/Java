
class DNode {
	int val;
	Node next;
	Node prev;
	
	Node(int val) {
		this.val = val;
	}
}

public class DLinkedList{
	private DNode head;
	private DNode last;
	private int size;
	
	public int getSize() {
		return size;
	}
	
	public void pushFront(int val) {
		DNode node = new DNode(val);
		node.next = head;
		head = node;
		//双向链表头插时得考虑最后一个结点是否为 null
		if(last == null) {
			last = null;
		}
		size++;
	}
	
	public void pushBack(int val) {
		if(head == null) {
			pushFront(val);
		} else {
			last.next = new DNode(val);
			//双向链表把尾插的结点于倒数第二个结点联系起来
			last.next.prev = last;
			//刷新 last 的指向
			last = last.next;
			size++;
		}
	}
	
	public void popFront() {
		if(head == null) {
			return null;
		} else {
			head = head.next;
			//判断头删的是不是唯有的一个结点，是的话代表 last 也为空了，所以得单独考虑
			if(head == null) {
				last == null;
			}
			size--;
		}
	}
	
	public void popBack() {
		if(head == null) {
			return null;
		} else if(head.next == null) {
			popFront();
		} else {
			last = last.prev;
			//刷新 last 的指向后，得再次确定 last 的 next 为 null
			last.next = null;
			size--;
		}
	}
}










