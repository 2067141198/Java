package day02;

import java.util.Random;
import java.util.Scanner;

/**
 * 完成猜数字游戏
 */
public class Test14 {
    public static void main(String[] args) {
        Random random = new Random();
        int tmp = random.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("请输入要猜的数字:");
            int n = sc.nextInt();
            if (n < tmp) {
                System.out.println("猜小了");
            } else if (n > tmp) {
                System.out.println("猜大了");
            } else {
                System.out.println("猜对了");
                break;
            }
        }
        sc.close();
    }
}
