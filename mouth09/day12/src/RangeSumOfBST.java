public class RangeSumOfBST {
    //用递归思想实现，遍历每个结点，比较结点的值是否在[L, R]范围内，在的话使在这个范围内的结点的值相加并返回
    int sum = 0;
    public void rangeSum(TreeNode root, int L, int R) {
        if(root == null) return ;
        if(root.val >= L && root.val <= R) {
            sum += root.val;
        }
        //if(root.val > L)
        rangeSum(root.left, L, R);
        //if(root.val < R)
        rangeSum(root.right, L, R);
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        //sum = 0;
        rangeSum(root, L, R);
        return sum;
    }
}
