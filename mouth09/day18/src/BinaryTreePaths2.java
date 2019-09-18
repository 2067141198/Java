import java.util.*;

public class BinaryTreePaths2 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        if(root == null) return list;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();

        nodeQueue.add(root);
        pathQueue.add(Integer.toString(root.val));

        TreeNode node;
        String path;
        while(!nodeQueue.isEmpty()) {
            node = nodeQueue.poll();
            path = pathQueue.poll();
            if(node.left == null && node.right == null) {
                list.add(path);
            }
            if(node.left != null) {
                nodeQueue.add(node.left);
                pathQueue.add(path + "->" + Integer.toString(node.left.val));
            }
            if(node.right != null) {
                nodeQueue.add(node.right);
                pathQueue.add(path + "->" + Integer.toString(node.right.val));
            }
        }
        return list;
    }
}
