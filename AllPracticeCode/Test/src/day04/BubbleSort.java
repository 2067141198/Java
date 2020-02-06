package day04;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1])
                    swap(array, j, j + 1);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
