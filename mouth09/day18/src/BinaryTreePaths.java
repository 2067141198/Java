import java.util.*;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        path(root, "", list);
        return list;
    }

    public void path(TreeNode root, String s, List list) {
        if(root == null) {
            return;
        }
        s += Integer.toString(root.val);
        if(root.left == null && root.right == null) {
            list.add(s);
        }
        s += "->";
        path(root.left, s, list);
        path(root.right, s, list);
    }
}
