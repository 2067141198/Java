import java.util.HashMap;

public class Heaps {
    //准确的时间复杂度是O(n)
    //粗略估计为O(n * log(n))
    public static void createHeap(int[] array, int size) {
        int lastNodeIndex = size - 1;
        int lastparentNodeIndex = (size - 1 - 1) / 2;

        for(int i = lastparentNodeIndex; i >= 0; i--) {
            heapify(array, size, i);
        }
    }

    public static void heapify(int[] array, int size, int index) {
        while(true) {
            int left = index * 2 + 1;
            if (left > size) {
                return;
            }
            int max = left;
            if (left + 1 < size && array[left + 1] > array[left]) {
                max = left + 1;
            }

            if (array[index] >= array[max]) {
                return;
            }
            swap(array, index, max);

            index = max;
        }
    }

    //时间复杂度为O(log(n))
    public static void adjustUp(int[] array, int index) {
        while(true) {
            if (index == 0) {
                return;
            }
            if (array[index] < array[(index - 1) / 2]) {
                return;
            }
            swap(array, index, (index - 1) / 2);

            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
