class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);
        n1.left = n2; n1.right = n3; n2.left = n4; n2.right = n5; n3.left = n6; n3.right = n7;

        System.out.println(isSymmetric(n1));
    }
}
