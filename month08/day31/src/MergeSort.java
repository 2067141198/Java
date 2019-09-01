public class MergeSort {
    public static void mergeSort(int[] array) {
        mergeSortInternal(array, 0, array.length);
    }

    private static void mergeSortInternal(int[] array, int low, int high) {
        //这里采用的区间是左闭右开的，如果左区间的下标+1大于等于右区间的下标时说明里面没有元素，不需要排序直接返回
        if(low + 1 >= high) {
            return;
        }

        //计算出中间位置的下标，然后用递归继续
        int mid = (high + low ) / 2;
        // [low, mid)
        // [mid, high)
        mergeSortInternal(array, low, mid);
        mergeSortInternal(array, mid, high);
        //将[low, mid) 和 [mid, high) 两个区间内的元素排序
        merge(array,low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        //先计算出两个区间内的元素个数
        int length = high - low;
        //创建一个可以容纳两个区间所有元素的新数组
        int[] extra = new int[length];

        //定义两个变量指向两个区间的其实位置
        int indexLeft = low;
        int indexRight = mid;
        //新数组的最后一个元素的下标位置
        int indexExtra = 0;

        //在两个区间内的元素都没遍历完的时候，比较两个区间内的元素的大小，然后按序放入新的数组中
        while(indexLeft < mid && indexRight < high) {
            if(array[indexLeft] <= array[indexRight]) {
                extra[indexExtra++] = array[indexLeft++];
            } else {
                extra[indexExtra++] = array[indexRight++];
            }
        }

        //当后面的区间没有元素而前面的区间还有元素时，之间将前面区间内剩余的元素按序放入新数组中
        while(indexLeft < mid) {
            extra[indexExtra++] = array[indexLeft++];
        }

        //当前面的区间没有元素而后面的区间还有元素时，之间将后面区间内剩余的元素按序放入新数组中
        while(indexRight < high) {
            extra[indexExtra++] = array[indexRight++];
        }

        //再将有序的数组元素全部复制给开始的数组
        for(int i = 0; i < length; i++) {
            array[low + i] = extra[i];
        }
    }
}
