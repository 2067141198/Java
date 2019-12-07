package DFS;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private static void DFS(int[] candidates, int target, int curSum, List<List<Integer>> results, List<Integer> res, int prve) {
        if (curSum >= target) {
            if (curSum == target) {
                List<Integer> list = new ArrayList<>();
                for (int i : res)
                    list.add(i);
                results.add(list);
            }
            return;
        }

        for (int i = prve; i < candidates.length; i++) {
            int n = candidates[i];
            res.add(n);
            DFS(candidates, target, curSum + n, results, res, i);
            res.remove(res.size() - 1);
        }

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int curSum = 0;
        DFS(candidates, target, curSum, results, res, 0);
        return results;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 6, 7};
        List<List<Integer>> results = combinationSum(array, 7);
    }
}
