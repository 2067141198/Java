package Trees;

public class IsSameTree {
    //判断两个树是否相等
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //两个都是空树的情况，两个树还是相等的，返回true
        if(p == null && q == null) {
            return true;
        }

        //只有有一个为空树，另一个不是空树的话，表示两树不相等，返回false
        if(p == null || q == null) {
            return false;
        }

        //只有两个树的根节点以及他的左子树和右子树都相等的时候才能说明两树相等，返回true
        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
