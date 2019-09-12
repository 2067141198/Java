import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val,List<Node> children) {
        val = val;
        children = children;
    }
};

public class NAryTreePreorderTraversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) {
            return list;
        }
        list.add(root.val);
        for(Node node : root.children) {
            preorder(node);
        }
        return list;
    }
}

