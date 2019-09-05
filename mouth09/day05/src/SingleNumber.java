import java.util.*;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            int c = map.getOrDefault(i, 0);
            map.put(i, c + 1);
        }

        Set<Integer> set = new HashSet<>();
        set = map.keySet();
        for(int i : set) {
            if(map.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }
}
