package Trees;

public class IsMirrorTree {
    //判断两树是否为镜像关系
    public boolean isMirrorTree(TreeNode p, TreeNode q) {
        //当两个树都为空树的时候，两树叶具有镜像关系
        if(p == null && q == null) {
            return true;
        }

        //只要两树不同时为空就表示两树不互为镜像
        if(p == null || q == null) {
            return false;
        }

        //只有根节点相等，且p的左子树与q的右子树相等，以及p的右子树和q的左子树相等的时候才说明两树具有镜像关系
        return p.val == q.val
                && isMirrorTree(p.left, q.right)
                && isMirrorTree(p.right, q.left);
    }
}
