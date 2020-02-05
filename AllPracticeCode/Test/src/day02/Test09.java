package day02;

/**
 * 求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本
 * 身，如；153＝1＋5＋3?，则153是一个“水仙花数”。)
 */
public class Test09 {
    public static void main(String[] args) {
        for (int i = 0; i < 999; i++) {
            int count = i;
            int sum = 0;
            while (count > 0) {
                sum += Math.pow(count % 10, 3);
                count /= 10;
            }
            if (i == sum)
                System.out.println(i);
        }
    }
}
