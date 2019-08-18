package day18List;

public class mainTest {
    public static void test(List list) {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list);
    }
    public static void main(String[] args) {
        List list = new day18LinkdeList();
        test(list);
    }
}
