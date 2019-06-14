class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        
        //1.复制结点，并将新结点插入到对应的老结点的后面
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            
            node.next = cur.next;
            cur.next = node;
            
            cur = cur.next.next;
        }
        
        // while(cur != null) {
            // Node next = cur.next;
            
            // Node node = new Node(cur.val);
            
            // cur.next = node;
            // node.next = next;
            
            // cur = next;
        // }
        
        //2.复制random
        cur = head;
        while (cur != null) {
            //防止对null 的解引用
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            } else {
                cur.next.random = null;
            }
            cur = cur.next.next;
        }
        //3.分离新老链表
        cur = head;
        Node newHead = cur.next;
        while(cur != null) {
            Node node = cur.next;
            cur.next = node.next;
            if(node.next != null) {
                node.next = node.next.next;
            }
            cur = cur.next;
        }
        return newHead;
    }
}
