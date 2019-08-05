import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int tmp  = i; //定义一个tmp用来保存i的值
        int count = 0;//用来计输入的数为2的次方幂

        //先通过取模判断输入的数是否是2的整数次方
        while(i >= 2) {
            i %= 2;
        }

        if(i % 2 != 0) {
            System.out.println("该数不是2的整数次方");
        } else {

            //来计算数字i的次方幂
            //因为1是2的0次方，所以只能以输入的数字i大于等于2时来作为循环条件
            while(tmp >= 2) {
                count++;
                tmp /= 2;
            }
            System.out.println("输入的数字是2的" + count + "次方");
        }
    }
}



