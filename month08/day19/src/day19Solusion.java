import java.util.ArrayList;
import java.util.List;

public class day19Solusion {
    public List<List<Integer>> generate(int num) {
        List<List<Integer>> outList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            outList.add(new ArrayList<>());
        }

        //先将杨辉三角前两行都写入1
        outList.get(0).add(1);
        outList.get(1).add(1);
        outList.get(1).add(1);

        //从第三行开始杨辉三角中的数字才开始等于上层紧挨的两个数字之和(除每行第一个及最后一个外)
        for (int i = 2; i < num ; i++) {
            List<Integer> inList = outList.get(i);
            //先把每行的第一个数字更新为1
            inList.add(1);
            //根据循环更新第三行起每个位置的数字
            for(int j = 1; j < i; j++) {
                inList.add(outList.get(i - 1).get(j - 1) + outList.get(i - 1).get(j));
            }
            //先把每行的最后一个数字更新为1
            inList.add(1);
        }

        return outList;
    }

    public static void printPascalsTriangle(day19Solusion s, int num) {
        System.out.println(s.generate(num));
    }

    public static void main(String[] args) {
        day19Solusion s = new day19Solusion();
        s.printPascalsTriangle(s,5);
    }
}
