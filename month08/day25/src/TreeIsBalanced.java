public class TreeIsBalanced {
    //判断一个数是否是平衡树
    /*本题中，一棵高度平衡二叉树定义为：
    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。*/
    public static boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        //判断条件，只有左子树和右子树都是平衡树的时候，
        // 且左右子树的深度差值的绝对值小于1才能说明这个树是平衡树
        return isBalanced(root.left)
                && isBalanced(root.right)
                && Math.abs(treeHeight(root.left) - treeHeight(root.right)) <= 1;
    }

    //用来计算输的深度
    public static int treeHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = treeHeight(root.left);
        int right = treeHeight(root.right);

        return Math.max(left, right) + 1;
    }
}
