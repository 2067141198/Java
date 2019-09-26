import java.util.Arrays;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {

        if(stones.length == 1) {
            return stones[0];
        }
        //先对数组进行建大堆
        createHeap(stones, stones.length);
        int first = 0;
        int second = 0;

        while(true) {
            int size = stones.length;
            //先取出第一个重量最大的石头，然后对剩下的元素在进行向下调整
            first = stones[0];
            stones[0] = stones[size - 1];
            size --;
            stones = Arrays.copyOf(stones,size);
            heapify(stones, size, 0);

            //先取出第二个重量最大的石头，然后对剩下的元素在进行向下调整
            second = stones[0];
            stones[0] = stones[size - 1];
            size --;
            stones = Arrays.copyOf(stones,size);
            heapify(stones, size, 0);
            //然后对取出重量排前二的石头的重量进行比较，
            //如果相等不做任何处理，但是当石头数组中没有元素时就返回0；
            // 如果不相等将最重的石头质量磨成两个差值的重量，再加入石头数组中重新建大堆
            if(first == second && size == 0) {
                return 0;
            } else if (second != first) {
                second = first - second;
                stones = Arrays.copyOf(stones, size + 1);
                stones[size] = second;
                size++;
                createHeap(stones, size);
            }

            //再进行判断，如果数组中只有一个元素就返回该元素的数值
            if(size == 1) return stones[0];
        }
    }

    //堆的向下调整
    private static void heapify(int[] array, int size, int i) {
        if(size == 1) {
            return;
        }
        while(true) {
            int left = i * 2 + 1;
            if(left >= size) return;
            int max = left;
            if(left + 1 < size && array[left + 1] > array[left]) {
                max = left + 1;
            }
            if(array[i] >= array[max]) return;
            swap(array, i, max);
            i = max;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //建大堆
    public static void createHeap(int[] array, int size) {
        if(size == 1) {
            return;
        }
        int lastNodeIndex = size - 1;
        int lastParentNodeIndex = (lastNodeIndex - 1) / 2;
        for(int i = lastParentNodeIndex; i >= 0; i--) {
            heapify(array, size, i);
        }
    }

    public static void main(String[] args) {
        int[] stones = {3,7,2};
        int i = lastStoneWeight(stones);
        System.out.println(i);
    }
}
