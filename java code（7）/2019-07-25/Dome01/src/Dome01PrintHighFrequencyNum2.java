import java.util.ArrayList;
import java.util.Scanner;

public class Dome01PrintHighFrequencyNum2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入创建数组的长度：");
        int listLen = sc.nextInt();//创建数组的长度

        //在list集合中存入元素
        for (int i = 0; i < listLen; i++) {
            System.out.print("请输入下标为" + i + "处的元素：" );
            list.add(sc.nextInt());
        }

        System.out.print("创建的数组为：");
        System.out.println(list);

        //创建集合array用来存对应下标元素出现的次数
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int tmp = 0;
            for (int j = 0; j < list.size(); j++) {
                if(list.get(i) == list.get(j)) {
                    tmp++;
                }
            }
            array.add(tmp);
        }

        System.out.print("存有自定义创建数组中各元素出现次数的数组");
        System.out.println(array);

        for (int i = 0; i < array.size(); i++) {
            if(array.get(i) > (list.size() / 2)) {
                System.out.println(list.get(i));
                break;
            }
        }
    }
}
