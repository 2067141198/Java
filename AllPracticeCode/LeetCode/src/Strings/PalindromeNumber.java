package Strings;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        char[] ch = String.valueOf(x).toCharArray();
        int left = 0;
        int right = ch.length - 1;
        while (left < right) {
            if (!(ch[left] == ch[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
