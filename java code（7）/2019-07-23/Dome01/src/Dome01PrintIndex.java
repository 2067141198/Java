import java.util.ArrayList;
import java.util.Scanner;

public class Dome01PrintIndex {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        //count:输入数组的长度
        System.out.print("请输入你要输入数组的长度：");
        int count = sc.nextInt();
        System.out.println("请输入在数组中存入的元素：" );
        for (int i = 0; i < count; i++) {
            System.out.print("第" + i + "的元素是：");
            int num = sc.nextInt();
            list.add(num);
        }
        System.out.println(list);
    }
}
