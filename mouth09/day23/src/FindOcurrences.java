import java.util.*;

public class FindOcurrences {
    public static String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] str = text.split(" ");
        for(int i = 0; i < str.length - 2; i++) {
            String s1 = str[i];
            String s2 = str[i + 1];
            if(s1.equals(first) && s2.equals(second))
                list.add(str[i + 2]);
        }
        String[] result = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        String text = "alice is a good girl she is a good student";
        String[] s = findOcurrences(text, "a", "good");
        for(String str : s) {
            System.out.println(str);
        }
    }
}
