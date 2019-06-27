interface list{
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
	
	public void pushFront(int val) {
		insert(0, val);
	}
	
	public void pushBack(int val) {
		insert(size, val);
	}
	
	public void insert(int index, int val) {
		if(index < 0 || index > size) {
			System.out.println("下标错误！");
			return;
		}
		
		insertInternal(index, val);
	}
	
	abstract insertInternal(int index, int val);
	
	public void popFront() {
		earse(0);
	}
	
	public void popBack() {
		earse(size);
	}
	
	public void earse(int index) {
		if(index < 0 || index > size) {
			System.out.println("下标错误！");
			return;
		}
		
		earseInternal(index);
	}
	
	abstract void earseInternal(int index);
}

class ArrayList extends abstractList implements List, Iterator {
	private class ArrayListIterator implements Iterator {
		
	}
	
	
}

class LinkedList extends abstractList implements List, Iterator {
	private class LinkedListIterator implements Iterator {
		
	}
	
	
}

public class ListInnerClass4 {
	static void testList(List list) {
		
	}
	
	public static void main(String[] args) {
		testList(new ArrayList());
		testList(new LinkedList());
	}
}




