class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SumOfLeftLeaves {
    static int sum = 0;

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return sum;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(17);
        n1.left = n2;n1.right = n3;n3.left = n4;n3.right = n5;

        int result = sumOfLeftLeaves(n1);
        System.out.println(result);
    }
}
