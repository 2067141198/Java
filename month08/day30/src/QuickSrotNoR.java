import java.util.Stack;

public class QuickSrotNoR {
    public static void quickSortNoR(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length- 1);
        stack.push(0);
        while(!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            if(left >= right) {
                continue;
            }
            int pivotIndex = partition(array, left, right);

            stack.push(right);
            stack.push(pivotIndex + 1);

            stack.push(pivotIndex - 1);
            stack.push(left);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int less = left;
        int great = right;
        while(less < great) {
            while(less < great && array[less] <= pivot) {
                less++;
            }
            array[great] = array[less];
            while(less < great && array[great] >= pivot) {
                great--;
            }
            array[less] = array[great];
        }
        array[less] = pivot;
        return less;
    }
}
