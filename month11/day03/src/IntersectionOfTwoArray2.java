import java.util.*;

public class IntersectionOfTwoArray2 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> result = new HashSet<>();
        int index1 = 0;
        int index2 = 0;
        while(index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if(nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                result.add(nums1[index1]);
                index1++;
                index2++;
            }
        }
        int[] array = new int[result.size()];
        int index = 0;
        for(Integer i : result) {
            array[index++] = i;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] result = intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
