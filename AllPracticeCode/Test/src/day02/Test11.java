package day02;

import java.util.Scanner;

/**
 * 写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4个1
 */
public class Test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int num = sc.nextInt();
        while (num > 0) {
            if (num % 2 == 1)
                count++;
            num /= 2;
        }
        System.out.println(count);
    }
}
