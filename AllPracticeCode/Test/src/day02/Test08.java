package day02;

/**
 * 编写程序数一下 1到 100 的所有整数中出现多少个数字9
 */
public class Test08 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 10 == 9)
                count++;
            if (i / 10 == 9) count++;
        }
        System.out.println(count);
    }
}
