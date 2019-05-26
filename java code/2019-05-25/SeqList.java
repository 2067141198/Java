import java.util.Arrays;

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
		//i表示的是空间下标
		for(int i = 0; i < size - 1; i++) {
			array[i] = array[i + 1];
		}
		size--;
	}
	
	//尾删
	public void popBack() {
		array[--size] = 0;
	}
	
	//删除
	public void erase(int index) {
		for(int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
		}
		size--;
	}
	
	//正序查找
	public int indexOf(int element) {
		for(int i = 0; i < size; i++) {
			if(array[i] == element)
				return i;
		}
		return -1;
	}
	
	//逆序查找
	public int indexOfBack(int element) {
		for(int i = size - 1; i >= 0; i--) {
			if(array[i] == element)
				return i;
		}
		return -1;
	}
	
	//根据下标，获取元素
	public int get(int index) {
		if(index > 0 && index < size)
			return array[index];
		return -1;
	}
	
	//给定下标，修改下标所在元素的值
	public void set(int index, int element) {
		if(index < 0 || index >= size)
			System.out.println("下标" + index + "不合法");
		array[index] = element;
	}
	
	//删除第一个遇到的元素
	public void remove(int element) {
		int i = indexOf(element);
		erase(i);
	}
	
	//删除最后一个遇到的元素
	public void removeBack(int element) {
		int i = indexOfBack(element);
		erase(i);
	}
	
	//时间复杂度是O(n),空间复杂度是O(n).因为开辟了新的空间
	public void removeAll(int element) {
		int[] array2 = new int[size];
		int j = 0;
		for(int i = 0; i < size; i++) {
			if(array[i] != element)
				array2[j++] = array[i];
		}
		size = j;
		for(int i = 0; i < size; i++) {
			array[i] = array2[i];
		}
	}
	
	//时间复杂度是O(n)，空间复杂度是O(1)，没有开辟新的空间
	public void removeAll2(int element) {
		int j = 0;
		for(int i = 0; i < size; i++) {
			if(array[i] != element)
				array[j++] = array[i];
		}
		size = j;
	}
	
	//便于打印，显示顺序表中有的元素
	public String toString() {
		return Arrays.toString(Arrays.copyOf(array, size));
	}
	
	public static void main(String[] args) {
		SeqList sq = new SeqList();
		
		sq.pushBack(1);
		sq.pushBack(2);
		sq.pushBack(3);
		System.out.println(sq.toString());
		sq.pushFront(100);
		sq.pushFront(200);
		sq.pushFront(300);
		System.out.println(sq.toString());
		sq.insert(3,50);
		sq.insert(5,50);
		System.out.println(sq.toString());
		sq.popFront();
		System.out.println(sq.toString());
		sq.popBack();
		System.out.println(sq.toString());
		sq.erase(1);
		System.out.println(sq.toString());
		int a = sq.indexOf(50);
		System.out.println(a);
		int b = sq.indexOfBack(50);
		System.out.println(b);
		int c = sq.get(2);
		System.out.println(c);
		sq.set(2,400);
		System.out.println(sq.toString());
		System.out.println();
		
		SeqList sq2 = new SeqList();
		sq2.pushBack(1);
		sq2.pushBack(2);
		sq2.pushBack(3);
		sq2.pushBack(4);
		sq2.pushBack(1);
		sq2.pushBack(2);
		sq2.pushBack(3);
		sq2.pushBack(4);
		sq2.pushBack(5);
		System.out.println(sq2.toString());
		sq2.remove(2);
		System.out.println(sq2.toString());
		sq2.removeBack(2);
		System.out.println(sq2.toString());
		sq2.removeAll(3);
		System.out.println(sq2.toString());
		sq2.removeAll2(4);
		System.out.println(sq2.toString());
		
	}
}














