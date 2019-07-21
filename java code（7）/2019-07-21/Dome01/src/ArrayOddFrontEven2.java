import java.util.Arrays;

public class ArrayOddFrontEven2 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        int front = 0;
        int last = array.length - 1;
        while(front <= last) {
            if(array[front] % 2 == 0) {
                if (array[last] % 2 != 0) {
                    int tmp = array[front];
                    array[front] = array[last];
                    array[last] = tmp;
                } else {
                    last--;
                }
            } else {
                front++;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
