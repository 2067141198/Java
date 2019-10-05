class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class GetMinimumDifference {
    public static int getMinimumDifference(TreeNode root) {
        if(root.left == null && root.right == null) {
            return root.val;
        }
        if(root.left != null && root.right == null) {
            return Math.min(getMinimumDifference(root.left), Math.abs(root.val - root.left.val));
        }
        if(root.right != null && root.left == null) {
            return Math.min(getMinimumDifference(root.right), Math.abs(root.val - root.right.val));
        }

        int left = Math.min(getMinimumDifference(root.left), Math.abs(root.val - root.left.val));
        int right = Math.min(getMinimumDifference(root.right), Math.abs(root.val - root.right.val));

        return Math.min(left, right);
    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(236);
        TreeNode n2 = new TreeNode(104);
        TreeNode n3 = new TreeNode(701);
        TreeNode n4 = new TreeNode(227);
        TreeNode n5 = new TreeNode(911);
        n1.left = n2; n1.right = n3;n2.right = n4;n3.right = n5;

        int result = getMinimumDifference(n1);
        System.out.println(result);
    }
}
