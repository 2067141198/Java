import java.util.ArrayList;
import java.util.Scanner;

public class Dome01PrintSmallNum2 {
    public static void main(String[] args) {
        //创建一个ArrayList集合的对象
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        /*
        * 1.通过键盘输入数组中的元素
        * 2.先通过Scanner输入元素的个数
        * */
        System.out.print("请输入你要创建数组的元素个数：");
        int listLength = sc.nextInt();

        for (int i = 0; i < listLength; i++) {
            System.out.print("你要输入第" + i + "的元素是：");
            int num = sc.nextInt();
            list.add(num);
        }
        System.out.println(list);

        /*
        * 通过键盘输入需要得到的前k个的最小的数字
        * */
        System.out.print("请输入需要得到最小的数字的个数：");
        int k = sc.nextInt();

        /*
        * 将数组中的元素按从小到大重新排序
        * */
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if(list.get(i) > list.get(j)) {

                }
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.println(list.get(i));
        }
    }
}
