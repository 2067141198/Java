import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
        int[] array = new int[]{5,2,7,9,2,0,1,8,6,9,3};
        int[] array2 = new int[]{9,8,7,6,5,4,3,2,1,0};
        System.out.println(Arrays.toString(array));
        QuickSort.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
