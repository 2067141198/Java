class Node {
    int val;
    Node next;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}

public class day17DivisionList {
    public static Node divisionList(Node head, int k) {
        if(head == null) {
            return null;
        }

        Node cur = head;
        Node smallList = null;
        Node bigList = null;
        Node sLast = null;
        Node bLast = null;

        while(cur != null) {
            if(cur.val < k) {
                if(smallList == null) {
                    smallList = cur;
                } else {
                    sLast.next = cur;
                }

                sLast = cur;
            } else {
                if(bigList == null) {
                    bigList = cur;
                } else {
                    bLast.next = cur;
                }

                bLast = cur;
            }

            cur = cur.next;
        }

        if(smallList == null) {
            return bigList;
        } else {
            sLast.next = bigList;
        }
        //得保证bigList 指向 null;
        if(bigList != null)
            bLast.next = null;

        return smallList;

    }

    public static void printList(Node head) {
        for(Node cur = head; cur != null; cur = cur.next) {
            System.out.println(cur);
        }
    }

    public static Node createList() {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        Node n4 = new Node(7);
        Node n5 = new Node(9);
        Node n6 = new Node(2);
        Node n7 = new Node(4);
        Node n8 = new Node(6);
        Node n9 = new Node(8);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = null;

        return n1;
    }
    public static void main(String[] args) {
        Node head = createList();
        Node newHead = divisionList(head, 5);
        printList(newHead);
    }
}
