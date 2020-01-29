package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class getCountSum {
    public static void DFS(int[] array, int sum, int x, int curSum,
                           List<List<Integer>> res, List<Integer> r) {
        if (curSum >= sum) {
            if (curSum == sum) {
                List<Integer> rs = new ArrayList<>();
                for (int i : r) {
                    rs.add(i);
                }
                res.add(rs);
            }
            return;
        }

        for (int i = x; i < array.length; i++) {
            r.add(array[i]);
            DFS(array, sum, i + 1, curSum + array[i], res, r);
            r.remove(r.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        DFS(array, sum, 0, 0, res, r);
        System.out.println(res.size());
    }
}
