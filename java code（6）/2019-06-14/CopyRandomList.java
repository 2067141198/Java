class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }
};

class CopyRandomList {
	public static void display(Node head) {
		for(Node cur = head; cur != null; cur = cur.next) {
			System.out.println("Node(" + cur + "," + cur.val + "," + cur.random + ") -->" );
		}
		System.out.println("null");
	}
	
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
		
		n1.random = n2;
		n2.random = n1;
		n3.random = n3;
		n4.random = null;
		n5.random = n2;
		
		Solution solution = new Solution();
		display(n1);
		Node head = solution.copyRandomList(n1);
		display(head);
		
	}
}










