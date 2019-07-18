import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dome01Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int tmp = sc.nextInt();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt(tmp) + 1;
            System.out.println("第" + i + "个数字是：" + num);
            list.add(num);
        }

        System.out.println(list);
    }
}
