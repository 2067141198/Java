package Trees;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Arrays;
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

    //根据中序遍历和后序遍历来还原树的结构
    public static TreeNode buildTree2(List<Integer> inorder, List<Integer> postorder) {

        if(inorder.size() == 0) {
            return null;
        }
        //获取根节点的数值
        int rootValue = postorder.get(postorder.size() - 1);
        //获取左子树的元素个数
        int leftCount = inorder.indexOf(rootValue);
        //创建根节点
        TreeNode root = new TreeNode(rootValue);

        //根据List中的subList方法将左子树的中序和后序得到
        List<Integer> leftInorder = inorder.subList(0, leftCount);
        List<Integer> leftPostorder = postorder.subList(0, leftCount);
        //然后再根据右子树的中序和后序去还原左子树的结构
        TreeNode left = buildTree2(leftInorder, leftPostorder);
        root.left = left;

        //根据List中的subList方法将右子树的中序和后序得到
        List<Integer> rightInorder = inorder.subList(leftCount + 1, inorder.size());
        List<Integer> rightPostorder = postorder.subList(leftCount, postorder.size() - 1);
        //然后再根据右子树的中序和后序去还原右子树的结构
        TreeNode right = buildTree2(rightInorder, rightPostorder);
        root.right = right;

        return root;
    }

    public static void main(String[] args) {
        List<Integer> preorder = Arrays.asList(1, 2, 4, 5, 8, 3, 6, 7);
        List<Integer> inorder = Arrays.asList(4 ,2 ,5 ,8 ,1, 6, 3, 7);
        List<Integer> postorder = Arrays.asList(4 ,8 ,5 ,2 ,6 ,7 ,3 ,1);

        TreeNode root1 = buildTree1(preorder, inorder);
        System.out.println(root1);
        System.out.println("===========================");
        TreeNode root2 = buildTree2(inorder, postorder);
        System.out.println(root2);

    }
}
