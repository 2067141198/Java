package LinkedList;

public class PrintList {
    public static void printList(Node head) {
        for(Node cur = head; cur != null; cur = cur.next) {
            if(cur.next == null) {
                System.out.println(cur.val);
            } else {
                System.out.print(cur.val + "->");
            }
        }
    }
}
