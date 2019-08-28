package OrederTree;

import java.util.Stack;

public class PostorderNoR {
    public static void postorderNoR(TreeNode root) {
        if(root == null) {
            return ;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;   //上一次被三次完整经过的节点

        while(!stack.empty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.peek();
            if(top.right == null || top.right == last) {
                stack.pop();
                System.out.println(top.val);
                last = top;
            } else {
                cur = top.right;
            }
        }
    }
}
