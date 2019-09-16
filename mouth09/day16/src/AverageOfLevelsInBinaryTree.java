import java.util.*;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Order(root, 0, list);
        for(List<Integer> l : list) {
            long sum = 0;
            for(int i = 0; i < l.size(); i++) {
                sum += l.get(i);
            }
            result.add((double)sum / l.size());
        }
        return result;
    }

    public void Order(TreeNode root, int level, List<List<Integer>> list) {
        if(root == null) {
            return;
        }
        if(list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        if(root.left != null) {
            Order(root.left, level + 1, list);
        }
        if(root.right != null) {
            Order(root.right, level + 1, list);
        }
    }
}
