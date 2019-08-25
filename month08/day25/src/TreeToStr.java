public class TreeToStr {
    //二叉树创建字符串
    /*你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
    空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。*/
   public static String treeToStr(TreeNode root) {
       //当传入的树为空树的时候，直接返回空字符
       if(root == null) {
           return "";
       }

       StringBuilder sb = new StringBuilder();
       preorder(sb, root);
       //当返回的字符串两端还是具有括号的
       //将sb转换成String类型，然后将首尾去除就达到了该有的结果
       return sb.toString().substring(1, sb.toString().length() - 1);
   }

   public static void preorder(StringBuilder sb, TreeNode root) {
       if(root == null) {
           return ;
       }

       sb.append("(");
       sb.append(root.val);
       //对特殊情况进行处理，当左子树为空右子树不为空的情况下，需要添加字符串（）
       //当右子树为空的时，不做处理
       //左右子树都为空的时候也不做处理
       if(root.left == null && root.right != null) {
           sb.append("()");
       } else {
           preorder(sb, root.left);
       }
       preorder(sb, root.right);
       sb.append(")");
   }
}
