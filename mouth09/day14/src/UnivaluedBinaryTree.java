
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class UnivaluedBinaryTree {
    public boolean univalTree(TreeNode root, int val) {
        if(root == null) {
            return true;
        }
        if(root.val != val) {
            return false;
        }
        return univalTree(root.left, val) &&
                univalTree(root.right, val);

    }

    public boolean isUnivalTree(TreeNode root) {
        int tmp = root.val;
        return univalTree(root, tmp);
    }
}
