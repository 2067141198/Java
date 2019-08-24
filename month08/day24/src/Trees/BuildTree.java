package Trees;

import java.util.List;

public class BuildTree {
    //根据前序遍历和中序遍历来还原树的结构
    public static TreeNode buildTree1(List<Integer> preorder, List<Integer> inorder) {
        if(preorder.size() == 0) {
            return null;
        }
        //根节点的数值
        int rootValue = preorder.get(0);
        //左子树包含元素的数量，根据中序遍历得到，由根节点的数值在中序中的位置可得出
        int leftCount = inorder.indexOf(rootValue);
        //创建根节点
        TreeNode root = new TreeNode(rootValue);

        //根据List中的subList方法将左子树的前序和中序得到
        List<Integer> leftPreorder = preorder.subList(1, 1 + leftCount);
        List<Integer> leftInorder = inorder.subList(0, leftCount);
        //然后再根据左子树的前序和中序去还原左子树的结构
        TreeNode left = buildTree1(leftPreorder, leftInorder);
        root.left = left;

        //根据List中的subList方法将右子树的前序和中序得到
        List<Integer> rightPreorder = preorder.subList(1 + leftCount, preorder.size());
        List<Integer> rightInorder = inorder.subList(leftCount + 1, inorder.size());
        //然后再根据右子树的前序和中序去还原右子树的结构
        TreeNode right = buildTree1(rightPreorder, rightInorder);
        root.right = right;

        return root;
    }
}
