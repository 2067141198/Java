class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class MergeTwoBinaryTrees {
    //合并两个二叉树
    TreeNode newTreeNode = null;
    public TreeNode merge(TreeNode t1, TreeNode t2) {
        //记录合并后的新树节点的val值
        int newVal = 0;
        //如果两个二叉树的结点都为空时，则直接返回空
        if(t1 == null && t2 == null) {
            return null;
        }
        //新树节点的值分为三种情况，如果其中一个合并前的树的结点为空时，那新结点的val就等于另外一个合并前树的结点val值
        //以上是两种情况
        //当两个树节点都不为空的是后，新结点的val值就是两树结点val值的和
        if(t1 == null) {
            newVal = t2.val;
        } else if(t2 == null) {
            newVal = t1.val;
        } else {
            newVal = t1.val + t2.val;
        }
        //根据新结点的val值创建新结点
        TreeNode newTreeNode =  new TreeNode(newVal);
        //如果此处的两树结点值都不为空，那么递归去分别创建新结点的左右子节点。
        //当其中有一个为空的时候，那么新树结点的左右子节点就是另一个不为空树的左右子结点
        if(t1 != null && t2 !=null) {
            newTreeNode.left = merge(t1.left, t2.left);
            newTreeNode.right = merge(t1.right, t2.right);
        } else if(t1 != null) {
            newTreeNode.left = t1.left;
            newTreeNode.right = t1.right;
        } else {
            newTreeNode.left = t2.left;
            newTreeNode.right = t2.right;
        }
        return newTreeNode;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return merge(t1, t2);
    }

    /*上述可以放在一个类中，无需创建新的类用来递归
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {int newVal = 0;
        if(t1 == null && t2 == null) {
            return null;
        }
        if(t1 == null) {
            newVal = t2.val;
        } else if(t2 == null) {
            newVal = t1.val;
        } else {
            newVal = t1.val + t2.val;
        }
        TreeNode newTreeNode =  new TreeNode(newVal);
        if(t1 != null && t2 !=null) {
            newTreeNode.left = mergeTrees(t1.left, t2.left);
            newTreeNode.right = mergeTrees(t1.right, t2.right);
        } else if(t1 != null) {
            newTreeNode.left = t1.left;
            newTreeNode.right = t1.right;
        } else {
            newTreeNode.left = t2.left;
            newTreeNode.right = t2.right;
        }
        return newTreeNode;
    }*/
}
