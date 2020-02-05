package day02;

import java.util.Scanner;

/**
 * 获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
 */
public class Test12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int count = 1;
        while (num > 0) {
            if (count % 2 == 1) {
                sb1.append(num % 2);
                count++;
            } else {
                sb2.append(num % 2);
                count++;
            }
            num /= 2;
        }
        System.out.println("奇数位的二进制序列为" + sb1.reverse());
        System.out.println("偶数位的二进制序列为" + sb2.reverse());
    }
}
