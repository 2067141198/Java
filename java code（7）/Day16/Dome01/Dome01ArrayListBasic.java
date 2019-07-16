import java.util.ArrayList;

public class Dome01ArrayListBasic {
    public static void main(String[] args) {
        ArrayList<String> listA = new ArrayList<>();
        //错误的写法
        //ArrayList<int> listB = new ArrayList<>();

        ArrayList<Integer> listB = new ArrayList<>();
        listB.add(100);
        listB.add(200);

        System.out.println(listB);

        int num = listB.get(1);
        System.out.println("第一号元素是：" + num);
    }
}
