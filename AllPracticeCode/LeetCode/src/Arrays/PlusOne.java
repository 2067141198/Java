package Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int length = digits.length - 1;
        digits[length] += 1;
        reverse(digits);
        int carry = 0;
        for (int i = 0; i < digits.length; i++) {
            digits[i] += carry;
            if (digits[i] > 9) {
                digits[i] = 0;
                carry = 1;
            } else {
                carry = 0;
            }
        }
        if (carry == 0) {
            reverse(digits);
            return digits;
        }
        int[] array = new int[digits.length + 1];
        array[0] = carry;
        for (int i = 1; i < array.length; i++) {
            array[i] = digits[digits.length - i];
        }
        return array;
    }

    private static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] digits = {9};
        int[] array = plusOne(digits);
    }
}
