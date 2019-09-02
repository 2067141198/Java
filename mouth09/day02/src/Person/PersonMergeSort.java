package Person;

public class PersonMergeSort {
    public static void mergeSort(Person[] array, PersonRankWithComparator comparator) {
        mergeSortInternal(array, 0, array.length, comparator);
    }

    private static void mergeSortInternal(Person[] array, int less, int high, PersonRankWithComparator comparator) {
        if(less + 1 >= high) {
            return;
        }
        int mid = (high + less) / 2;
        mergeSortInternal(array, less, mid, comparator);
        mergeSortInternal(array, mid, high, comparator);

        merge(array, less, mid, high, comparator);
    }

    private static void merge(Person[] array, int less, int mid, int high, PersonRankWithComparator comparator) {
        int length = high - less;
        Person[] extra = new Person[length];

        int leftIndex = less;
        int rightIndex = mid;
        int extraIndex= 0;

        while(leftIndex < mid && rightIndex < high) {
            int r = comparator.compare(array[leftIndex], array[rightIndex]);
            if(r <= 0) {
                extra[extraIndex++] = array[leftIndex++];
            } else {
                extra[extraIndex++] = array[rightIndex++];
            }
        }

        while(leftIndex < mid) {
            extra[extraIndex++] = array[leftIndex++];
        }
        while(rightIndex < high) {
            extra[extraIndex++] = array[rightIndex++];
        }
        for (int i = 0; i < length; i++) {
            array[less + i] = extra[i];
        }
    }
}
