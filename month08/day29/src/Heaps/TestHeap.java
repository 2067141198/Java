package Heaps;

import java.util.Arrays;

public class TestHeap {
    public static void main(String[] args) {
        int[] array = new int[]{2,4,7,4,8,1,9,4,0};
        BuildHeap.buildHeapMax(array, 9);
        System.out.println(Arrays.toString(array));
        BuildHeap.buildHeapMin(array, 9);
        System.out.println(Arrays.toString(array));
    }
}
