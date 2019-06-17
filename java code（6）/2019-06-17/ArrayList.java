
class Array {
	private int[] array;
	private int size;
	
	public Array(int i) {
		array = new int[i];
	}
	
	public getSize() {
		return size;
	}
	
	public pushBack(int val) {
		array[size++] = val;
	}
	
	public pushFront(int val) {
		for(int i = 0; i < size; i++) {
			array[i + 1] = array[i]; 
		}
		array[0] = val;
		size++;
 	}
	
	public popBack() {
		if(size == 0) {
			System.out.println("应该是抛异常");
		} else {
			size--;
		}
	}
	
	public popFront() {
		if(size == 0) {
			System.out.println("应该是抛异常");
		} else {
			for{int i = 0; i < size - 1; i++} {
				array[i] = array[i + 1];
			}
			size--;
		}
	}
} 

public class ArrayList{
	public static void main(String[] args) {
		Array array = new Array();
		
		array.pushBack(1);
		array.pushBack(2);
		array.pushBack(3);
		array.pushBack(4);
		
	}
	
}




