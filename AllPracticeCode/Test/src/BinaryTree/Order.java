package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Order {
    public static void preOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root == null)
            return;
        preOrder(root.left);
        System.out.println(root.val);
        preOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null)
            return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.val);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return result;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null)
                    list.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }
}
