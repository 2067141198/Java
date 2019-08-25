import java.util.List;

//通过前序遍历来还原树的结构
//不过该前序遍历中可以体现处空节点
public class PreorderBuildTree {
    /**
     * 创建一个静态内部类，里面有两个属性root 和 used
     * root：表示指向位置的结点
     * used：表示已经用掉了前序遍历表中的多少个元素
     */
     static class NodeAndVal {
        TreeNode root;
        int used;
    }

    public static NodeAndVal preorderBuildTree(List<Integer> preorder) {
         //用来保存根节点处的值
         int rootVal = preorder.get(0);

         //判断传入的是不是空树
         if(preorder.size() == 0) {
             NodeAndVal nav = new NodeAndVal();
             nav.root = null;
             nav.used = 0;
             return nav;
         }

         //判断递归到的是不是空节点
         //此处在前序遍历表中用 # 来表示空节点
         if(rootVal == '#') {
             NodeAndVal nav = new NodeAndVal();
             nav.root = null;
             nav.used = 1;
         }

         //将出了根节点的剩余表全部传入
         NodeAndVal left = preorderBuildTree(preorder.subList(1, preorder.size()));
         //去除掉已经使用过（找到自己本该处于位置）的元素后，将剩下的表传入
         NodeAndVal right = preorderBuildTree(preorder.subList(1 + left.used, preorder.size()));

         TreeNode root = new TreeNode(rootVal);
         root.left = left.root;
         root.right = right.root;

         NodeAndVal nav = new NodeAndVal();
         nav.root = root;
         nav.used = 1 + left.used + right.used;
         return nav;
    }
}
