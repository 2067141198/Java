package day03;

import java.util.Scanner;

/**
 * 按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4)
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        faction(n);
    }

    private static void faction(int n) {
        if (n > 9)
            faction(n / 10);
        System.out.println(n % 10);
    }
}
