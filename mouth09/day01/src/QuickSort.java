public class QuickSort {
    public static void quickSort(int[] array) {
        quickSortIntnal(array, 0, array.length - 1);
    }

    private static void quickSortIntnal(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivotIndex = partition3(array, left, right);

        quickSortIntnal(array, left, pivotIndex - 1);
        quickSortIntnal(array, pivotIndex + 1, right);
    }

    private static int partition3(int[] array, int left, int right) {
        int key = array[right];
        int slow = left;
        for(int fast = left; fast < right; fast++) {
            if(array[fast] < key) {
                swap(array, slow, fast);
                slow++;
            } else if(array[fast] == key) {

            } else {

            }
        }
        swap(array, slow, right);
        return slow;
    }

    private static int partition2(int[] array, int left, int right) {
        int key = array[right];
        int less = left;
        int great = right;
        while(less < great) {
            while(less < great && array[less] <= key) {
                less++;
            }
            array[great] = array[less];
            while(less < great && array[great] > key) {
                great--;
            }
            array[less] = array[great];
        }
        array[less] = key;
        return less;
    }

    private static int partition(int[] array, int left, int right) {
        int key = array[right];
        int less = left;
        int great = right;

        while(less < great) {
            while(less < great && array[less] <= key) {
                less++;
            }
            while(less < great && array[great] >= key) {
                great--;
            }
            swap(array, less, great);
        }
        swap(array, less, right);
        return less;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }
}
