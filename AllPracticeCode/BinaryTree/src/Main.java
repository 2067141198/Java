import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        int[] array = {15, 12, 14, 16, 18, 5, 8, 17, 10, 11, 13, 9, 4};
        for (int i : array) {
            bt.insert(i);
        }
        bt.prevOrder(bt.getRoot());
        System.out.println();
        bt.inOrder(bt.getRoot());
        System.out.println();

        BinarySearchTree.Node node = bt.search(10);
        System.out.println(node);

        List<BinarySearchTree.Node> list = bt.searchParents(10);
        list.stream().forEach(System.out::print);
        System.out.println();

        bt.remove(8);
        bt.inOrder(bt.getRoot());
        System.out.println();
    }
}
