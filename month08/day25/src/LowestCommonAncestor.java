//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
/*最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示
为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
*/
public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        //如果根节点与需要找祖先结点的任意一个相等时，那么根节点就是那个需要被找的祖先结点，返回即可
        if(root == p || root == q) {
            return root;
        }

        //对 p 结点进行搜索，看是否在左子树上
        boolean pInLeft = search(root.left, p);
        //对 q 结点进行搜索，看是否在左子树上
        boolean qInLeft = search(root.left, q);

        //如果 p 和 q 两个结点都在左子树上，那就以左子树开始继续向下递归，
        if(pInLeft && qInLeft) {
            return lowestCommonAncestor(root.left, p, q);
        }

        //如果 p 和 q 两个结点都不在左子树上，那就以右子树开始继续向下递归，
        if(!pInLeft && !qInLeft) {
            return lowestCommonAncestor(root.right, p, q);
        }

        //如果两个结点分辨位于左子树和右子树，那么祖先结点必然是根节点，返回即可
        return root;
    }

    //查找结点是否存在的方法
    public static boolean search(TreeNode root, TreeNode t) {
        if(root == null) {
            return false;
        }

        if(root == t) {
            return true;
        }

        if(search(root.left, t)) {
            return true;
        }

        return search(root.right, t);
    }
}
