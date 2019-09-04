import java.util.*;

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        Node cur = head;
        Node result = null;
        Node last = null;
        Map<Node , Node> map = new HashMap<>();
        while(cur != null) {
            Node q = new Node();
            q.val = cur.val;
            if(result == null) {
                result = q;
            } else {
                last.next = q;
            }
            last = q;
            map.put(cur, q);
            cur = cur.next;
        }
        Node p = head;
        Node q = result;
        while(p != null) {
            q.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return result;
    }
}
