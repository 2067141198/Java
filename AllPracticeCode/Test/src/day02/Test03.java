package day02;

/**
 * 打印 1 - 100 之间所有的素数
 */
public class Test03 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            boolean flag = false;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.println(i);
        }
    }
}
