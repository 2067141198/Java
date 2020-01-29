package Strings;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map1 = stringToMap(ransomNote);
        Map<Character, Integer> map2 = stringToMap(magazine);

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            char ch = entry.getKey();
            if (!map2.containsKey(ch) || map2.get(ch) < entry.getValue())
                return false;
        }
        return true;
    }

    private static Map<Character, Integer> stringToMap(String string) {
        Map<Character, Integer> map = new HashMap<>();
        char[] ch = string.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int count = map.getOrDefault(ch[i], 0);
            map.put(ch[i], count + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
    }
}
