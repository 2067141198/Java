public class MaximumDepthOfBinaryTree {
    //用递归思想算出左右子树中的最大深度，然后加上根节点那一层即为树的深度
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHigh = maxDepth(root.left);
        int rightHigh = maxDepth(root.right);

        return Math.max(leftHigh, rightHigh) + 1;
    }
}

