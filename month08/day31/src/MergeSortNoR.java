public class MergeSortNoR {
    public static void mergeSortNoR(int[] array) {
        for(int i = 1; i < array.length; i *= 2) {
            for(int j = 0; j < array.length; j += 2 * i) {
                int left = j;
                int mid = j + i;
                int right = j + 2 * i;
                if(mid > array.length) {
                    continue;
                }
                if(right > array.length) {
                    right = array.length;
                }
                if(mid < array.length && array[mid - 1] <= array[mid]) {
                    continue;
                }
                meger(array, left, mid, right);
            }
        }
    }

    private static void meger(int[] array, int left, int mid, int right) {
        int length = right - left;
        int[] extra = new int[length];

        int indexLeft = left;
        int indexRight = mid;
        int indexExtra = 0;

        while(indexLeft < mid && indexRight < right) {
            if(array[indexLeft] <= array[indexRight]) {
                extra[indexExtra++] = array[indexLeft++];
            } else {
                extra[indexExtra++] = array[indexRight++];
            }
        }

        while(indexLeft < mid) {
            extra[indexExtra++] = array[indexLeft++];
        }

        while(indexRight < right) {
            extra[indexExtra++] = array[indexRight++];
        }

        for (int i = 0; i < length; i++) {
            array[left + i] = extra[i];
        }
    }
}
