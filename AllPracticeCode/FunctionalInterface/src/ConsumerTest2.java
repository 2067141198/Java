import java.util.function.Consumer;

public class ConsumerTest2 {
    public static void main(String[] args) {
        String[] strArray = {"林青霞,30", "张曼玉,35", "王祖贤,33"};

        operatorString(strArray, s -> {
            System.out.println("姓名是：" + s.split(",")[0]);
        }, s -> {
            System.out.println("年龄是：" + Integer.parseInt(s.split(",")[1]));
        });

    }

    public static void operatorString(String[] str, Consumer<String> con1, Consumer<String> con2) {
        for (String s : str) {
            con1.andThen(con2).accept(s);
        }
    }
}
