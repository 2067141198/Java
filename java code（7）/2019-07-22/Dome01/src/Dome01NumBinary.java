import java.util.Scanner;

/*
* 输入一个数字，输出给数字在内存中二进制1的个数，正数负数都可以计算*/
public class Dome01NumBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int tmp = 0;
        if(num >= 0) {
            while (num != 0) {
                if (num % 2 == 1) {
                    tmp++;
                }
                num /= 2;
            }
        } else {
            /*
            * 先将负数转换为二进制互为补码的正整数；
            * 负数与其对应正数小1的数的二进制互为补码
            * 计算出补码中1的个数
            * 便是负数中0的个数
            * int为8字节共32位
            * 减去0的个数便是负数二进制中1的个数*/
            int num2 = (-num) - 1;
            while(num2 != 0) {
                if(num2 % 2 == 1) {
                    tmp--;
                }
                num2 /= 2;
            }
            tmp += 32;
            //System.out.println(num2);
        }
        System.out.println(num + "的二進制中1的个数是：" + tmp);
    }
}
