import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private Node root;

    Node getRoot() {
        return root;
    }

    void insert(int val) {
        Node node = new Node(val);
        if (root == null) {
            root = node;
            return;
        }

        Node cur = root;
        Node parent = null;

        while (cur != null) {
            parent = cur;
            if (cur.val > val)
                cur = cur.left;
            else if (cur.val < val)
                cur = cur.right;
            else
                throw new RuntimeException("插入失败，结点重复");
        }
        if (parent.val > val)
            parent.left = node;
        else
            parent.right = node;
    }

    Node search(int val) {
        Node cur = root;
        while (cur != null) {
            if (cur.val == val)
                return cur;
            else if (cur.val > val)
                cur = cur.left;
            else
                cur = cur.right;
        }
        return null;
    }

    public List<Node> searchParents(int val) {
        List<Node> list = new ArrayList<>();
        Node cur = root;
        Node parent;
        while (cur != null) {
            parent = cur;
            if (cur.val == val) {
                list.add(cur);
                break;
            } else if (cur.val > val)
                cur = cur.left;
            else
                cur = cur.right;
            list.add(parent);
        }
        if (list.size() == 0)
            return null;
        else
            return list;
    }

    boolean remove(int val) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (cur.val == val) {
                removeNode(parent, cur);
                return true;
            } else if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else {
                parent = cur;
                cur = cur.left;
            }
        }
        return false;
    }

    private void removeNode(Node parent, Node cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root)
                root = cur.left;
            else if (cur == parent.left)
                parent.left = cur.left;
            else
                parent.right = cur.left;
        } else {
            Node p = cur;
            Node c = cur.right;
            while (c.left != null) {
                p = c;
                c = c.left;
            }
            cur.val = c.val;

            if (c == p.left)
                p.left = c.right;
            else
                p.right = c.right;
        }
    }

    void prevOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        prevOrder(root.left);
        prevOrder(root.right);
    }

    void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
}
