package day02;

import java.util.Scanner;

/**
 * 编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输
 * 入，最多输入三次。三次均错，则提示退出程序
 */
public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int password = 123;
        for (int i = 0; i < 3; i++) {
            System.out.print("请输入密码：");
            int pw = sc.nextInt();
            if (pw == password)
                System.out.println("Login in");
            else
                System.out.println("密码错误，还剩" + (2 - i) + "次机会");
        }
    }
}
