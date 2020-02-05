package day02;

import java.util.Scanner;

/**
 * 求两个正整数的最大公约数
 */
public class Test06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("第一个数:");
        int n1 = sc.nextInt();
        System.out.print("第二个数:");
        int n2 = sc.nextInt();
        if (n2 > n1) {
            int tmp = n1;
            n1 = n2;
            n2 = tmp;
        }

        for (int i = n2; i > 0; i--) {
            if (n2 % i == 0 && n1 % i == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
