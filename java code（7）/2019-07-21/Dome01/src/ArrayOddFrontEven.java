import java.util.Arrays;

public class ArrayOddFrontEven {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] odd = new int[array.length];
        int[] even = new int[array.length];
        int oddIndex= 0;
        int evenIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                odd[oddIndex++] = array[i];
            } else {
                even[evenIndex++] = array[i];
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(odd));
        System.out.println(Arrays.toString(even));
        for (int i = 0; i < evenIndex; i++) {
            odd[oddIndex++] = even[i];
        }
        System.out.println(Arrays.toString(odd));
        array = Arrays.copyOf(odd, odd.length);
        System.out.println(Arrays.toString(array));
    }
}
