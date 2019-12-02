package Strings;

import java.util.Scanner;

/**
 * 输入描述：输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，
 * 他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 * <p>
 * 输出描述：对于每一次询问操作，在一行里面输出最高成绩.
 */
public class MaxScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            int m = sc.nextInt();
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }

            sc.nextLine();
            for (int i = 0; i < m; i++) {
                String[] str = sc.nextLine().split(" ");
                String mark = str[0];
                int n1 = Integer.parseInt(str[1]);
                int n2 = Integer.parseInt(str[2]);
                //字符串的比较只能用equals(),不能用等判
                if ("Q".equals(mark)) {
                    int max = 0;
                    if (n1 > n2) {
                        n1 = n1 + n2;
                        n2 = n1 - n2;
                        n1 = n1 - n2;
                    }
                    for (int j = n1; j <= n2; j++) {
                        if (max < array[j - 1])
                            max = array[j - 1];
                    }
                    System.out.println(max);
                } else {
                    array[n1 - 1] = n2;
                }
            }
        }
    }
}
