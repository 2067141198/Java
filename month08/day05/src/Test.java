import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int tmp  = i;
        int count = 0;
        while(i > 1) {
            i /= 2;
            count++;
        }

        if(i % 2 == 0) {
            System.out.println("输入的数字" + tmp + "是2的" + count + "次方");
        } else {
            System.out.println("该数不是2的整数次方");
        }
    }
}
