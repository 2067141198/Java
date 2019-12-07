package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。
 */
public class LevelOrderTree {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null)
            return new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> outList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> inList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                inList.add(node.val);
                for (Node n : node.children) {
                    queue.add(n);
                }
            }
            outList.add(inList);
        }
        return outList;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
