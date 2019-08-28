package OrederTree;

import java.util.Stack;

public class InorderNoR {
    public static void inorderNoR(TreeNode root) {
        if(root == null) {
            return ;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.empty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.pop();
            System.out.println(top.val);
            cur = cur.right;
        }
    }
}
