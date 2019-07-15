import java.util.ArrayList;

public class Dome02ArrayListMethod {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);

        //向集合中添加元素
        boolean b = list.add("王一");
        System.out.println(list);
        System.out.println("添加动作是否成功：" + b);

        list.add("王二");
        list.add("王三");
        list.add("王四");
        System.out.println(list);

        //从集合中获取元素：get
        String name = list.get(2);
        System.out.println("第二号索引位置：" + name);

        //从集合中删除元素：remove
        String whoRemoved = list.remove(3);
        System.out.println("被删除的元素是：" + whoRemoved);
        System.out.println(list);

        //获取集合中元素的个数：size
        int size = list.size();
        System.out.println("集合的长度是：" + size);
    }
}
