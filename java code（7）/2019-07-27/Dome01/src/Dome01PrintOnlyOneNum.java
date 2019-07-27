import java.util.ArrayList;
import java.util.Scanner;

public class Dome01PrintOnlyOneNum {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入需要创建的数组的大小：");
        int listLen = sc.nextInt();

        for (int i = 0; i < listLen; i++) {
            System.out.print("请输入下标为" + i + "处的元素：");
            int num = sc.nextInt();
            list.add(num);
        }

        //打印创建好的数组
        System.out.println(list);

        //用来存储每个元素出现的次数
        ArrayList<Integer> listAppear = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int appearTime = 0;
            for (int j = 0; j < list.size(); j++) {
                if(list.get(i) == list.get(j)) {
                    appearTime++;
                }
            }
            listAppear.add(appearTime);
        }

        //打印对应下标位置处元素出现的次数
        System.out.println(listAppear);

        for (int i = 0; i < list.size(); i++) {
            if(listAppear.get(i) == 1) {
                System.out.println(list.get(i));
            }
        }
    }
}
