import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int num) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            List<Integer> inList = new ArrayList<>();
            inList.add(1);
            for (int j = 0; j <= i - 2; j++) {
                inList.add(list.get(i - 1).get(j) + list.get(i - 1).get(j + 1));
            }
            if(i != 0) {
                inList.add(1);
            }

            list.add(inList);
        }
        return list;
    }

    public static void printPascalsTriangle(PascalsTriangle s, int num) {
        System.out.println(s.generate(num));
    }

    public static void main(String[] args) {
        PascalsTriangle p = new PascalsTriangle();
        printPascalsTriangle(p, 5);
    }
}
