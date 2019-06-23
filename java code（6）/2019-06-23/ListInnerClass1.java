interface List {
	//插入
	void pushFront(int val);
	void pushBack(int val);
	void insert(int index, int val);
	
	//删除
	void popFront();
	void popBack();
	void earse(int index);
	
	//根据下标访问或者修改
	int get(int index);
	void set(int index, int val);
	
	//返回数据个数
	int size();
	
	void display();
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
		}
		
		earseInternal(index);
	}
	
	abstract void earseInternal(int index);
	
	
	@Override
	public int size() {
		return size;
	}
	
	abstract public void display();
}

class ArrayList extends abstractList implements List {
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
	public void display() {
		for(int i = 0; i < size; i++) {
			System.out.println(array[i]);
		}
	}
}

public class ListInnerClass {
	private static void testList(List list) {
		list.pushBack(1);
		list.pushBack(2);
		list.pushBack(3);
		list.pushFront(10);
		list.pushFront(20);
		list.pushFront(30); //30 20 10 1 2 3
		list.popFront(); //20 10 1 2 3
		list.popBack(); // 20 10 1 2
		list.earse(1); // 20 1 2
		list.pushBack(1);
		list.pushBack(2);
		list.pushBack(3); //20 1 2 1 2 3
		list.set(2, 10); //20 1 10 1 2 3
		
		list.display();
		System.out.println("==========");
		System.out.println(list.get(1)); // 1
	}
	
	
	public static void main(String[] args) {
		testList(new ArrayList());
	}
}








