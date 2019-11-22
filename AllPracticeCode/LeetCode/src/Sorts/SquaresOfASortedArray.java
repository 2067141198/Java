package Sorts;

public class SquaresOfASortedArray {
    public static int[] sortedSquares(int[] A) {
        for(int i = 0; i < A.length; i++) {
            A[i] = (int)Math.pow(A[i], 2);
        }
        sort(A);
        return A;
    }

    public static void sort(int[] A) {
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A.length - i - 1; j++) {
                if(A[j] > A[j + 1]) {
                    int tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                }
            }
        }
    }

    public static int[] sortedSquares1(int[] A) {
        int[] res = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        int index = right;
        while(index >= 0) {
            int i = (int)Math.pow(A[left], 2);
            int j = (int)Math.pow(A[right], 2);
            if(i > j) {
                res[index--] = i;
                left++;
            } else {
                res[index--] = j;
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {-3,-3,1,2};
        int[] result = sortedSquares1(array);
        for(int i : result) {
            System.out.println(i);
        }
    }
}
