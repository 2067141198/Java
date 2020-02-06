package day03;

import java.util.Scanner;

/**
 * 递归求 1 + 2 + 3 + ... + 10
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = faction(n);
        System.out.println(result);
    }

    private static int faction(int n) {
        if (n == 1)
            return 1;
        return n + faction(n - 1);
    }
}
