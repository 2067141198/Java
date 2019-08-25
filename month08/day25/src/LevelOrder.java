import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static List<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        queue.add(root);

        while(queue.peek() != null) {
            TreeNode front = queue.remove();
            list.add(front.val);
            if(front.left != null) {
                queue.add(front.left);
            }
            if(front.right != null) {
                queue.add(front.right);
            }
        }

        return list;
    }
}
