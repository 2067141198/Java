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
    //计算链表的长度
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
        if(head == null) {
            System.out.println("该链表为空链表");
            return null;
        }

        //得到整个链表的长度
        int nodeLength = returnNodeLength(head);

       if(k > nodeLength) {
           //正常情况应该抛出异常
           System.out.println("下标访问越界！");
       } else if(k == nodeLength) {
           //考虑特殊情况1：当要删除的结点刚好为第一个结点时
           return head.next;
       } else if(k ==1) {
           //考虑特殊情况2：当被删除的结点刚好的是最后一个结点时
           Node cur = head;
           while(cur.next.next != null) {
               cur = cur.next;
           }

           cur.next = null;
       } else {
           //将倒数第几个结点转化为正数的第几个结点，然后找到要被删除结点的上一个
           //结点，然后使得上一个结点的next指向被删除结点的下一个结点
           int tmp = nodeLength - k - 1;
           Node cur = head;
           while(tmp > 0) {
               cur = cur.next;
               tmp--;
           }
           cur.next = cur.next.next;
       }

        return head;
    }

    public static void main(String[] args) {
        //创建一个链表
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
        Node head = removeKthNode(n1, 7);

        //打印链表，也可以单独写一个方法用来打印链表
        for(Node cur = head; cur != null; cur = cur.next) {
            if(cur.next == null) {
                System.out.println(cur.value);
            } else {
                System.out.print(cur.value + "-->");
            }
        }
    }
}
