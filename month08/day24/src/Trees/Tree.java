package Trees;

class Tree {
    //创建一个树
    public static TreeNode buildTree() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

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

    //用来表示数的结点个数
    public static int count;
    //计算树的结点个数
    //用了遍历的思想
    public static void calcLeafCount(TreeNode root) {
        if(root == null) {
            return;
        }
        count++;
        calcLeafCount(root.left);
        calcLeafCount(root.right);
    }

    //用来记录树第 k 层的结点个数
    static int kLevelCount;
    //计算树第k层的所有结点个数
    //用了汇总的思想，分别计算左子树和右子树的 k-1 层结点的个数相加 便是该树第 k 层的结点个数
    public static int calcKLevel(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        int leftCount = calcKLevel(root.left, k - 1);
        int rightCount = calcKLevel(root.right, k - 1);
        kLevelCount = leftCount + rightCount;

        return kLevelCount;
    }

    //用来记录树的高度值
    static int treeHeight;
    //计算树的高度/深度
    //用到了汇总的思想，分别的得出左右子树的深度，比较两者取最大值然后加上根的那一层就是树的深度
    public static int treeHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        treeHeight = Math.max(left, right) + 1;

        return treeHeight;
    }

    //在树中查找是否含有 val 元素，存在的话返回该值对应的结点
    public static TreeNode search(TreeNode root, int val) {
        if(root == null) {
            return null;
        }

        //找了找root的val与需要查找的val值相等，返回结点root
        if(root.val == val) {
            return root;
        }

        TreeNode left = search(root.left, val);
        //只要找到的话，left的val必定与需要找的val相等
        //所以只要判断left != null 便可知有没有找到
        if(left != null) {
            return left;
        }

        TreeNode right = search(root.right,val);
        //同上
        if(right != null) {
            return right;
        }

        //如果将树或者其子树的结点都找遍了，那么才能走到这标书找不到返回 null
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
        calcLeafCount(root);
        System.out.println("该数的总结点个数为：" + count);
        System.out.println("===============================");
        int k = 4;
        System.out.println("该树的第" + k + "层的结点个数为：" + calcKLevel(root,k));
        System.out.println("===============================");
        System.out.println("树的深度/高度为" + treeHeight(root));
        System.out.println("===============================");
        System.out.println(search(root, 4));
        System.out.println(search(root, 9));
    }
}
