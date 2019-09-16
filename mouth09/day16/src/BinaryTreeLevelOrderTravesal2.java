import java.util.*;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class BinaryTreeLevelOrderTravesal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Order(root, 0, list);
        List<List<Integer>> newList = reverse(list);
        return newList;
    }
    public void Order(TreeNode node, int level, List<List<Integer>> list) {
        if(node == null) {
            return;
        }
        if(list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        if(node.left != null) {
            Order(node.left, level + 1, list);
        }
        if(node.right != null) {
            Order(node.right, level + 1, list);
        }
    }
    public List<List<Integer>> reverse(List<List<Integer>> list) {
        List<List<Integer>> newList = new ArrayList<>();
        for(int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
        }
        return newList;
    }
}
