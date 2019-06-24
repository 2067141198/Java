interface List {
	//插入
	void pushFront(int val);
	void pushBack(int val);
	void insert(int index, int val);
	
	//删除
	// void popFront();
	// void popBack();
	// void earse(int index);
	
	// //根据下标查找或者修改
	// int get(int index);
	// void set(int index, int val);
	
	//返回数据个数
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
			System.out.println("下标错位！");
			return;
		}
		
		insertInternal(index, val);
	}
	
	abstract void insertInternal(int index, int val);
	
	// @Override
	// public void popFront() {
		// earse(0);
	// }
	
	// @Override 
	// public void popBack() {
		// earse(size);
	// }
	
	// @Override 
	// public void earse(int index) {
		// if(index < 0 || index > size) {
			// System.out.println("下标错位！");
			// return;
		// }
		
		// earseInternal(index);
	// }
	
	// abstract void earseInternal(int index);
	
	@Override
	public int size() {
		return size;
	}
}

class LinkedList extends abstractList implements List {
	private class Node {
		private int val;
		private Node next;
		
		Node (int val) {
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
	
	public Iterator iterator() {
		return new LinkedListIterator();
	}
}


public class ListInnerClass3 {
	static void testList(List list) {
		list.pushFront(1);
		list.pushFront(2);
		list.pushFront(3);
		list.pushFront(4);
		
		Iterator it1 = list.iterator();
		
		while(it1.hasNext()) {
			System.out.println(it1.next());
		}
	}
	
	public static void main(String[] args) {
		testList(new LinkedList());
	}
}









