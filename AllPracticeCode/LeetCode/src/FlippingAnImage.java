public class FlippingAnImage {
    /**
     * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
     *
     * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
     *
     * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
     *
     * @param A 需要翻转和反转的二维数组
     * @return 翻转和反转后的二维数组
     */
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++) {
            int left = 0;
            int right = A[i].length - 1;
            while(left <= right) {
                int tmp = A[i][left];
                A[i][left] = A[i][right];
                A[i][right] = tmp;

                left++;
                right--;
            }

            for(int j = 0; j < A[i].length; j++) {
                if(A[i][j] == 0)
                    A[i][j] = 1;
                else
                    A[i][j] = 0;
            }
        }
        return A;
    }

    public int[][] flipAndInvertImage1(int[][] A) {
        for(int i = 0; i < A.length; i++) {
            int left = 0;
            int right = A[i].length - 1;
            while(left <= right) {
                reverse(A, i, left, right);
                if(left != right) {
                    flip(A, i, left);
                    flip(A, i, right);
                } else {
                    flip(A, i, left);
                }

                left++;
                right--;
            }
            // for(int j = 0; j < A[i].length; j++) {
            //     if(A[i][j] == 0)
            //         A[i][j] = 1;
            //     else
            //         A[i][j] = 0;
            // }

        }
        return A;
    }

    public void reverse(int[][] A, int i, int left, int right) {
        int tmp = A[i][left];
        A[i][left] = A[i][right];
        A[i][right] = tmp;
    }

    public void flip(int[][] A, int i, int j) {
        if(A[i][j] == 0)
            A[i][j] = 1;
        else
            A[i][j] = 0;
    }
}
