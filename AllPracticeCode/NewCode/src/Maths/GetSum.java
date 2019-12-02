package Maths;

import java.util.Scanner;

/**
 * 小易经常沉迷于网络游戏.有一次,他在玩一个打怪升级的游戏,他的角色的初始能力值为 a.在接下来的一段时间内,
 * 他将会依次遇见n个怪物,每个怪物的防御力为b1,b2,b3...bn. 如果遇到的怪物防御力bi小于等于小易的当前能力
 * 值c,那么他就能轻松打败怪物,并 且使得自己的能力值增加bi;如果bi大于c,那他也能打败怪物,但他的能力值只能
 * 增加bi 与c的最大公约数.那么问题来了,在一系列的锻炼后,小易的最终能力值为多少?
 * <p>
 * 输入描述：对于每组数据,第一行是两个整数n(1≤n<100000)表示怪物的数量和a表示小易的初始能力值.
 * 第二行n个整数,b1,b2...bn(1≤bi≤n)表示每个怪物的防御力
 * <p>
 * 输出描述：对于每组数据,输出一行.每行仅包含一个整数,表示小易的最终能力值
 */
public class GetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }

            for (int b : array) {
                if (b <= a)
                    a += b;
                else {
                    int maxCon = maxConvention(a, b);
                    a += maxCon;
                }
            }
            System.out.println(a);
        }
        sc.close();
    }

    private static int maxConvention(int a, int b) {
        int maxCon = 1;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0 && b % i == 0 && maxCon < i)
                maxCon = i;
        }
        return maxCon;
    }
}
