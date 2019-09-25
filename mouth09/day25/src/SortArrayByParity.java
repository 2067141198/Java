public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while(left <= right) {
            //left向后移动的同时得保证left不能超过right，超过的话说明两者之间无元素需要排序直接退出循环
            while(left < right && A[left] % 2 == 0) {
                left++;
            }
            if(left == right) {
                break;
            }
            //同上
            while(right > left && A[right] % 2 == 1) {
                right--;
            }
            if(right == left) {
                break;
            }
            //如果有元素需要交换位置的话进入下一步，交换完后再使左右指针同时移动一步
            swap(A, left, right);
            left++;
            right--;
        }
        return A;
    }
    public void swap(int[] A, int left, int right) {
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
    }
}
