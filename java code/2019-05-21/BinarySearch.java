public class BinarySearch {
//二分查找
	public static int binarySearch(int[] array, int key) {
		int left = 0;
		int right = array.length - 1;
		//左闭右闭区间  [left, right]  只有left > right 才能代表区间内的元素都查找完毕
		while(left <= right) {
			int mid = (right - left) / 2 + left;
			if(array[mid] > key)
				right = mid - 1;
			else if(array[mid] < key)
				left = mid + 1;
			else
				return mid;
		}
		return -1;	
	}

	public static int binarySearch2(int[] array, int key) {
		int left = 0;
		int right = array.length;
		//左闭右开区间  [left, right) 只要left < right 时代表区间内还有数，
		//                            反之数组内元素都查找完毕
		while(left < right) {
			//计算中间下标
			int mid = (right - left) / 2 + left;
			//比较
			if(array[mid] > key)
				right = mid;
			else if(array[mid] < key)
				left = mid + 1;
			else
				return mid;
		}
		return -1;	
	}


	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9}; 
		System.out.println(binarySearch(array, 7));
		System.out.println(binarySearch2(array, 7));
	}
}