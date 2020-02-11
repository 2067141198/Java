package BinaryTree;

import java.util.Scanner;
import java.util.Stack;

public class BuildTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<TreeNode> stack = new Stack();

        if (s == null || "#".equals(s) || s.length() == 0) {
            System.out.println();
        }

        TreeNode root = new TreeNode(String.valueOf(s.charAt(0)));
        stack.push(root);

        for (int i = 1; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            TreeNode pre = stack.peek();
            if ("#".equals(pre.val)) {
                stack.pop();
                TreeNode leaf = stack.pop();
                if ("#".equals(str)) {
                    leaf.right = null;
                    stack.push(new TreeNode("#"));
                } else {
                    TreeNode cur = new TreeNode(str);
                    leaf.right = cur;
                    stack.push(cur);
                }
            } else {
                if ("#".equals(str)) {
                    pre.left = null;
                    stack.push(new TreeNode("#"));
                } else {
                    TreeNode cur = new TreeNode(str);
                    pre.left = cur;
                    stack.push(cur);
                }
            }
        }
        inOrder(root);
    }

    public static void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    static class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;

        TreeNode(String s) {
            this.val = s;
        }
    }
}
