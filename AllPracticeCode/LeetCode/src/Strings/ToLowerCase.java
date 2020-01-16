package Strings;

public class ToLowerCase {
    public static String toLowerCase(String str) {
        if (str == null || str.length() == 0)
            return str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch <= 'Z' && ch >= 'A')
                ch = (char) (ch - 'A' + 'a');
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = toLowerCase("Hello");
        System.out.println(s);
    }
}
