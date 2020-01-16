package Strings;

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 1, nums.length - 1);
        }
    }

    public static void reverse(int[] nums, int x, int y) {
        while (x < y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
            x++;
            y--;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        rotate(array, 3);
        System.out.println(Arrays.toString(array));
    }
}
