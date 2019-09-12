import java.util.*;

public class SearchBST {
    /**
     * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到
     * 节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
     */
    //递归写法
    TreeNode newNode = null;
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            newNode = root;
        }

        searchBST(root.left, val);
        searchBST(root.right, val);
        return newNode;
    }

    //非递归写法
    public TreeNode searchBST2(TreeNode root, int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if(front.val == val) {
                return front;
            }
            if(front.left != null) {
                queue.add(front.left);
            }
            if(front.right != null) {
                queue.add(front.right);
            }
        }
        return null;
    }

    public TreeNode searchBST3(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        while(root != null) {
            if(root.val == val) {
                return root;
            } else if(val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
