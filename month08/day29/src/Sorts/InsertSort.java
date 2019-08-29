package Sorts;

public class InsertSort {
    public static void insertSort(int[] array) {
        //有序区间  [0, i]
        //无序区间  [i + 1, array.length)
        for (int i = 0; i < array.length - 1; i++) {
            int key = array[i + 1];
            for(int j = i; j >= 0 && key < array[j]; j--) {
                //array[j + 1] = array[j];
                swap(array, j + 1, j);
            }
            //array[j + 1] = key;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
