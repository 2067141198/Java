import java.util.Arrays;

/**
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
 */
public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int count = 0;
        int[] newHeights = Arrays.copyOf(heights, heights.length);
        Arrays.sort(newHeights);
        for(int i = 0; i < heights.length; i++) {
            if(newHeights[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1,2,1,2,1,1,1,2,1};
        System.out.println(heightChecker(heights));
    }
}
