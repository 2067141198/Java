import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class LevelOrderTreversal {
    class Element{
        Node root;
        int level;

        public Element(Node root, int level) {
            this.root = root;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<Element> queue = new LinkedList<>();

        queue.add(new Element(root, 0));
        while(!queue.isEmpty()) {
            Element front = queue.poll();
            if(list.size() == front.level) {
                list.add(new ArrayList<>());
            }
            list.get(front.level).add(front.root.val);
            if(!front.root.children.isEmpty()) {
                for(Node node : front.root.children) {
                    queue.add(new Element(node, front.level + 1));
                }
            }
        }
        return list;
    }
}
