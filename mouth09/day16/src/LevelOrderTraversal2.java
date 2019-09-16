import java.util.*;

public class LevelOrderTraversal2 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Order(root, 0, list);
        return list;
    }

    public void Order(Node root, int level, List<List<Integer>> list) {
        if(root == null) {
            return;
        }
        if(list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        if(!root.children.isEmpty()) {
            for(Node node : root.children) {
                Order(node, level + 1, list);
            }
        }
    }
}
