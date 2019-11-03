import java.util.*;

public class IntersectionOfTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = arrayToSet(nums1);
        Set<Integer> set2 = arrayToSet(nums2);
        Map<Integer, Integer> map = new HashMap<>();
        setToMap(map, set1);
        setToMap(map, set2);
        Set<Integer> set = map.keySet();
        List<Integer> result = new ArrayList<>();
        for(Integer i : set) {
            if(map.get(i) == 2)
                result.add(i);
        }
        int[] array = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;

    }
    private Set<Integer> arrayToSet(int[] array) {
        Set<Integer> set = new HashSet<>();
        for(int i : array) {
            set.add(array[i]);
        }
        return set;
    }
    private void setToMap(Map<Integer, Integer> map, Set<Integer> set) {
        for(Integer i : set) {
            int count = map.getOrDefault(i, 0);
            map.put(i, count + 1);
        }
    }
}
