package OrederTree;

import java.util.Stack;

public class PreorderNoR {
    public static void preorderNorR(TreeNode root) {
        if(root == null) {
            return ;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //如果栈不为空则需要遍历，开始时stack为null，所以还有一个条件是该树不是空树
        while(!stack.empty() || cur != null) {
            if (cur != null) {
                //从根节点开始由于是前序遍历所以遇到结点就先打印出来
                System.out.println(cur.val);
                //然后将结点添加入栈
                stack.push(cur);
                //使得 cur 变为他的左子树继续遍历
                cur = cur.left;
            }
            //将左子树遍历完后就需要遍历他的右子树，所以将栈最后进入的结点取出，
            // 使 cur 等于他娘的右子树继续遍历
            TreeNode top = stack.pop();
            cur = top.right;
        }
    }
}
