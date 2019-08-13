class Node {
    int value;
    Node next;

    public Node() {

    }

    public Node(int value) {
        this.value = value;
    }
}

public class day13RemoveKthNode {
    public static int returnNodeLength(Node head) {
        int count = 0;      //用来计数链表长度

        Node cur = head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }

        return count;
    }

    public static Node removeKthNode(Node head, int k) {
        int nodeLength = returnNodeLength(head);

        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        //int i = returnNodeLength(n1);
        System.out.println(returnNodeLength(n1));
    }
}
