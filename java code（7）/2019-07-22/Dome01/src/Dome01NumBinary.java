import java.util.Scanner;

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
            int num2 = (-num) - 1;
            while(num2 != 0) {
                if(num2 % 2 == 1) {
                    tmp--;
                }
                num2 /= 2;
            }
            tmp += 64;
            //System.out.println(num2);
        }
        System.out.println(num + "的二進制中1的个数是：" + tmp);
    }
}
