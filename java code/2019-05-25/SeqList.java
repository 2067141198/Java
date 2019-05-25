public class SeqList {
	private int[] array;
	private int size;
	
	SeqList() {
		array = new int[11];
		size = 0;
	}
	
	//头插
	public void pushFront(int element) {
		//i代表的是数据下标
		for(int i = size - 1; i >= 0; i--) {
			array[i + 1] = array[i];
		}
		array[0] = element;
		size++;
	}
	
	//尾插
	public void pushBack(int element) {
		array[size++] = element;
	} 
	
	//插入
	public void insert(int index, int element) {
		for(int i = size - 1; i >= index; i--) {
			array[i + 1] = array[i];
		}
		array[index] = element;
		size++;
	}
	
	//头删
	public void popFront() {
		
	}
	
	//尾删
	public void popBack() {
		
	}
	
	//删除
	public void erase(int index) {
		
	}
	
	//查找
	public int indexOf(int element) {
		return -1;
	}
	
	//根据下标，获取元素
	public int get(int index) {
		return -1;
	}
	
	//给定下标，修改下标所在元素的值
	public void set(int index, int element) {
		
	}
	
	//删除第一个遇到的元素
	public void remove(int element) {
	
	}
	
	public void removeAll(int element) {
		
	}
	
	//便于打印，显示顺序表中有的元素
	public String toString() {
		return Arrays.toString(Arrays.copyOf(array, size));
	}
}














