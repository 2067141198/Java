import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
        int[] array = new int[]{9,8,7,6,5,4,3,2,1,0};
        int[] array2 = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] array3 = new int[]{1,3,4,6,8,9,0,5,2,7};
        System.out.println("array数组为：" + Arrays.toString(array));
        System.out.println("array2数组为：" + Arrays.toString(array2));
        System.out.println("array3数组为：" + Arrays.toString(array3));
        QuickSrotNoR.quickSortNoR(array);
        QuickSrotNoR.quickSortNoR(array2);
        QuickSrotNoR.quickSortNoR(array3);
        System.out.println("array数组快排后结果是：" + Arrays.toString(array));
        System.out.println("array2数组快排后结果是：" + Arrays.toString(array2));
        System.out.println("array3数组快排后结果是：" + Arrays.toString(array3));
    }
}
