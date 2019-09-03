package LinkedList;

public class ReverseList {
    public static Node reverseList(Node head) {
        Node cur = head;
        Node newHead = null;

        while(cur != null) {
            Node next = cur.next;

            cur.next = newHead;
            newHead = cur;

            cur = next;
        }
        return newHead;
    }
}
