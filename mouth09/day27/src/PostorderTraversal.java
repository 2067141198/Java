import java.util.*;

public class PostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode front = stack.peek();
            if(front.right != null && front.left != null) {
                stack.push(front.right);
                front.right = null;
                stack.push(front.left);
                front.left = null;
            } else if(front.right != null && front.left == null) {
                stack.push(front.right);
                front.right = null;
            } else if(front.left != null && front.right == null) {
                stack.push(front.left);
                front.left = null;
            } else {
                list.add(stack.pop().val);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;n1.right = n3;n2.right = n4;n3.left = n5;
        List<Integer> list = postorderTraversal(n1);
        System.out.println(list);
    }
}
