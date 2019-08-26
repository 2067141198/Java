import java.util.List;
import java.util.*;

public class LevelOrder {
    static class Element {
        TreeNode root;
        int level;

        public Element(TreeNode root, int level) {
            this.root = root;
            this.level = level;
        }
    }
    static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return list;
        }
        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(root, 0));

        while(queue.peek() != null) {
            Element front = queue.remove();
            if(list.size() == front.level) {
                list.add(new ArrayList<>());
            }
            list.get(front.level).add(front.root.val);
            if(front.root.left != null) {
                queue.add(new Element(front.root.left, front.level + 1));
            }
            if(front.root.right != null) {
                queue.add(new Element(front.root.right, front.level + 1));
            }
        }
        return list;
    }
}
