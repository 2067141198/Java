package Strings;

import java.util.Scanner;

/**
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换
 * 后的数字就是它了。
 */
public class IPAdressToIntger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] str = sc.nextLine().replace('.', ' ').split(" ");
            if (str.length == 1) {
                int[] array = new int[32];
                long num = Long.parseLong(str[0]);
                int[] strs = new int[4];
                for (int i = array.length - 1; i >= 0; i--) {
                    array[i] = (int) (num % 2);
                    num /= 2;
                }
                int index = array.length - 1;
                for (int i = strs.length - 1; i >= 0; i--) {
                    strs[i] = 0;
                    for (int j = 0; j < 8; j++) {
                        strs[i] += array[index--] * Math.pow(2, j);
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < strs.length; i++) {
                    if (i == strs.length - 1)
                        sb.append(strs[i]);
                    else
                        sb.append(strs[i]).append(".");
                }
                System.out.println(sb.toString());
            } else {
                int[] array = new int[32];
                int index = array.length - 1;
                for (int i = str.length - 1; i >= 0; i--) {
                    int n = Integer.parseInt(str[i]);
                    for (int j = 0; j < 8; j++) {
                        array[index--] = n % 2;
                        n /= 2;
                    }
                }
                long result = 0;
                for (int i = array.length - 1; i >= 0; i--) {
                    result += (long) (array[i] * Math.pow(2, array.length - 1 - i));
                }
                System.out.println(result);
            }
        }
    }
}
