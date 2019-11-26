import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDome {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("cccc");
        list.add("tt");
        list.add("bbb");
        list.add("a");

        System.out.println("排序前" + list);

        Collections.sort(list, getComparator());

        System.out.println("排序后" + list);
    }

    public static Comparator<String> getComparator() {
//        return new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                if(s1.length() != s2.length())
//                    return s1.length() - s2.length();
//                else
//                    return s1.compareTo(s2);
//            }
//        };

        return (s1, s2) -> s1.length() - s2.length();
    }
}
