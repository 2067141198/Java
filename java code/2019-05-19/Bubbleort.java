import java.util.Arrays;

public class Bubbleort {

	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
 	}
	
	public static void bubbleot(int[] array) {
		for(int i = 0; i < array.length; i++) {
			boolean isSwapped = false;
			for(int j = 0; j < array.length - i - 1; j++) {
				if(array[j] > array[j + 1]) {
					swap(array, j, j + 1);
					isSwapped = true;
				}
			}
			if(!isSwapped)
				return;
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,3,5,7,9,2,4,6,8,0};
		System.out.println(Arrays.toString(array));
		bubbleot(array);
		System.out.println(Arrays.toString(array));
	}
}