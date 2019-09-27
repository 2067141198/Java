class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if(q == null && p == null) {
            return true;
        }
        if(q.val != p.val) {
            return false;
        }
        return isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }
}
