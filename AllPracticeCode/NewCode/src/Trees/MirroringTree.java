package Trees;

public class MirroringTree {
    /**
     * 将一个二叉树做镜像处理
     *
     * @param root 被处理二叉树的根节点
     */
    public void Mirror(TreeNode root) {
        if (root == null)
            return;

        TreeNode node = new TreeNode();
        node = root.left;
        root.left = root.right;
        root.right = node;

        Mirror(root.left);
        Mirror(root.right);
    }
}
