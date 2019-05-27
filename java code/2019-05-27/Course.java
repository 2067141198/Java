import java.util.Arrays;

public class Course {
	private int[] array;
	private int size;
	
	Course() {
		array = new int[11];
		size = 0;
	}
	
	static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	static void bubbleSort(int[] array) {
		int length = array.length;
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length - i - 1; j++) {
				if(array[j] > array[j + 1])
					swap(array, j, j + 1);
			}
		}
	}
	
	public static int binarySeach(int[] array, int key) {
		int left = 0;
		int right = array.length;
		while(left < right) {
			int mid = (right - left) / 2 + left;
			if(key > array[mid]) {
				left = mid + 1;
			}else if(key < array[mid]){
				right = mid;
			}else{
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {1,3,5,7,9,2,4,6,8};
		int[] array2 = {1,2,3,4,5,6,7,8,9};
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
		int n = binarySeach(array2, 5);
		System.out.println(n);
	}
}