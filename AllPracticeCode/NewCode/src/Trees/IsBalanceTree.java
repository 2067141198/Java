package Trees;

public class IsBalanceTree {
    public boolean isBalance(TreeNode root) {
        // write code here
        if (root == null)
            return true;

        return isBalance(root.left) && isBalance(root.right) && Math.abs(length(root.left) - length(root.right)) <= 1;
    }

    private int length(TreeNode root) {
        if (root == null)
            return 0;
        int left = 1 + length(root.left);
        int right = 1 + length(root.right);
        return left > right ? left : right;
    }
}
