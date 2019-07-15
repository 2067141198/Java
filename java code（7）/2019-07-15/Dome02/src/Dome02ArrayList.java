import java.util.ArrayList;

/*
* 数组的长度不可以发生改变
* 但是ArrayList集合的长度是可以发生变化的
*
* */
public class Dome02ArrayList {
    public static void main(String[] args) {
        //创建一个ArrayList集合，集合的名称是list，里面装的都是String字符串类型的数据
        //备注：从JDK1.7之后，右侧的尖括号内部可以不写内容，但是尖括号<>本身还是要写的
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);

        list.add("张三");
        System.out.println(list);

        list.add("李四");
        list.add("王麻子");
        System.out.println(list);
    }
}
