package Sorts;

public class QuickSort {
    public static void quickSort(int[] array) {
        quickSortInternal(array, 0, array.length - 1);
    }

    private static void quickSortInternal(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }

        int pivotIndex = partition1(array, left, right);

        quickSortInternal(array, left, pivotIndex - 1);
        quickSortInternal(array, pivotIndex + 1, right);
    }

    private static int partition1(int[] array, int left, int right) {
        //定义前后两个指针，一个从最左边开始，另一个从最右边开始，左边的直到遇到大于基准值的元素时停止移动，
        //右边的直到遇到小于基准值的元素时停止，交换两个位置处的元素，然后两个指针继续按上述要求移动交换
        int pivot = array[right];
        int less = left;
        int great = right;
        while(less < great) {
            if(array[less] < pivot) {
                less++;
            }
            if(array[great] > pivot) {
                great--;
            }
            swap(array, less, great);
        }
        return less;
    }

    public static int partition2(int[] array, int left, int right) {
        //定义两个指针，一个从最左边开始，一个从最右边开始。首先将基准值备份一份，然后左指针遇到大于基准值的元素时
        //就将该元素赋值到原基准值的下标处，右边的指针遇到小于基准值的元素时将值赋给左边指针指向的下标处。直到两个
        //相遇时说明整个数组都遍历了一遍，再将基准值赋值到两指针相遇时的那个下标处
        int pivot = array[right];
        int less = left;
        int great = right;
        while(less < great) {
            while (less < great && array[less] <= pivot) {
                less++;
            }
            array[great] = array[less];
            while (less < great && array[great] >= pivot) {
                great--;
            }
            array[less] = array[great];
        }
        array[less] = pivot;
        return less;
    }

    public static int partition3(int[] array, int left, int right) {
        //定义两个指针，开始时两个都指向最左边的元素，然后其中一个指针遍历这个数组中的所有元素
        //遍历到的元素时小于基准值的时候，两个指针同时往前走
        //如果遍历到的元素大于基准值时，快的指针继续遍历到下一个小于基准值的元素，慢的指针在在第一个大于基准值的
        // 元素处不动，然后堆两个指针指向的元素进行交换，再使慢的指针往前走一步
        //始终保证两个指针之间内的元素都是大于基准值的元素
        int pivot = array[right];
        int less = left;
        for (int i = left; i < array.length - 1; i++) {
            if (array[i] < pivot) {
                swap(array, less, i);
                less++;
            }
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
