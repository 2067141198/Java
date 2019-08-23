package Trees;

public class Trees {
    public static Node buildTree() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n1.left = n2;  n1.right = n3;
        n2.left = n4;  n2.right = n5;
        n3.left = n6;  n3.right = n7;
        n4.left = null;  n4.right = null;
        n5.left = null;  n5.right = n8;
        n6.left = null;  n6.right = null;
        n7.left = null;  n7.right = null;
        n8.left = null;  n8.right = null;

        return n1;
    }
    public static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    public static void posOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        posOrderTraversal(root.left);
        posOrderTraversal(root.right);
        System.out.println(root.value);
    }

    public static void main(String[] args) {
        Node root = buildTree();
        preOrderTraversal(root);
        System.out.println("=====");
        inOrderTraversal(root);
        System.out.println("=====");
        posOrderTraversal(root);
    }
}
