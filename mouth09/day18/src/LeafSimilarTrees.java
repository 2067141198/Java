import java.util.*;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //比较所有的叶子结点是否相同只能比较叶子结点的值是否相同，所以list的泛型类只能为Integer而不能是TreeNode
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        leaf(root1, list1);
        leaf(root2, list2);
        return list1.equals(list2);
    }
    public void leaf(TreeNode root, List list) {
        if(root == null) {
            return;
        }
        if(root.left ==null && root.right == null) {
            list.add(root.val);
        }
        leaf(root.left, list);
        leaf(root.right, list);
    }
}
