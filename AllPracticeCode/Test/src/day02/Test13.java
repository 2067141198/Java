package day02;

import java.util.Scanner;

/**
 * 输出一个整数的每一位
 */
public class Test13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        printBit(num);
    }

    private static void printBit(int num) {
        if (num < 10) {
            System.out.println(num);
            return;
        }
        printBit(num / 10);
        System.out.println(num % 10);
    }
}
