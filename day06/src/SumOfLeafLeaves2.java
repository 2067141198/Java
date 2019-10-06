public class SumOfLeafLeaves2 {
    public static int sumOfLeftLeaves2(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null)
            return sumOfLeftLeaves2(root.right);
        if(root.left.left == null && root.left.right == null)
            return sumOfLeftLeaves2(root.right) + root.left.val;
        return sumOfLeftLeaves2(root.left) + sumOfLeftLeaves2(root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(17);
        n1.left = n2;n1.right = n3;n3.left = n4;n3.right = n5;

        int result = sumOfLeftLeaves2(n1);
        System.out.println(result);
    }
}
