package day03;

import java.util.Scanner;

/**
 * 求斐波那契数列的第 N 项
 */
public class Test05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = faction(n);
        System.out.println(result);
    }

    private static int faction(int n) {
        if (n == 1 || n == 2)
            return 1;
        return faction(n - 1) + faction(n - 2);
    }
}
