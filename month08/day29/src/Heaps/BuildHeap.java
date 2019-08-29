package Heaps;

public class BuildHeap {
    public static void buildHeapMax(int[] array,int size) {
        for(int i = (size - 2) / 2; i >= 0; i--){
            heapifyMax(array, size, i);
        }
    }

    //向下调整，将大的值调整下去
    private static void heapifyMax(int[] array, int size, int index) {
        while(true) {
            //先计算出需要调整结点的左子树的各节点在数组中的下标
            int left = index * 2 + 1;
            //如果左子树的根节点都不在需要调整的区间内的话，直接返回
            if (left >= size) {
                return;
            }
            //比较左右子树根点的大小，得到值最大的根节点在数组中的下标
            int max = left;
            if (left + 1 < size && array[left + 1] > array[left]) {
                max = left + 1;
            }
            //如果需要调整的结点的值比左右子树根节点的值都要大的话，不做调整直接返回
            if(array[index] >= array[max]) {
                return ;
            }
            //将需要调整的结点和两子树结点的值互换
            swap(array, index, max);
            //将需要调整的结点下标更新，继续循环调整
            index = max;
        }
    }

    public static void buildHeapMin(int[] array, int size) {
        for(int i = (size - 2) / 2; i >=0; i--) {
            heapifyMin(array, size, i);
        }
    }

    //向下调整，将小的值调整下去
    private static void heapifyMin(int[] array, int size, int index) {
        while(true) {
            int left = index * 2 + 1;
            if (left >= size) {
                return;
            }
            int min = left;
            if (left + 1 < size && array[left + 1] < array[left]) {
                min = left + 1;
            }
            if (array[index] < array[min]) {
                return;
            }
            swap(array, index, min);
            index = min;
        }
    }

    //向上调整，从最后一个元素开始
    public static void adjustUp(int[] array, int index) {
        while(index > 0) {
            int parent = (index - 1) / 2;
            if (array[parent] <= array[index]) {
                return;
            }
            swap(array, parent, index);
            index = parent;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

