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




