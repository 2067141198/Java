package day18List;

public class mainTest {
    //使用迭代器对线性表进行打印
    public static void printList(List list) {
        Iterator iterator = list.iterator();

        System.out.print("[");
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("]");
    }

    public static void test(List list) {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        printList(list);
        list.remove(2);
        list.remove(2);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        printList(list);

    }
    public static void main(String[] args) {
        List list = new day18LinkdeList();
        test(list);
    }
}
