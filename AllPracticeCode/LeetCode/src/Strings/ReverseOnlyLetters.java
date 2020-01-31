package Strings;

public class ReverseOnlyLetters {
    public static String reverseOnlyLetters(String S) {
        char[] ch = S.toCharArray();
        int left = 0;
        int right = ch.length - 1;
        while (left < right) {
            while ((ch[left] > 'z' || ch[left] < 'a' && ch[left] > 'Z' || ch[left] < 'A') && (left < right))
                left++;
            while ((ch[right] > 'z' || ch[right] < 'a' && ch[right] > 'Z' || ch[right] < 'A') && (left < right))
                right--;
            swap(ch, left, right);
            left++;
            right--;
        }
        return new String(ch);
    }

    private static void swap(char[] ch, int left, int right) {
        char tmp = ch[left];
        ch[left] = ch[right];
        ch[right] = tmp;
    }

    public static void main(String[] args) {
        String s = reverseOnlyLetters("7_28]");
        System.out.println(s);
    }
}
