package LinkedList;

public class TestMain {
    public static void main(String[] args) {
        Node head = BuildLinkedList.buildLinkedList(5);
        PrintList.printList(head);
        Node newHead = ReverseList.reverseList(head);
        PrintList.printList(newHead);
    }
}
