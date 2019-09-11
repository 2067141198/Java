import java.util.*;

public class findCommonCharacters {
    public List<String> commonChars(String[] A) {
    List<Map<Character, Integer>> list = new ArrayList<>();
    List<String> result = new ArrayList<>();
    for(String s : A) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()) {
            int n = map.getOrDefault(c, 0);
            map.put(c, n + 1);
        }
        list.add(map);
    }

    for(Character c : list.get(0).keySet()) {
        boolean flag = true;
        for(int i = 1; i < list.size(); i++) {
            Set<Character> set = list.get(i).keySet();
            if(!set.contains(c)) {
                flag = false;
                break;
            }
        }
        if(!flag) {
            continue;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list.size(); i++) {
            int n = list.get(i).get(c);
            if(n < min) {
                min = n;
            }
        }

        for(int i = 0; i < min; i++) {
            result.add(String.valueOf(c));
        }
    }
    return result;
}
}
