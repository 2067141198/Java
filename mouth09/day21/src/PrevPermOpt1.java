public class PrevPermOpt1 {
    public int[] prevPermOpt1(int[] A) {
        int count = A.length - 1;
        boolean flag = true;
        for(int i = A.length - 2; i >= 0; i--) {
            if(A[i] > A[i + 1]) {
                count = i;
                flag = false;
                break;
            }
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int j = count; j < A.length; j++) {
            if(A[j] < A[count] && A[j] > max) {
                max = A[j];
                index = j;
            }
        }
        if(!flag) {
            int tmp = A[count];
            A[count] = A[index];
            A[index] = tmp;
        }
        return A;
    }
}
