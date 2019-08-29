package Sorts;

public class ShellSort {
    public static void shellSort(int[] array) {
        int gap = array.length;
        while(true) {
            gap = gap / 3 + 1;
            insertSrotWithGap(array,gap);
            if(gap == 1) {
                return ;
            }
        }
    }

    private static void insertSrotWithGap(int[] array,int gap) {
        for(int i = 0; i < array.length - gap; i++) {
            int key = array[i + gap];
            for(int j = i; j >= 0 && key < array[j]; j -= gap) {
                swap(array, j + gap, j);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
