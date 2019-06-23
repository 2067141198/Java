interface List {
	//插入
	void pushFront(int val);
	void pushBack(int val);
	void insert(int index, int val);
	
	//删除
	void popFront();
	void popBack();
	void earse(int index);
	
	//根据下标查找或修改
	int get(int index);
	void set(int index, int val);
	
	//返回数据个数
	int size();
	
	//统一的遍历方式
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
	
	abstract public void insertInternal(int index, int val);
	
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
	
	abstract public void earseInternal(int index);
	
	@Override
	public int size() {
		return size;
	}
}

class ArrayList extends abstractList implements List {
	private class ArrayListIterator implements Iterator {
		private int currentIndex;
		
		ArrayListIterator() {
			currentIndex = 0;
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

public class ListInnerClass2 {
	private static void testList(List list) {
		list.pushFront(1);
		list.pushFront(2);
		list.pushFront(3);
		list.pushFront(4);
		list.pushBack(10);
		list.pushBack(20);
		list.pushBack(30);
		list.pushBack(40); //4 3 2 1 10 20 30 40
		list.popFront();
		list.popBack(); // 3 2 1 10 20 30
		list.earse(3);  // 3 2 1 20 30
		list.set(2, 40);// 3 2 40 20 30 
		
		
		Iterator it1 = list.iterator();
		
		while(it1.hasNext()) {
			System.out.println(it1.next());
		} 
		
		System.out.println("============");
		System.out.println(list.get(3));
	}
	
	public static void main(String[] args) {
		testList(new ArrayList());
	}
}









