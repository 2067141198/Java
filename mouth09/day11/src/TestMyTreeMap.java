import java.util.*;

public class TestMyTreeMap {
    public static void main(String[] args) {
        MyTreeMap<Integer, Integer> map = new MyTreeMap<>(new MyComparator());
        int[] keys = {6, 7, 4, 2, 1, 5, 9, 3, 8};
        for(int key : keys) {
            map.put(key, key * 10);
        }
        for(int key : keys) {
            System.out.println(key + ":" + map.get(key));
        }
        System.out.println(map.get(13));
        System.out.println(map.getOrDefault(13, 113));
        System.out.println(map.get(13));
        System.out.println(map.keySet());
        System.out.println(map.entrySet());
        System.out.println(map.containsKey(1));
        System.out.println(map.containsKey(13));
        System.out.println(map.containsValue(10));
        System.out.println(map.containsValue(130));
        System.out.println("========================");
        Set<MyTreeMap.Entry<Integer, Integer>> set = map.entrySet();
        for(MyTreeMap.Entry<Integer, Integer> e : set) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }
    }
}
