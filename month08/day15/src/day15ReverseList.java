class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

public class day15ReverseList {
    //逆置链表
    public static Node reverseList(Node head) {
        Node reverse = null;
        if(head == null) {
            return null;
        }

        Node cur = head;
        while(cur != null) {
            //先创建一个新的节点，用来保存原链表中指向的节点的下一个节点
            Node tmp = cur.next;

            //将原链表中指向的节点头插进新链表reverse中
            cur.next = reverse;
            reverse = cur;

            //使节点箭头指向原链表中下一个该指向的节点
            cur = tmp;
        }

        return reverse;
    }

    //定义一个打印链表的方法
    public static void printList(Node head) {
        for(Node cur = head; cur != null; cur = cur.next) {
            if(cur.next == null) {
                System.out.println(cur.value);
            } else {
                System.out.print(cur.value + "-->");
            }
        }
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

        //打印创建好的链表
        printList(n1);
        //将链表逆置
        Node reverse = reverseList(n1);
        //打印逆置后的链表
        printList(reverse);
    }
}
