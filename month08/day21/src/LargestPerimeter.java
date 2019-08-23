public class LargestPerimeter {
    public int largestPerimeter(int[] A) {

        int maxLargest = 0;
        int largest = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                for (int z = j + 1; z < A.length; z++) {
                    if(A[i] + A[j] > A[z] && A[i] < A[z] && A[j] < A[z]
                            || A[i] + A[z] > A[j] && A[i] < A[j] && A[z] < A[j]
                            || A[j] + A[z] > A[i] && A[j] < A[i] && A[z] < A[i]) {
                        largest = A[i] + A[j] + A[z];
                    }
                    if(largest > maxLargest)
                        maxLargest = largest;
                }
            }
        }
        return maxLargest;
    }
}
