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

public class day16AbsoptionList {
    public static Node merge(Node head1, Node head2) {
        if(head1 == null) {
            return head2;
        }

        if(head2 == null) {
            return head1;
        }

        Node mergeHead = null;

        Node cur1 = head1;
        Node cur2 = head2;

        Node last = null;

        while(cur1 != null && cur2 != null) {
            if(cur1.val <= cur2.val) {
                if(mergeHead == null) {
                    mergeHead = cur1;
                } else {
                    last.next = cur1;
                }

                last = cur1;

                cur1 = cur1.next;
            } else {
                if(mergeHead == null) {
                    mergeHead = cur2;
                } else {
                    last.next = cur2;
                }

                last = cur2;

                cur2 = cur2.next;
            }
        }

        if(cur1 == null) {
            last.next = cur2;
        } else {
            last.next = cur1;
        }


        return mergeHead;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        Node n4 = new Node(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        Node n5 = new Node(2);
        Node n6 = new Node(4);
        Node n7 = new Node(6);
        Node n8 = new Node(8);

        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = null;

        Node rhead = merge(n1,n5);

        for(Node cur = rhead; cur != null; cur = cur.next) {
            System.out.println(cur);
        }
    }
}
