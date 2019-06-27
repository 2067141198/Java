interface List{
	void pushFront(int val);
	void pushBack(int val);
	void insert(int index, int val);
	
	void popFront();
	void popBack();
	void earse(int index);
	
	int get(int index);
	void set(int index, int val);
	
	int size(); 
	
	Iterator iterator();
}

interface Iterator {
	boolean hasNext();
	int next();
}

abstract class abstractList implements List {
	protected int size;
	
	@Override
	public void pushFront(int val) {
		insert(0, val);
	}
	
	@Override
	public void pushBack(int val) {
		insert(size, val);
	}
	
	@Override
	public void insert(int index, int val) {
		if(index < 0 || index > size) {
			System.out.println("下标错误！");
			return;
		}
		
		insertInternal(index, val);
	}
	
	abstract void insertInternal(int index, int val);
	
	@Override
	public void popFront() {
		earse(0);
	}
	
	@Override
	public void popBack() {
		earse(size);
	}
	
	@Override
	public void earse(int index) {
		if(index < 0 || index > size) {
			System.out.println("下标错误！");
			return;
		}
		
		earseInternal(index);
	}
	
	abstract void earseInternal(int index);
	
	@Override
	public int size() {
		return size;
	}
}

class ArrayList extends abstractList implements List {
	private class ArrayListIterator implements Iterator {
		private int currentIndex;
		
		ArrayListIterator() {
			this.currentIndex = 0;
		}
		
		@Override
		public boolean hasNext() {
			return currentIndex < size();
		}
		
		@Override
		public int next() {
			int val = array[currentIndex];
			currentIndex++;
			return val;
		}
	}
	
	private int[] array = new int[100];
	
	@Override
	public void insertInternal(int index, int val) {
		for(int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}
		array[index] = val;
		size++;
	}
	
	@Override
	public void earseInternal(int index) {
		for(int i = index; i < size; i++) {
			array[i] = array[i + 1];
		}
		size--;
	}
	
	@Override
	public int get(int index) {
		return array[index];
	}

	@Override	
	public void set(int index, int val) {
		array[index] = val;
	}
	
	@Override
	public Iterator iterator() {
		return new ArrayListIterator();
	}
}

class LinkedList extends abstractList implements List {
	private class Node {
		int val;
		Node next;
		
		Node(int val) {
			this.val = val;
		}
		
		Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}
	
	private class LinkedListIterator implements Iterator {
		private Node cur = head;
		
		@Override
		public boolean hasNext() {
			return cur != null;
		}
		
		@Override
		public int next() {
			int val = cur.val;
			cur = cur.next;
			return val;
		}
	}
	
	private Node head = null;
	
	@Override
	public void insertInternal(int index, int val) {
		if(index == 0) {
			head = new Node(val, head);
		} else {
			Node cur = head;
			for(int i = 0; i < index - 1; i++) {
				cur = cur.next;
			}
			cur.next = new Node(val, cur.next);
		}
		size++;
	}
	
	@Override
	public void earseInternal(int index) {
		if(index == 0) {
			head = head.next;
		} else if (index == size) {
			Node cur = head;
			for(int i = 0; i < index - 2; i++) {
				cur = cur.next;
			}
			cur.next = null;
		} else {
			Node cur = head;
			for(int i = 0; i < index - 2; i++) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		size--;
	}
	
	@Override
	public int get(int index) {
		Node cur = head;
		for(int i = 1; i < index; i++) {
			cur = cur.next;
		}
		return cur.val;
	}
	
	@Override
	public void set(int index, int val) {
		Node cur = head;
		for(int i = 1; i < index; i++) {
			cur = cur.next;
		}
		cur.val = val;
	}
	
	@Override
	public Iterator iterator() {
		return new LinkedListIterator();
	}
}

public class ListInnerClass4 {
	static void testList(List list) {
		list.pushFront(1);
		list.pushFront(2);
		list.pushFront(3);
		list.pushFront(4);
		list.pushFront(5);
		list.pushBack(10);
		list.pushBack(20);
		list.pushBack(30);
		list.pushBack(40);
		list.pushBack(50); //5 4 3 2 1 10 20 30 40 50
		list.popFront();
		list.popBack(); // 4 3 2 1 10 20 30 40 
		list.earse(3);
		list.insert(4, 90);
		
		Iterator it1 = list.iterator();
		
		while(it1.hasNext()) {
			System.out.println(it1.next());
		}
	}
	
	public static void main(String[] args) {
		testList(new ArrayList());
		System.out.println("==========");
		testList(new LinkedList());
	}
}




