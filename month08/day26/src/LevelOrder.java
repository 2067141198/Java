import java.util.List;
import java.util.*;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {
    //定义一个内部类，使其具有两个属性，一个表示树的结点，一个表示到达的层数
    static class Element {
        TreeNode root;
        int level;

        public Element(TreeNode root, int level) {
            this.root = root;
            this.level = level;
        }
    }
    static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return list;
        }
        Queue<Element> queue = new LinkedList<>();
        //将包含头结点的自定义类的对象添加入队列
        queue.add(new Element(root, 0));

        while(queue.peek() != null) {
            //取出队列中的第一个元素
            Element front = queue.remove();
            //当list的元素个数等于遍历到达的层数时说明list中没有对象，需要添加一个新的ArrayList对象
            if(list.size() == front.level) {
                list.add(new ArrayList<>());
            }
            list.get(front.level).add(front.root.val);
            if(front.root.left != null) {
                queue.add(new Element(front.root.left, front.level + 1));
            }
            if(front.root.right != null) {
                queue.add(new Element(front.root.right, front.level + 1));
            }
        }
        return list;
    }
}
