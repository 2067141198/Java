package day02;

import java.util.Scanner;

/**
 * 判定一个数字是否是素数
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean flag = false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        if (flag)
            System.out.println("不是素数");
        else
            System.out.println("是素数");
    }
}
