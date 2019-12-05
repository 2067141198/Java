package Maths;

import java.util.Scanner;

public class NumSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int result1 = getSumOfBit(num);
            int result2 = getSumOfBit(num * num);

            System.out.println(result1 + " " + result2);
        }
    }

    private static int getSumOfBit(int n) {
        int tmp = 0;
        while (n > 0) {
            tmp += n % 10;
            n /= 10;
        }
        return tmp;
    }
}
