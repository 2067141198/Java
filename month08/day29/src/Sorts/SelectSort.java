package Sorts;

public class SelectSort {
    public static void selectSort(int[] array) {
        // 无序区间	[0, array.length - i)
        // 有序区间	[array.lenngth - i, array.length)
        for (int i = 0; i < array.length - 1; i++) {
            int max = 0;
            for(int j = 1; j < array.length - i; j++) {
                if(array[j] >= array[max]) {
                    max = j;
                }
            }
            swap(array, max, array.length - i - 1);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
