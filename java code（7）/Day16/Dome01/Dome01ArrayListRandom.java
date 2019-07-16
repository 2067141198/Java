import java.util.ArrayList;
import java.util.Random;

/*
* 题目：
* 随机生成6个1-33的整数，添加到集合，并遍历集合
* */
public class Dome01ArrayListRandom {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            Random r= new Random();
            list.add(r.nextInt(33) + 1);
        }

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
