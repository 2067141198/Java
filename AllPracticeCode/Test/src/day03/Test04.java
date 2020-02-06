package day03;

import java.util.Scanner;

/**
 * 写一个递归方法，输入一个非负整数，返回组成它的数字之和.
 */
public class Test04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = faction(n);
        System.out.println(result);
    }

    private static int faction(int n) {
        if (n < 10)
            return n;
        return n % 10 + faction(n / 10);
    }
}
