package Arrays;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        int index = right;
        while (index >= 0) {
            int i = (int) Math.pow(A[left], 2);
            int j = (int) Math.pow(A[right], 2);
            if (i > j) {
                res[index--] = i;
                left++;
            } else {
                res[index--] = j;
                right--;
            }
        }
        return res;
    }
}

