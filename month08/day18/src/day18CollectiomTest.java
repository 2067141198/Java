import java.util.*;

public class day18CollectiomTest {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<> ();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(Arrays.toString(list.toArray()));
        list.add("今天");
        list.add("的");
        list.add("日期");
        list.add("是");
        list.add("?");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(Arrays.toString(list.toArray()));
        list.remove("?");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(Arrays.toString(list.toArray()));
        list.remove("今天");
        list.remove("的");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(Arrays.toString(list.toArray()));
        list.clear();
        System.out.println(Arrays.toString(list.toArray()));

    }
}
